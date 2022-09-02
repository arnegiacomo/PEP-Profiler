package no.arnemunthekaas.ui;

import com.google.gson.JsonObject;
import no.arnemunthekaas.model.Pep;
import no.arnemunthekaas.service.RestClient;
import org.apache.commons.text.WordUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Frame extends javax.swing.JFrame {

    // Static access
    public static Frame frame;
    private static int defaultWidth = 1280;
    private static int defaultHeight = 720;
    private int minWidth = 250;
    private int minHeight = 250;


    private JPanel jPanel;
    public Frame() {
        super("Pep-Profiler");
        frame = this;
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        createMenuTab();

        /*List<Pep> test = new ArrayList<Pep>();
        Pep pep = RestClient.restClient.pepSearch(RestClient.SearchType.NAME, "Erna Solberg").get(0);
        test.add(pep);

        this.jPanel = new Panel(Panel.PanelType.PROFILEVIEW, test);
        this.add(new Panel(Panel.PanelType.PROFILEVIEW, test));*/

        this.setSize(defaultWidth, defaultHeight);
        frame.setMinimumSize(new Dimension(minWidth, minHeight));
        centerFrame();
    }

    private void createMenuTab() {
        JMenuBar menuBar = new JMenuBar();

        // Search
        JMenu menuSearch = new JMenu("Search");
        menuSearch.add(new JMenuItem(new AbstractAction("Name") {
            public void actionPerformed(ActionEvent e) {
                List<Pep> peps = RestClient.restClient.pepSearch(RestClient.SearchType.NAME, WordUtils.capitalizeFully(JOptionPane.showInputDialog("Search by name:")));
                frame.changePanel(new Panel(Panel.PanelType.RESULTS, peps));
            }
        }));

        menuSearch.add(new JMenuItem(new AbstractAction("Address") {
            public void actionPerformed(ActionEvent e) {
                RestClient.restClient.pepSearch(RestClient.SearchType.ADDRESS, JOptionPane.showInputDialog("Search by address:"));
                // TODO
            }
        }));
        menuSearch.add(new JMenuItem(new AbstractAction("Email") {
            public void actionPerformed(ActionEvent e) {
                RestClient.restClient.pepSearch(RestClient.SearchType.EMAIL, JOptionPane.showInputDialog("Search by email:"));
                // TODO
            }
        }));
        menuSearch.add(new JMenuItem(new AbstractAction("Phone") {
            public void actionPerformed(ActionEvent e) {
                RestClient.restClient.pepSearch(RestClient.SearchType.PHONE, JOptionPane.showInputDialog("Search by phone:"));
                // TODO
            }
        }));
        menuSearch.add(new JMenuItem(new AbstractAction("Country") {
            public void actionPerformed(ActionEvent e) {
                RestClient.restClient.pepSearch(RestClient.SearchType.COUNTRY, JOptionPane.showInputDialog("Search by country abbreviation:"));
                // TODO
            }
        }));

        menuBar.add(menuSearch);

        // File
        // TODO
        JMenu menuFile = new JMenu("File");
        menuFile.add(new JMenuItem("Save"));
        menuFile.add(new JMenuItem("Load"));
        menuFile.add(new JMenuItem("Export"));
        menuBar.add(menuFile);

        // Edit
        // TODO
        JMenu menuEdit = new JMenu("Edit");
        menuEdit.add(new JMenuItem("Add notes"));
        menuBar.add(menuEdit);

        // View
        // TODO
        JMenu menuView = new JMenu("View");
        menuView.add(new JMenuItem("Resolution"));
        menuBar.add(menuView);

        this.setJMenuBar(menuBar);
    }

    private void changePanel(Panel newPanel) {
        if(jPanel != null) {
            jPanel.invalidate();
            frame.remove(jPanel);
        }
        Panel panel = newPanel;
        frame.add(panel);
        frame.jPanel = panel;

        frame.invalidate();
        frame.validate();
    }

    public void profilePanel(Pep pep) {
        ArrayList<Pep> peps = new ArrayList<Pep>();
        peps.add(pep);
        changePanel(new Panel(Panel.PanelType.PROFILEVIEW, peps));
    }

    private void centerFrame() {
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2 , (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2 );
    }

    public static int getDefaultWidth() {
        return defaultWidth;
    }

    public static int getDefaultHeight() {
        return defaultHeight;
    }
}

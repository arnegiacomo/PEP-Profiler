package no.arnemunthekaas.ui;

import no.arnemunthekaas.model.Pep;
import no.arnemunthekaas.service.RestClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Frame extends javax.swing.JFrame {

    // Static access
    public static Frame frame;
    private int width = 1280;
    private int height = 720;
    private int minWidth = 250;
    private int minHeight = 250;


    private JPanel jPanel;
    public Frame() {
        super("Pep-Profiler");
        frame = this;
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        centerFrame();
        createMenuTab();

        List<Pep> test = new ArrayList<Pep>();
        test.add(new Pep());
        this.add(new Panel(Panel.PanelType.PROFILEVIEW, test));

        this.setSize(width, height);
        frame.setMinimumSize(new Dimension(minWidth, minHeight));
    }

    private void createMenuTab() {
        JMenuBar menuBar = new JMenuBar();

        // Search
        JMenu menuSearch = new JMenu("Search");
        menuSearch.add(new JMenuItem(new AbstractAction("Name") {
            public void actionPerformed(ActionEvent e) {
                RestClient.restClient.pepSearch(RestClient.SearchType.NAME, JOptionPane.showInputDialog("Search by name:"));
                // TODO
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

    private void centerFrame() {
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - width) / 2 , (Toolkit.getDefaultToolkit().getScreenSize().height - height) / 2 );
    }
}

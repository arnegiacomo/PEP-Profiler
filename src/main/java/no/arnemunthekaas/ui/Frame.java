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
    private int minWidth = 1000;
    private int minHeight = 600;


    private JPanel jPanel;
    public Frame() {
        super("Pep-Profiler");
        frame = this;
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        createMenuTab();

        this.setSize(defaultWidth, defaultHeight);
        // this.setResizable(false);
        frame.setMinimumSize(new Dimension(minWidth, minHeight));
        centerFrame();
    }

    private void createMenuTab() {
        JMenuBar menuBar = new JMenuBar();

        // Search
        JMenu menuSearch = new JMenu("Search");
        menuSearch.add(new JMenuItem(new AbstractAction("PEP-Search") {
            public void actionPerformed(ActionEvent e) {
                List<Pep> peps = RestClient.restClient.pepSearch(RestClient.SearchType.NAME, WordUtils.capitalizeFully(JOptionPane.showInputDialog(null, "Search for PEP:", "Search", JOptionPane.PLAIN_MESSAGE)));
                frame.changePanel(new Panel(Panel.PanelType.RESULTS, peps));
            }
        }));

        menuBar.add(menuSearch);

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

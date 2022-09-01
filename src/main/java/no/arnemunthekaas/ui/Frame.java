package no.arnemunthekaas.ui;

import no.arnemunthekaas.service.RestClient;
import no.arnemunthekaas.service.SearchType;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Frame extends javax.swing.JFrame {

    // Static access
    public static Frame frame;
    private int width = 1280;
    private int height = 720;

    public Frame() {
        super("Pep-Profiler");
        frame = this;

        this.setVisible(true);
        centerFrame();


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextField textFieldUserName = new JTextField(50);
        this.add(textFieldUserName, BorderLayout.CENTER);

        createSearchTab();

        this.setSize(width, height);
    }

    private void createSearchTab() {
        JMenuBar menuBar = new JMenuBar();

        // Search
        JMenu menuSearch = new JMenu("Search");
        menuSearch.add(new JMenuItem(new AbstractAction("Name") {
            public void actionPerformed(ActionEvent e) {
                RestClient.restClient.pepSearch(SearchType.NAME, JOptionPane.showInputDialog("Search by name:"));
                // TODO
            }
        }));

        menuSearch.add(new JMenuItem(new AbstractAction("Address") {
            public void actionPerformed(ActionEvent e) {
                RestClient.restClient.pepSearch(SearchType.ADDRESS, JOptionPane.showInputDialog("Search by address:"));
                // TODO
            }
        }));
        menuSearch.add(new JMenuItem(new AbstractAction("Email") {
            public void actionPerformed(ActionEvent e) {
                RestClient.restClient.pepSearch(SearchType.EMAIL, JOptionPane.showInputDialog("Search by email:"));
                // TODO
            }
        }));
        menuSearch.add(new JMenuItem(new AbstractAction("Phone") {
            public void actionPerformed(ActionEvent e) {
                RestClient.restClient.pepSearch(SearchType.PHONE, JOptionPane.showInputDialog("Search by phone:"));
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
        menuEdit.add(new JMenuItem("Change name"));

        menuBar.add(menuEdit);

        // View
        // TODO
        JMenu menuView = new JMenu("View");
        menuView.add(new JMenuItem("Resolution"));
        menuView.add(new JMenuItem("Save to"));
        menuView.add(new JMenuItem("Export"));
        menuBar.add(menuView);

        this.setJMenuBar(menuBar);
    }

    private void centerFrame() {
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - width) / 2 , (Toolkit.getDefaultToolkit().getScreenSize().height - height) / 2 );
    }
}

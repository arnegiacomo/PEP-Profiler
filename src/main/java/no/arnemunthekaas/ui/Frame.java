package no.arnemunthekaas.ui;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Frame extends javax.swing.JFrame {

    private int width = 1280;
    private int height = 720;

    public Frame() {
        super("Pep-Profiler");
        this.setVisible(true);


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
                String input = JOptionPane.showInputDialog("Search by name:");

            }
        }));

        menuSearch.add(new JMenuItem("Address"));
        menuSearch.add(new JMenuItem("Email"));
        menuSearch.add(new JMenuItem("Phone"));
        menuBar.add(menuSearch);

        // File
        JMenu menuFile = new JMenu("File");
        menuFile.add(new JMenuItem("Save"));
        menuFile.add(new JMenuItem("Save to"));
        menuFile.add(new JMenuItem("Export"));
        menuBar.add(menuFile);

        // View
        JMenu menuView = new JMenu("View");
        menuFile.add(new JMenuItem("Resolution"));
        menuFile.add(new JMenuItem("Save to"));
        menuFile.add(new JMenuItem("Export"));
        menuBar.add(menuFile);

        this.setJMenuBar(menuBar);
    }
}

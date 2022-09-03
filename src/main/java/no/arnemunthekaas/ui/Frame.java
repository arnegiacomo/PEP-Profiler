package no.arnemunthekaas.ui;

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
    private static final int defaultWidth = 1280;
    private static final int defaultHeight = 720;


    private JPanel jPanel;
    private JScrollPane jScrollPane;
    public Frame() {
        super("Pep-Profiler");
        frame = this;
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        createMenuTab();

        this.setSize(defaultWidth, defaultHeight);
        this.setResizable(false);
        centerFrame();

        this.changePanel(new Panel(Panel.PanelType.HOME, null));
    }

    private void createMenuTab() {
        JMenuBar menuBar = new JMenuBar();

        menuBar.add(new JButton(new AbstractAction("Home") {
            public void actionPerformed(ActionEvent e) {
                frame.changePanel(new Panel(Panel.PanelType.HOME, null));
            }
        }));

        menuBar.add(new JButton(new AbstractAction("Search") {
            public void actionPerformed(ActionEvent e) {
                List<Pep> peps = RestClient.restClient.pepSearch(RestClient.SearchType.NAME, WordUtils.capitalizeFully(JOptionPane.showInputDialog(null, "Search for PEP:", "Search", JOptionPane.PLAIN_MESSAGE)));
                frame.changePanel(new Panel(Panel.PanelType.RESULTS, peps));
            }
        }));

        menuBar.add(new JButton(new AbstractAction("Save") {
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        }));

        this.setJMenuBar(menuBar);
    }

    private void changePanel(Panel newPanel) {
        if(jPanel != null) {
            jPanel.invalidate();
            frame.remove(jPanel);
        }

        if(jScrollPane != null) {
            jScrollPane.invalidate();
            frame.getContentPane().remove(jScrollPane);
        }

        frame.getContentPane().add(newPanel);
        frame.jPanel = newPanel;

        JScrollPane jsp = new JScrollPane(newPanel);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add(jsp);
        frame.jScrollPane = jsp;

        frame.invalidate();
        frame.validate();
    }

    public void profilePanel(Pep pep) {
        ArrayList<Pep> peps = new ArrayList<>();
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

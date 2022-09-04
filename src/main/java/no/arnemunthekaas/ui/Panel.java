package no.arnemunthekaas.ui;

import no.arnemunthekaas.model.Pep;
import no.arnemunthekaas.model.Profile;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JPanel {

    public Profile profile;

    public enum PanelType {
        HOME,
        RESULTS,
        LOADPANEL,
        PROFILEVIEW
    }

    public Panel(PanelType panelType, List<Pep> peps, Profile profile) {
        super();

        switch (panelType) {
            case HOME -> createHomePanel();
            case RESULTS -> createResultsPanel(peps);
            case PROFILEVIEW -> createProfileViewPanel(profile);
            case LOADPANEL -> createLoadPanel();
        }
    }

    private void createLoadPanel() {
        this.profile = null;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        if(Profile.cache.size() == 0) {
            this.addTextArea("No profiles saved", BorderLayout.CENTER, Frame.frame.getWidth());
            return;
        }

        Profile.cache.forEach(this::addProfileButton);
    }

    private void createProfileViewPanel(Profile profile) {
        this.setLayout(new BorderLayout());
        this.profile = profile;
        createProfileTitle(profile.getName(), 2);
        addTextArea(profile.getPep().toSexyPepString(), BorderLayout.WEST, 250);
        addTextArea(profile.getDescription(), BorderLayout.CENTER, 600);
        addImageArea(profile.getImageUrl());
    }

    private void createResultsPanel(List<Pep> peps) {
        this.profile = null;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        if(peps == null) peps = new ArrayList<>();
        if(peps.size() == 0) {
            this.addTextArea("No results", BorderLayout.CENTER, Frame.frame.getWidth());
            return;
        }

        peps.forEach(this::addResultButton);
    }

    private void createHomePanel() {
        this.profile = null;
        this.setLayout(new BorderLayout());
        createProfileTitle("PEP-Profiler", 0);
        addTextArea("Test",BorderLayout.CENTER, Frame.getDefaultWidth() - 20);
    }

    private void addProfileButton(Profile profile) {
        JButton button = new JButton (new AbstractAction(profile.getPep().toSexyButtonString()) {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.frame.loadProfilePanel(profile);
            }
        });
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setMaximumSize(new Dimension(Frame.getDefaultWidth() - 20, 150));
        this.add (button);
    }

    private void addResultButton(Pep pep) {
        JButton button = new JButton (new AbstractAction(pep.toSexyButtonString()) {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.frame.profilePanel(pep);
            }
        });
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setMaximumSize(new Dimension(Frame.getDefaultWidth() - 20, 150));
        this.add (button);
    }

    private void addTextArea(String content, String borderLayout, int width) {
        JTextArea textArea = new JTextArea(content);
        textArea.setBorder(new EmptyBorder(15, 15, 15, 15));
        textArea.setSize(width, (int) (Frame.getDefaultHeight() / 1.5));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        this.add(textArea, borderLayout);
    }


    private void createProfileTitle(String name, int thickness) {
        JLabel jLabel = new JLabel(name, SwingConstants.CENTER);
        jLabel.setBorder(new LineBorder(Color.DARK_GRAY, thickness, true));
        jLabel.setSize(Frame.frame.getWidth(), 50);
        jLabel.setFont (jLabel.getFont ().deriveFont (64.0f));
        this.add(jLabel, BorderLayout.PAGE_START);
    }

    private void addImageArea(String urlStr) {
        BufferedImage image;
        Image scaledImage;

        if (urlStr.equals("")) return;

        try {
            URL url = new URL(urlStr);
            image = ImageIO.read(url);
            int ratio = image.getHeight() / image.getWidth();
            scaledImage = image.getScaledInstance(300, 300 * ratio + 150, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JLabel label = new JLabel(new ImageIcon(scaledImage));
        label.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(label, BorderLayout.EAST);
    }


}


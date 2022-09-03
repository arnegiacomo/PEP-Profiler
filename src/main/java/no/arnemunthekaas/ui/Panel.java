package no.arnemunthekaas.ui;

import no.arnemunthekaas.model.Pep;
import no.arnemunthekaas.model.Profile;
import no.arnemunthekaas.service.RestClient;

import javax.imageio.ImageIO;
import javax.management.remote.JMXProviderException;
import javax.swing.*;
import javax.swing.border.BevelBorder;
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

    public enum PanelType {
        HOME,
        RESULTS,
        PROFILEVIEW
    }

    public Panel(PanelType panelType, List<Pep> peps) {
        super();

        switch (panelType) {
            case HOME -> createHomePanel();
            case RESULTS -> createResultsPanel(peps);
            case PROFILEVIEW -> createProfileViewPanel(peps.get(0));
        }
    }

    private void createProfileViewPanel(Pep pep) {
        this.setLayout(new BorderLayout());
        Profile profile = new Profile(pep);
        createProfileTitle(profile.getName());
        addTextArea(profile.getPep().toSexyPepString(), BorderLayout.WEST, 250);
        addTextArea(profile.getDescription(), BorderLayout.CENTER, 600);
        addImageArea(profile.getImageUrl(), BorderLayout.EAST);
    }

    private void createResultsPanel(List<Pep> peps) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        if(peps == null) peps = new ArrayList<>();
        if(peps.size() == 0) {
            this.addTextArea("No results", BorderLayout.CENTER, Frame.frame.getWidth());
            return;
        }

        peps.forEach(pep -> {
            this.addResultButton(pep);
        });
    }

    private void createHomePanel() {
    }

    private void addResultButton(Pep pep) {
        JButton button = new JButton (new AbstractAction(pep.toSexyButtonString()) {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.frame.profilePanel(pep);
            }
        });
        button.setHorizontalAlignment(SwingConstants.LEFT);

        this.add (button);
    }

    private void addTextArea(String content, String borderLayout, int width) {
        JTextArea textArea = new JTextArea(content);
        textArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        textArea.setSize(width, (int) (Frame.getDefaultHeight() / 1.5));
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        this.add(textArea, borderLayout);
    }


    private void createProfileTitle(String name) {
        JLabel jLabel = new JLabel(name, SwingConstants.CENTER);
        jLabel.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
        jLabel.setSize(Frame.frame.getWidth(), 50);
        jLabel.setFont (jLabel.getFont ().deriveFont (64.0f));
        this.add(jLabel, BorderLayout.PAGE_START);
    }

    private void addImageArea(String urlStr, String borderLayout) {
        BufferedImage image;
        Image scaledImage;

        if (urlStr == "") return;

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
        this.add(label, borderLayout);
    }


}


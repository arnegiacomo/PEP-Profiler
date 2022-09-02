package no.arnemunthekaas.ui;

import no.arnemunthekaas.model.Pep;
import no.arnemunthekaas.model.Profile;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
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
        addTextArea(profile.getName(), BorderLayout.PAGE_START);
        addTextArea(profile.getPepInfo(), BorderLayout.WEST);
        addTextArea(profile.getDescription(), BorderLayout.CENTER);
        addImageArea(profile.getImageUrl(), BorderLayout.EAST);
    }

    private void createResultsPanel(List<Pep> peps) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        peps.forEach(pep -> {
            this.addResultButton(pep);
        });
    }

    private void addResultButton(Pep pep) {
        JButton button = new JButton (pep.toString());
        this.add (button);
    }

    private void createHomePanel() {
    }

    private void addTextArea(String content, String borderLayout) {
        JTextArea textArea = new JTextArea(content);
        textArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        this.add(textArea, borderLayout);
    }

    private void addImageArea(String urlStr, String borderLayout) {
        BufferedImage image;
        Image scaledImage;

        try {
            URL url = new URL(urlStr);
            image = ImageIO.read(url);
            scaledImage = image.getScaledInstance(Frame.getDefaultWidth() / 4, (int) (Frame.getDefaultHeight() / 1.5), Image.SCALE_SMOOTH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JLabel label = new JLabel(new ImageIcon(scaledImage), SwingConstants.NORTH_EAST);
        label.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(label, borderLayout);
    }


}


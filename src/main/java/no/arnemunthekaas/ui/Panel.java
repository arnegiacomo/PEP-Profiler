package no.arnemunthekaas.ui;

import no.arnemunthekaas.model.Pep;

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
        this.setLayout(new BorderLayout());

        switch (panelType) {
            case HOME -> createHomePanel();
            case RESULTS -> createResultsPanel(peps);
            case PROFILEVIEW -> createProfileViewPanel(peps.get(0));
        }
    }

    private void createProfileViewPanel(Pep pep) {
        addTextArea(pep.getName(), BorderLayout.PAGE_START);
        addTextArea("Left", BorderLayout.WEST);
        addTextArea("Mid", BorderLayout.CENTER);
        addImageArea("https://upload.wikimedia.org/wikipedia/commons/0/05/Wil_Lee-Wright_foto_Rein_Traante2017_MG_0419_%2832592903182%29.jpg", BorderLayout.EAST);
    }

    private void createResultsPanel(List<Pep> peps) {
    }

    private void createHomePanel() {
    }

    private void addTextArea(String content, String borderLayout) {
        JLabel label = new JLabel(content, SwingConstants.CENTER);
        label.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(label, borderLayout);
    }

    private void addImageArea(String urlStr, String borderLayout) {
        BufferedImage image;
        Image scaledImage;

        try {
            URL url = new URL(urlStr);
            image = ImageIO.read(url);
            scaledImage = image.getScaledInstance(200, 200, Image.SCALE_FAST);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JLabel label = new JLabel(new ImageIcon(scaledImage), SwingConstants.CENTER);
        label.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(label, borderLayout);
    }


}


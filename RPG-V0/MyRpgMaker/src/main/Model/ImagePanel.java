package Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Hermann on 01/05/2017.
 */
public class ImagePanel extends JPanel{
    private ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();

    public ImagePanel(String... filenames) {
        try {
            for (String filename : filenames) {
                images.add(ImageIO.read(new File(filename)));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ImagePanel(BufferedImage img, String... filenames){
        try {
            for (String filename : filenames) {
                images.add(ImageIO.read(new File(filename)));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.images.add(img);
    }

    public ImagePanel(BufferedImage img){
        this.images.add(img);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (BufferedImage i : images) {
            g.drawImage(i, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

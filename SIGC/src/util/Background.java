package util;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;

public class Background implements Border {

    private final BufferedImage image;
    //private final Image image;

    public Background(BufferedImage image) {
        this.image = image;
    }

    /*BackgroundCentrado(Image image) {
    this.image = image;
    }*/
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    public boolean isBorderOpaque() {
        return true;
    }

//    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
//        int x0 = x + (width - image.getWidth()) / 2;
//        int y0 = y + (height - image.getHeight()) / 2;
//        g.drawImage(image, x0, y0, null);
//    }
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        int x0 = x;
        int y0 = y;
        g.drawImage(image, x0, y0, null);
    }

}

package Model;

import java.awt.image.BufferedImage;

/**
 * Created by hugo on 27/04/17.
 */
public class Sprite extends AbstractModel{

    private BufferedImage img;
    private String path_sprite = "";

    public Sprite() {
    }
    public Sprite(BufferedImage img) {
        this.img = img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public void setPath_sprite(String path_sprite) {
        this.path_sprite = path_sprite;
    }

    public BufferedImage getImg() {
        return img;
    }

    public String getPath_sprite() {
        return path_sprite;
    }


}
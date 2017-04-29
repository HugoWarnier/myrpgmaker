package Model;

import java.util.ArrayList;

/**
 * Created by hugo on 27/04/17.
 */
public class Cell extends AbstractModel {

    ArrayList<Sprite> layer;

    private int posX;
    private int posY;

    public Cell(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void add_Sprite(Sprite spr){
        this.layer.add(spr);
    }
    public void rm_Sprite(Sprite spr){
        this.layer.remove(spr);
    }
    public void setLayer(ArrayList<Sprite> layer) {
        this.layer = layer;
    }
    public ArrayList<Sprite> getLayer() {
        return layer;
    }
}

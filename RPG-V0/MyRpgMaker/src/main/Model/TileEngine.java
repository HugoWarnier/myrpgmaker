package Model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Hermann on 29/04/2017.
 */
public class TileEngine extends JPanel{
    private ArrayList<Integer> sprites;

    public TileEngine(ArrayList<Integer> sprites){
        this.sprites = sprites;
    }

    public TileEngine(){
        this.sprites = new ArrayList<Integer>();
    }

    public TileEngine(int id){
       //construct with tile id
    }

    public ArrayList<Integer> getSprites() {
        return sprites;
    }

    public Integer getSprite(int idx){
        if (idx < this.sprites.size())
            return this.sprites.get(idx);
        else
            return null;
    }

    public void addTile(Integer i){
        this.sprites.add(i);
    }

    public void addTile(int id){
        //add tile with identifier
    }

    public void paintComponent(Graphics g){
        g.fillOval(20, 20, 75, 75);
    }
}

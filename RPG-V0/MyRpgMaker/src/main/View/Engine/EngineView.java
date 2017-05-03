package View.Engine;

import Model.*;
import Model.Character;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by hugo on 27/04/17.
 */
public class EngineView extends JFrame implements Observer{

    private GridBagLayout gl = new GridBagLayout();
    private GridBagConstraints constraint = new GridBagConstraints();
    private final int WIDTH = 640;
    private final int HEIGHT= 640;
    private World world;

    public EngineView(World world){
        this.setTitle("Game engine");
        this.setSize(WIDTH,HEIGHT);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(gl);
        this.world = world;
        MyKeyListener keyListener = new MyKeyListener();
        keyListener.addObserver(this);
        this.addKeyListener(keyListener);
        this.display();
    }

    public void display(){
        constraint.weightx = this.world.getMaps().get(0).getxSize();
        constraint.weighty = this.world.getMaps().get(0).getySize();

        //constraint.anchor = GridBagConstraints.CENTER Pour un element a centrer

        //draw background
        for (int i = 0; i < this.constraint.weightx; i++){
            for (int j = 0; j < this.constraint.weighty; j++){

                if (isThereCharacter(i, j))
                    continue;
                //print tiles
                ImagePanel ii = null;
                switch (this.world.getMaps().get(0).getMap()[i][j]){
                    case "GRASS": ii = new ImagePanel("grass.png");
                    break;

                    case "WATER": ii = new ImagePanel("sea.png");
                    break;

                    default: ii = new ImagePanel("grass.png");
                    break;
                }

                constraint.gridx = i;
                constraint.gridy = j;
                constraint.fill = GridBagConstraints.BOTH;

                this.add(ii, constraint);
            }
        }

        //draw character
        BufferedImage img = null;
        try
        {
            img = ImageIO.read(new File("hero.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        for (CharacterEngine c : this.world.getMaps().get(0).getCharacters()){
            ImagePanel ii = new ImagePanel(img.getSubimage(0, 0, 64,64),"grass.png");
            constraint.gridx = c.getPosition().getX();
            constraint.gridy = c.getPosition().getY();
            constraint.fill = GridBagConstraints.BOTH;

            this.add(ii, constraint);
        }


        /*
        BufferedImage img = null;
        try
        {
            img = ImageIO.read(new File("hero.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        BufferedImage img2 = null;
        try
        {
            img2 = ImageIO.read(new File("house.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        ImagePanel ii = new ImagePanel(img.getSubimage(0,0, 64, 64));
        constraint.gridx = 5;
        constraint.gridy = 5;
        constraint.fill = GridBagConstraints.BOTH;


        this.add(ii, constraint);

        ImagePanel i2 = new ImagePanel("grass.png", "house.png");
        constraint.gridx = 4;
        constraint.gridy = 4;
        constraint.fill = GridBagConstraints.BOTH;

        this.add(i2, constraint);

        this.remove(this.getComponentAt(0, 0));
        */

        this.setVisible(true);
    }

    private boolean isThereCharacter(int x, int y){
        for (CharacterEngine c : this.world.getMaps().get(0).getCharacters()){
            if (c.getPosition().getX() == x && c.getPosition().getY() == y)
                return true;
        }
        return false;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof MyKeyListener){
            switch (arg.toString()){
                case "up": this.world.getMaps().get(0).getCharacters().get(0).moveUp();
                break;
                case "down": this.world.getMaps().get(0).getCharacters().get(0).moveDown();
                    break;
                case "right": this.world.getMaps().get(0).getCharacters().get(0).moveRight();
                    break;
                case "left": this.world.getMaps().get(0).getCharacters().get(0).moveLeft();
                    break;
            }
        }
        this.getContentPane().removeAll();
        this.display();
    }

}

package View.Editor;

import Controller.GameEditorController;
import Model.Game;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by hugo on 27/04/17.
 */
public class EditorView extends JPanel implements Observer {

    private GameEditorController controller;
    private Game game;
    private int sizeX;
    private int sizeY;

    public EditorView(GameEditorController controller){

        this.controller = controller;
        this.game = controller.getGame();
        this.sizeX = game.getListMap().get(0).getxSize();
        this.sizeY = game.getListMap().get(0).getySize();
        game.addObserver(this);
        setSize(400,400);
        initGameBoard();
    }

    public void UpdateGameBoard(){

        this.setLayout(new GridLayout(sizeX,sizeY));
        for (int i = 0; i < sizeX ; i++) {
            for (int k = 0; k < sizeY ; k++) {
                System.out.println(game.getListMap().get(0).getMap()[i][k].getLayer().get(0).getPath_sprite());
                JButton tileBoard = new tileGameBoard(game.getListMap().get(0).getMap()[i][k].getLayer().get(0).getPath_sprite());
                this.add(tileBoard);
            }
        }
        revalidate();
        repaint();
    }

    public JPanel initGameBoard(){
        JPanel pan = new JPanel();
       setLayout(new GridLayout(sizeX,sizeY));
        for (int i = 0; i < sizeX ; i++) {
            for (int k = 0; k < sizeY ; k++) {
                JButton tileBoard = new tileGameBoard(game.getListMap().get(0).getMap()[i][k].getLayer().get(0).getPath_sprite());
                pan.add(tileBoard);
            }
        }
        return pan;
    }

    public class tileGameBoard extends JButton{

        public Image Img;
        private String path;

        public tileGameBoard(String path){
            Img = new ImageIcon(path).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (Img == null) return;
            g.drawImage(Img,0,0,getWidth(),getHeight(),this);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Game){
            switch (arg.toString()){
                case "load": UpdateGameBoard();
                    break;
                default:
                    break;
            }
        }
    }
}



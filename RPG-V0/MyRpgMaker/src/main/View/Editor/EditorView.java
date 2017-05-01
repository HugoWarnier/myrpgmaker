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
public class EditorView extends JFrame implements Observer {

    private GameEditorController controller;
    private Game game;
    private int sizeX;
    private int sizeY;

    public EditorView(GameEditorController controller){

        this.controller = controller;
        this.game = controller.getGame();
        this.sizeX = game.getListMap().get(0).getxSize();
        this.sizeY = game.getListMap().get(0).getySize();
        initGameBoard();

    }

    public JPanel initGameBoard(){

        JPanel GameBoard = new JPanel();

        GameBoard.setLayout(new GridLayout(sizeX,sizeY));

        for (int i = 0; i < sizeX ; i++) {
            for (int k = 0; k < sizeY ; k++) {
                System.out.println(game.getListMap().get(0).getMap()[i][k].getLayer().get(0).getPath_sprite());
                JButton tileBoard = new JButton(new ImageIcon(game.getListMap().get(0).getMap()[i][k].getLayer().get(0).getPath_sprite()));
                GameBoard.add(tileBoard);
            }
        }
        return GameBoard;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}

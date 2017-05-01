import Controller.GameEditorController;
import Model.Game;
import View.Application.Application;
import View.Editor.EditorView;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by hugo on 01/05/17.
 */
public class MainTest {

    public static void main(String[] args) {
        PanelTest(15,15);
    }

    public static void PanelTest(int x,int y){
        try {

            int sizeX = x;
            int sizeY = y;
            Game game = new Game(sizeX,sizeY);
            GameEditorController editor = new GameEditorController(game);
            System.out.println(editor);
            Application app = new Application(editor);
            app.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LoadMapTest(int x,int y){

        int sizeX = x;
        int sizeY = y;

        Game game = new Game(sizeX,sizeY);
        GameEditorController editor = new GameEditorController(game);
        editor.LoadMap("/home/hugo/myrpgmaker/RPG-V0/MyRpgMaker/src/main/resources/World/TEST.world");

        CardLayout cardL = new CardLayout();
        JFrame jf = new JFrame();
        JPanel j2 = new JPanel();
        JPanel j = new JPanel();
        GridLayout g = new GridLayout(sizeX,sizeY);
        g.setHgap(0);
        g.setVgap(0);
        for (int i = 0; i < sizeX ; i++) {
            for (int k = 0; k < sizeY ; k++) {
                JButton b = new JButton(new ImageIcon(game.getListMap().get(0).getMap()[i][k].getLayer().get(0).getPath_sprite()));
                j.add(b);
            }
        }
        j.setLayout(g);

        JPanel j1 = new JPanel();

        File test = new File("/home/hugo/myrpgmaker/RPG-V0/MyRpgMaker/src/main/resources/sprites");
        File[] Sprites = test.listFiles();

        for ( File s: Sprites ) {
            File[] Spr = s.listFiles();
            for ( File e: Spr ) {
                JButton b = new JButton(new ImageIcon(e.toString()));
                j1.add(b);
            }
        }

        j2.add(j1);
        j2.add(j);
        jf.add(j2);
        jf.setSize(600,400);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLayout(cardL);

    }

}

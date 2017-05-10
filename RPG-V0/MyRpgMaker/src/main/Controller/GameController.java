package Controller;

import Model.Game;
import View.Application.Application;
import View.GlobalView;

import java.io.IOException;

/**
 * Created by hugo on 27/04/17.
 */
public class GameController extends AbstractController{

    public GlobalView Gb;

    public GameController(){

        GlobalView GlbView = new GlobalView(this);
        GlbView.initComposant();
        Gb = GlbView;
        GlbView.setVisible(true);
    }

    public void LoadGame(String pathName) {
        Game game = new Game();
        game.loadMap(pathName);
        GameEditorController editor = new GameEditorController(game);
        Launch(editor);
    }

    public void CreateGame(int sizeX, int sizeY) {
        Game game = new Game(sizeX,sizeY);
        GameEditorController editor = new GameEditorController(game);
        Launch(editor);
    }

    public void Launch(GameEditorController Gamedit) {
        try {
            Application app = new Application(Gamedit);
            app.setVisible(true);
            Gb.setVisible(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void control() {

    }
}

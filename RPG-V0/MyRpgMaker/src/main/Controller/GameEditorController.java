package Controller;

import Model.Game;
import Model.MapEditor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hugo on 27/04/17.
 */
public class GameEditorController extends AbstractController{

    protected Game game;

    public GameEditorController(Game game){
        this.game = game;
    }

    public MapEditor initMap(){
        MapEditor map = new MapEditor(20,20);
        game.addMap(map);
        return map;
    }


    public void LoadMap(String path){
        game.loadMap(path);
    }

    public void SaveMap(){
        game.saveMap();
    }
    @Override
    void control() {

    }
}

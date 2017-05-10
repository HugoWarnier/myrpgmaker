package Controller;

import Model.Game;
import Model.MapEditor;
import Model.Sprite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hugo on 27/04/17.
 */
public class GameEditorController extends AbstractController{

    protected Game game;

    public GameEditorController(Game game){
        this.game = game;
    }

    public MapEditor initMap(int x,int y){
        MapEditor map = new MapEditor(x,y);
        game.addMap(map);
        return map;
    }

    public Game getGame() {
        return game;
    }

    public ArrayList<Sprite> initEditor(){

        ArrayList<Sprite> listSprite = new ArrayList<Sprite>();

        return listSprite;
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
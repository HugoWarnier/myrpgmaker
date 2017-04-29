package Model;

import java.util.ArrayList;
import com.google.gson.Gson;

/**
 * Created by hugo on 27/04/17.
 */
public class MapEngine extends AbstractModel{
    //private int id;
    private String name = "";
    private String description = "";
    private TileEngine[][] map; //transient
    private String mapFile;
    private int xSize;
    private int ySize;
    ArrayList<CharacterEngine> characters = new ArrayList<CharacterEngine>();
    ArrayList<Teleporter> teleporters = new ArrayList<Teleporter>();

    //Constructor
    public MapEngine(String name, String description, TileEngine[][] matrice, String mapFile,
                     int xSize, int ySize, ArrayList<CharacterEngine> characters, ArrayList<Teleporter> teleporters){
        this.name = name;
        this.description = description;
        this.map = matrice;
        this.mapFile = mapFile;
        this.xSize = xSize;
        this.ySize = ySize;
        this.characters = characters;
        this.teleporters = teleporters;
    }

    public MapEngine(){
    }

    //Methods

    public void addTeleporter(Teleporter t){
        this.teleporters.add(t);
    }
    public void addCharacter(CharacterEngine c){
        this.characters.add(c);
    }
}

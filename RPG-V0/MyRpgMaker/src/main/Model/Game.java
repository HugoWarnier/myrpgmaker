package Model;

import java.util.ArrayList;

/**
 * Created by hugo on 27/04/17.
 */
public class Game extends AbstractModel{

    private ArrayList<MapEditor> listMap = new ArrayList<MapEditor>();
    private String name;
    private String name_map;

    public Game() {
        this.name = "";
        this.name_map = "";
    }

    public void loadMap(){

    }


    public ArrayList<MapEditor> getListMap() {
        return listMap;
    }
    public void setMap(MapEditor map) {
        this.listMap.add(map);
    }

    public String getName() {
        return name;
    }
    public String getName_map() {
        return name_map;
    }

    public void setName(String n_p) {
        this.name = n_p;
    }

    public void setName_map(String n_m) {
        this.name_map = n_m;
    }
}

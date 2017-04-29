package Model;
import java.util.ArrayList;

public class World{
    public ArrayList<MapEngine> maps = new ArrayList<MapEngine>();

    public World(){
    }

    public World(ArrayList<MapEngine> maps){
        this.maps = maps;
    }

    public World(MapEngine map){
        this.maps.add(map);
    }
}
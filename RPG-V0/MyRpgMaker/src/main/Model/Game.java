package Model;

import com.google.gson.*;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by hugo on 27/04/17.
 */
public class Game extends AbstractModel{

    private ArrayList<MapEditor> listMap = new ArrayList<MapEditor>();
    private String name;
    private String name_map;

    public Game() {
        listMap = new ArrayList<MapEditor>();
        this.name = "";
        this.name_map = "";
    }

    public Game(int x, int y) {
        listMap = new ArrayList<MapEditor>();
        this.name = "";
        this.name_map = "";
        this.listMap.add(new MapEditor(x,y));
    }

    public Game(MapEditor map) {
        listMap = new ArrayList<MapEditor>();
        this.name = "";
        this.name_map = "";
        this.listMap.add(map);
    }

    public void parseMap(String content, int Y){

        JsonElement Jelem = new JsonParser().parse(content);
        JsonObject Jobj = Jelem.getAsJsonObject();
        JsonArray Jarray = Jobj.getAsJsonArray("Map");
        int X = Jarray.get(1).getAsJsonArray().size();
        ReadJsonForLoad(Jarray, X, Y);
    }

    public void ReadJsonForLoad(JsonArray Jarray, int X, int Y){

        int cpt = 0;

        MapEditor mMap = new MapEditor(X,Y);

        for (JsonElement Jelem0 : Jarray) {
            //System.out.println(Jelem0);
            for (int i = 0; i < X ; i++) {
                mMap.getMap()[i][cpt].rm_FSprite();
                mMap.getMap()[i][cpt].add_SpriteByRef(Jelem0.getAsJsonArray().get(i).toString());
            }
            cpt++;
        }
        addMap(mMap);
    }

    public void loadMap(String path){

        try {
            /**
             *  Map Loading
             * */

            FileInputStream mmap = new FileInputStream(path);
            InputStreamReader mapReader = new InputStreamReader(mmap);
            BufferedReader buffer = new BufferedReader(mapReader);
            String l;
            String content = "";

            /**
             *  Map Reading / Factoring
             **/

            try {
                int X = 0;
                int Y = 0;

                while((l = buffer.readLine()) != null){
                    System.out.println(l);
                    Y++;
                    content += l+"\n";
                }
                System.out.println(Y);
                parseMap(content, Y);
                buffer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveMap(){

        BufferedWriter f1 = null;
        FileWriter fw = null;

        try {
            int cpt_m = 0;
            int cpt_p = 0;
            String content = "{\n";
            content += "     \"maps\": { \n";
            for (MapEditor m : this.getListMap()) {
                ;
                content += "         \"map"+cpt_m+"\": { \n";
                content += "             \"name_map\": "+this.getName_map()+",\n";
                content += "             \"map_container\": {\n";
                int cpt_c = 0;

                for (int i = 0; i < m.getxSize()-1 ; i++) {
                    for (int j = 0; j < m.getySize()-1 ; j++) {

                        int posX = m.getMap()[i][j].getPosX();
                        int posY = m.getMap()[i][j].getPosY();

                        content += "                 \"Cell"+cpt_c+"\": {\n";
                        content += "                     \"posX\" :"+ posX +" \n";
                        content += "                     \"posY\" :"+ posY +" \n";
                        content += "                 \"}\n";
                        cpt_c++;
                    }
                }
                content += "             },\n";
                content += "         },\n";
                cpt_m++;
            }
            content += "     },\n";
            content += "     \"perso"+cpt_p+"\": {\n";
            content += "         \"name_perso\": "+this.getName()+",\n";
            content += "     },\n";
            content += "}";

            fw = new FileWriter("/home/hugo/RpgMaker/src/main/resources/test.world");
            f1 = new BufferedWriter(fw);
            f1.write(content);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if (f1 != null)
                    f1.close();
                if (fw != null)
                    fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public ArrayList<MapEditor> getListMap() {
        return listMap;
    }

    public void addMap(MapEditor map) {
        this.listMap.add(map);
        setChanged();
        notifyObservers("load");
    }

    public void rmMap(MapEditor map) {
        this.listMap.remove(map);
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
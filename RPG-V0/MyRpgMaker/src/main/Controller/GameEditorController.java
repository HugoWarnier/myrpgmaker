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
        game.setMap(map);
        return map;
    }

    public void LoadMap(){
        game.loadMap();
    }

    public void SaveMap(){

        BufferedWriter f1 = null;
        FileWriter fw = null;

        try {
            int cpt_m = 0;
            int cpt_p = 0;
            String content = "{\n";
            content += "     \"maps\": { \n";
            for (MapEditor m : game.getListMap()) {
                ;
                content += "         \"map"+cpt_m+"\": { \n";
                content += "             \"name_map\": "+game.getName_map()+",\n";
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
            content += "         \"name_perso\": "+game.getName()+",\n";
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
    @Override
    void control() {

    }
}

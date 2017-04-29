package Controller;

import Model.World;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by hugo on 27/04/17.
 */
public class GameEngineController extends AbstractController{

    // Mark: Attribut
    private World world;

    // Mark: Constructor

    public GameEngineController(String filename){
        this.initWorld(filename);
    }

    public GameEngineController(World w){
        this.world = w;
    }


    // Mark: Methods

    public void initWorld(String filename){
        //open .world & get json
        StringBuffer worldJson = new StringBuffer();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null)
            {
                worldJson.append(line);
            }
            reader.close();
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
        }

        //init data from json string
        final Gson gson = new Gson();
        this.world = gson.fromJson(worldJson.toString(), World.class);
    }

    public void save(String name){
        StringBuffer worldJson = new StringBuffer();
        final Gson gson = new Gson();
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".wrld"));
            String json = gson.toJson(this.world);
            writer.write(json);
            writer.close();
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", name);
            e.printStackTrace();
        }
    }


    @Override
    void control() {

    }
}

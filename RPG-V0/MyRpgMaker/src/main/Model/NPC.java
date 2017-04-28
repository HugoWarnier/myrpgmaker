package Model;
/**
 * Created by Hermann on 28/04/2017.
 */
public class NPC {
    private int id;
    private String name;
    private Position position;

    public NPC(int id, String name, Position position){
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

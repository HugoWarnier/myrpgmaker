package Model;

import com.google.gson.Gson;

/**
 * Created by Hermann on 29/04/2017.
 */
public class CharacterEngine {
    private int id;
    private String name;
    private int hp;
    private Position position;

    public CharacterEngine(int id, String name, int hp, Position position){
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getId() {
        return id;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "id: " + this.id + ", name: " + this.name + ",hp: " + this.hp;
    }

    public void moveUp(){
        this.position.setY(this.position.getY() + 1);
    }

    public void moveDown(){
        this.position.setY(this.position.getY() - 1);
    }

    public void moveRight(){
        this.position.setX(this.position.getX() + 1);
    }

    public void moveLeft(){
        this.position.setX(this.position.getX() - 1);
    }

    public void getJsonObject(){
        final Gson gson = new Gson();
    }
}

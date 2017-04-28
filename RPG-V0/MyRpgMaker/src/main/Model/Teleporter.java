package Model;

/**
 * Created by Hermann on 28/04/2017.
 */
public class Teleporter {
    private Position position;
    private int mapId;
    private Position destPosition;

    public Teleporter(Position position, int mapId, Position destPosition){
        this.position = position;
        this.mapId = mapId;
        this.destPosition = destPosition;
    }

    public Position getPosition() {
        return position;
    }

    public int getMapId() {
        return mapId;
    }

    public Position getDestPosition() {
        return destPosition;
    }

    public void setDestPosition(Position destPosition) {
        this.destPosition = destPosition;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

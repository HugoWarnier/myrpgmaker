package Model;

/**
 * Created by hugo on 27/04/17.
 */
public class MapEditor extends AbstractModel{

    private Cell carte[][];
    private String Name_map;
    private int xSize;
    private int ySize;

    public MapEditor(int x, int y) {

        this.xSize = x;
        this.ySize = y;
        this.carte = new Cell[x][y];
        for (int i = 0; i < xSize ; i++) {
            for (int j = 0; j < ySize ; j++) {
                this.carte[i][j] = new Cell(i,j);
            }
        }
    }

    public void setMap(Cell map[][]) {
        carte = map;
    }

    public void setName_map(String name_map) {
        Name_map = name_map;
    }

    public void setxSize(int xSize) {
        this.xSize = xSize;
    }

    public void setySize(int ySize) {
        this.ySize = ySize;
    }

    public Cell[][] getMap() {
        return carte;
    }

    public String getName_map() {
        return Name_map;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }
}

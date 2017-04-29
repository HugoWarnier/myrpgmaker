import Controller.GameEngineController;
import Model.*;

import java.util.ArrayList;

/**
 * Created by hugo on 27/04/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        CharacterEngine c1 = new CharacterEngine(1, "1", 200, new Position(0,0));
        CharacterEngine c2 = new CharacterEngine(2, "2", 200, new Position(1,1));
        CharacterEngine c3 = new CharacterEngine(3, "3", 200, new Position(0,0));

        ArrayList<CharacterEngine> al1 = new ArrayList<CharacterEngine>();
        ArrayList<CharacterEngine> al2 = new ArrayList<CharacterEngine>();

        al1.add(c1);
        al1.add(c2);
        al2.add(c3);

        Teleporter t1 = new Teleporter(new Position(0,0), 2, new Position(1, 1));
        Teleporter t2 = new Teleporter(new Position(0,0), 1, new Position(1, 1));

        ArrayList<Teleporter> al3 = new ArrayList<Teleporter>();
        ArrayList<Teleporter> al4 = new ArrayList<Teleporter>();
        al3.add(t1);
        al4.add(t2);

        ArrayList<Integer> i = new ArrayList<Integer>();
        ArrayList<Integer> j = new ArrayList<Integer>();

        i.add(2);
        j.add(3);
        j.add(1);

        TileEngine[][] mt1 = {{new TileEngine(i),new TileEngine(j)},{new TileEngine(i),new TileEngine(i)}};
        TileEngine[][] mt2 = {{new TileEngine(j), new TileEngine(i)},{new TileEngine(i), new TileEngine(j)}};

        MapEngine m1 = new MapEngine("1", "1", mt1, "file", 2, 2, al1, al3);
        MapEngine m2 = new MapEngine("2", "2", mt2, "file", 2, 2, al2, al4);
        ArrayList<MapEngine> al5 = new ArrayList<MapEngine>();
        al5.add(m1);
        al5.add(m2);

        World w = new World(al5);

        GameEngineController g = new GameEngineController(w);
        g.save("test");
    }
}

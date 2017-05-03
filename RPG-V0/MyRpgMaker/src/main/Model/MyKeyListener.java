package Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

/**
 * Created by Hermann on 03/05/2017.
 */
public class MyKeyListener extends Observable implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("up");
            setChanged();
            notifyObservers("up");
            //handle...
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("down");
            setChanged();
            notifyObservers("down");
            //handle...
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("right");
            setChanged();
            notifyObservers("right");
            //handle...
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("left");
            setChanged();
            notifyObservers("left");
            //handle...
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

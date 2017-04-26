import javafx.scene.control.ToolBar;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
import javax.tools.Tool;

public class Application extends JFrame {

    public Application() {
        Init_menu("rpgMaker", 1200, 700);
    }

    private void Init_menu(String title, int width, int height) {

        createMenuBar();
        createToolBar();


        setTitle(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {

        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");

        menubar.add(file);

        JMenuItem eMenuItem = new JMenuItem("New");
        file.addSeparator();
        eMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        file.add(eMenuItem);

        eMenuItem = new JMenuItem("Open file");
        file.addSeparator();
        eMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        file.add(eMenuItem);
        final JFileChooser fc = new JFileChooser();
        eMenuItem.addActionListener((ActionEvent event) -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File tmp = fileChooser.getSelectedFile();
                // load from file
            }
        });

        eMenuItem = new JMenuItem("Open recent", KeyEvent.VK_R);
        file.addSeparator();
        file.add(eMenuItem);

        eMenuItem = new JMenuItem("Save");
        file.addSeparator();
        eMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        file.add(eMenuItem);

        eMenuItem.addActionListener((ActionEvent event) -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File tmp = fileChooser.getSelectedFile();
                // save to file
            }
        });

        eMenuItem = new JMenuItem("Save as");
        eMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + InputEvent.SHIFT_MASK));
        file.addSeparator();
        file.add(eMenuItem);

        eMenuItem = new JMenuItem("New window");
        file.addSeparator();
        file.add(eMenuItem);

        eMenuItem = new JMenuItem("Close window");
        file.addSeparator();
        file.add(eMenuItem);

        eMenuItem = new JMenuItem("Close file");
        file.addSeparator();
        file.add(eMenuItem);

        eMenuItem = new JMenuItem("Exit");
        file.addSeparator();
        eMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        eMenuItem.setToolTipText("Exit application");

        file.add(eMenuItem);

        eMenuItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        JMenu edit = new JMenu("Edit");


        JMenu view = new JMenu("View");
        file.setMnemonic(KeyEvent.VK_V);

        JMenu layer = new JMenu("Layer");
        file.setMnemonic(KeyEvent.VK_L);

        JMenu draw_tools = new JMenu("Draw tools");
        file.setMnemonic(KeyEvent.VK_D);

        JMenu zoom = new JMenu("Zoom");
        file.setMnemonic(KeyEvent.VK_F);

        JMenu tool = new JMenu("Tool");
        file.setMnemonic(KeyEvent.VK_T);

        JMenu game = new JMenu("Game");
        file.setMnemonic(KeyEvent.VK_G);

        JMenu help = new JMenu("Help");
        file.setMnemonic(KeyEvent.VK_F);

        menubar.add(edit);
        menubar.add(layer);
        menubar.add(draw_tools);
        menubar.add(zoom);
        menubar.add(tool);
        menubar.add(game);
        menubar.add(Box.createHorizontalGlue());
        menubar.add(help);

        setJMenuBar(menubar);
    }

    private void createToolBar() {

        JToolBar toolbar = new JToolBar();

        JButton create_file = new JButton("/home/unknown/Pictures/icon/file.png");
        create_file.setText("New file");
        toolbar.add(create_file);

        JButton open_file = new JButton("/home/unknown/Pictures/icon/open.png");
        create_file.setText("open file");
        toolbar.add(create_file);

        JButton save_file = new JButton("/home/unknown/Pictures/icon/save.png");
        create_file.setText("Save file");
        toolbar.add(create_file);

        JButton cut_file = new JButton("/home/unknown/Pictures/icon/cut.png");
        create_file.setText("Cut file");
        toolbar.add(create_file);

        JButton undo = new JButton("/home/unknown/Pictures/icon/undo.png");
        create_file.setText("undo");
        toolbar.add(create_file);

        JButton redo = new JButton("/home/unknown/Pictures/icon/redo.png");
        create_file.setText("redo");
        toolbar.add(create_file);

        JButton play = new JButton("/home/unknown/Pictures/icon/play.png");
        create_file.setText("play");
        toolbar.add(create_file);

        JButton stop = new JButton("/home/unknown/Pictures/icon/stop.png");
        create_file.setText("stop");
        toolbar.add(create_file);

        JButton zoom_in = new JButton("/home/unknown/Pictures/icon/zoom_in");
        create_file.setText("zoom_in");
        toolbar.add(create_file);

        JButton zoom_out = new JButton("/home/unknown/Pictures/icon/zoom_out.png");
        create_file.setText("zoom out");
        toolbar.add(create_file);

        JButton exit = new JButton("/home/unknown/Pictures/icon/exit.png");
        create_file.setText("exit");
        toolbar.add(create_file);


        add(toolbar, BorderLayout.NORTH);

        create_file.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
}
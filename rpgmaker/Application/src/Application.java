import javafx.scene.control.ToolBar;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.tools.Tool;

public class Application extends JFrame {

    public Application() throws IOException {
        Init_menu("rpgMaker", 1200, 700);
    }

    private void Init_menu(String title, int width, int height) throws IOException {

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

    private void createToolBar() throws IOException {

        JToolBar toolbar = new JToolBar();

        JButton create_file = new JButton(new ImageIcon("/home/unknown/Pictures/icon/new.png"));
        create_file.setBorder(null);
        MouseAction(create_file);
        create_file.setToolTipText("New file");
        toolbar.add(create_file);


        JButton open_file = new JButton(new ImageIcon("/home/unknown/Pictures/icon/open.png"));
        open_file.setBorder(null);
        MouseAction(open_file);
        open_file.setToolTipText("Open file");
        toolbar.add(open_file);

        JButton save_file = new JButton(new ImageIcon("/home/unknown/Pictures/icon/save.png"));
        save_file.setToolTipText("Save file");
        MouseAction(save_file);
        save_file.setBorder(null);
        toolbar.add(save_file);

        JButton cut_file = new JButton(new ImageIcon("/home/unknown/Pictures/icon/cut.png"));
        cut_file.setToolTipText("Cut file");
        MouseAction(cut_file);
        cut_file.setBorder(null);
        toolbar.add(cut_file);

        JButton undo = new JButton(new ImageIcon("/home/unknown/Pictures/icon/undo.png"));
        undo.setToolTipText("undo");
        MouseAction(undo);
        undo.setBorder(null);
        toolbar.add(undo);

        JButton redo = new JButton(new ImageIcon("/home/unknown/Pictures/icon/redo.png"));
        redo.setToolTipText("redo");
        MouseAction(redo);
        redo.setBorder(null);
        toolbar.add(redo);

        JButton play = new JButton(new ImageIcon("/home/unknown/Pictures/icon/play.png"));
        play.setToolTipText("play");
        MouseAction(play);
        play.setBorder(null);
        toolbar.add(play);

        JButton stop = new JButton(new ImageIcon("/home/unknown/Pictures/icon/stop.png"));
        stop.setToolTipText("stop");
        MouseAction(stop);
        stop.setBorder(null);
        toolbar.add(stop);

        JButton zoom_in = new JButton(new ImageIcon("/home/unknown/Pictures/icon/zoom_in.png"));
        zoom_in.setToolTipText("zoom_in");
        MouseAction(zoom_in);
        zoom_in.setBorder(null);
        toolbar.add(zoom_in);

        JButton zoom_out = new JButton(new ImageIcon("/home/unknown/Pictures/icon/zoom_out.png"));
        zoom_out.setToolTipText("zoom out");
        MouseAction(zoom_out);
        zoom_out.setBorder(null);
        toolbar.add(zoom_out);

        JButton exit = new JButton(new ImageIcon("/home/unknown/Pictures/icon/exit.png"));
        exit.setToolTipText("exit");
        MouseAction(exit);
        exit.setBorder(null);
        toolbar.add(exit);

        add(toolbar, BorderLayout.NORTH);

        create_file.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                System.exit(0);
            }
        });
    }

    public void MouseAction (JButton button) {
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBorder(null);
            }
        });

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Application ex = null;
            try {
                ex = new Application();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ex.setVisible(true);
        });
    }
}
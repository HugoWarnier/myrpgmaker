
package View.Application;

import Controller.GameEditorController;
import Controller.GameEngineController;
import View.Editor.EditorView;
import javafx.scene.control.Tab;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Application extends JFrame implements Observer{

    public GameEditorController Editor;
    public GameEngineController Engine;

    public Application() throws IOException {
        Init_menu("rpgMaker", 1200, 700);
    }

    public Application(GameEditorController Edit) throws IOException {
        Editor = Edit;
        Init_menu("rpgMaker", 1200, 700);
    }

    private void CreateGameBoard(){
        EditorView Edtv = new EditorView(Editor);
        add(Edtv.initGameBoard(), BorderLayout.CENTER);
    }

    private void Init_menu(String title, int width, int height) throws IOException {

        CreateMenuBar();
        CreateToolBar();
        //CreateGameBoard();
        LeftPanel file = new LeftPanel();
        JPanel Left = new JPanel();
        Left = file.CreateLeftPanel();
        add(Left, BorderLayout.WEST);

        pack();
        setTitle(title);
        //setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );
    }

    private void CreateMenuBar() {

        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");

        menubar.add(file);

        JMenuItem New = CreateMenuItem("New file", "Create a new file", KeyEvent.VK_N, ActionEvent.CTRL_MASK);
        JMenuItem Open = CreateMenuItem("Open file", "Open the choosen file", KeyEvent.VK_O, ActionEvent.CTRL_MASK);
        JMenuItem OpenRecent = CreateMenuItem("Open recent", "Open recent project", KeyEvent.VK_O, ActionEvent.CTRL_MASK + InputEvent.SHIFT_MASK);
        JMenuItem Save = CreateMenuItem("Save", "Save your project", KeyEvent.VK_S, ActionEvent.CTRL_MASK);
        JMenuItem SaveAs = CreateMenuItem("Save as", "Save your project", KeyEvent.VK_S, ActionEvent.CTRL_MASK + InputEvent.SHIFT_MASK);
        JMenuItem NewWindow = CreateMenuItem("New window", "Open an other window", KeyEvent.VK_N, ActionEvent.CTRL_MASK + InputEvent.SHIFT_MASK);
        JMenuItem CloseWindow = CreateMenuItem("Close window", "Close the current window", KeyEvent.VK_W, ActionEvent.CTRL_MASK);
        JMenuItem Exit = CreateMenuItem("Exit", "Exit application", KeyEvent.VK_F4, ActionEvent.ALT_MASK);

        file.add(New);
        file.add(Open);
        file.add(OpenRecent);
        file.add(Save);
        file.add(SaveAs);
        file.add(NewWindow);
        file.add(CloseWindow);
        file.add(Exit);


        final JFileChooser fc = new JFileChooser();
        Open.addActionListener((ActionEvent event) -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File tmp = fileChooser.getSelectedFile();
                Editor.LoadMap(tmp);
            }
        });

        Save.addActionListener((ActionEvent event) -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File tmp = fileChooser.getSelectedFile();
                // save to file
            }
        });

        Exit.addActionListener((ActionEvent event) -> {
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

    private JMenuItem CreateMenuItem(String name, String tooltip, int Event, int Action) {
        JMenuItem eMenuItem = new JMenuItem(name);
        eMenuItem.setAccelerator(KeyStroke.getKeyStroke(Event, Action));
        eMenuItem.setToolTipText(tooltip);
        return eMenuItem;
    }

    private void CreateToolBar() throws IOException {

        JToolBar toolbar = new JToolBar();

        JButton CreateFile = CreateButton(new String[]{"Pictures/new.png", "id", "Create File"});
        toolbar.add(CreateFile);

        JButton OpenFile = CreateButton(new String[]{"Pictures/open.png", "id", "Open File"});
        toolbar.add(OpenFile);

        JButton SaveFile = CreateButton(new String[]{"Pictures/save.png", "id", "Save File"});
        toolbar.add(SaveFile);

        JButton CutFile = CreateButton(new String[]{"Pictures/cut.png", "id", "Cut File"});
        toolbar.add(CutFile);

        JButton undo = CreateButton(new String[]{"Pictures/undo.png", "id", "Undo"});
        toolbar.add(undo);

        JButton redo = CreateButton(new String[]{"Pictures/redo.png", "id", "Redo"});
        toolbar.add(redo);

        JButton play = CreateButton(new String[]{"Pictures/play.png", "id", "Play"});
        toolbar.add(play);

        JButton stop = CreateButton(new String[]{"Pictures/stop.png", "id", "Stop"});
        toolbar.add(stop);

        JButton ZoomOut = CreateButton(new String[]{"Pictures/zoom_out.png", "id", "Zoom out"});
        toolbar.add(ZoomOut);

        JButton ZoomIn = CreateButton(new String[]{"Pictures/zoom_in.png", "id", "Zoom in"});
        toolbar.add(ZoomIn);

        JButton exit = CreateButton(new String[]{"Pictures/exit.png", "id", "Exit Application"});
        toolbar.add(exit);

        add(toolbar, BorderLayout.NORTH);

        /*create_file.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                System.exit(0);
            }
        });*/
    }

    public JButton CreateButton (String[] info) {
        JButton button = new JButton(new ImageIcon(info[0],info[1]));
        button.setToolTipText(info[2]);
        MouseAction(button);
        button.setBorder(null);
        return button;
    }

    private void ReadPicture() {}

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

    public void CreateImageExplorer(JButton button) {
        setLayout(new GridLayout(1, 2));
        add(createLeftPanel(button));
        // add(createRightPanel());
    }

    protected JPanel createLeftPanel(JButton button) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        // Specify that the component be the last one in its row
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        // Resize the component when the component display s area is larger than the component s request size
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //
        gbc.weightx = 1;
        // Add the buttons into the gridlayout
        panel.add(button, gbc);
        button.setTransferHandler(new ValueExportTransferHandler(button.getIcon().toString()));

        button.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                TransferHandler handle = button.getTransferHandler();
                handle.exportAsDrag(button, e, TransferHandler.COPY);
            }
        });
        return panel;
    }

    protected JPanel createRightPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        JLabel label = new JLabel("Drop in");
        label.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY), new EmptyBorder(20, 20, 20, 20)));
        label.setTransferHandler(new ValueImportTransferHandler());
        panel.add(label);
        return panel;
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

    @Override
    public void update(Observable o, Object arg) {

    }
}

class ValueExportTransferHandler extends TransferHandler {

    public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;
    private String value;

    public ValueExportTransferHandler(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int getSourceActions(JComponent c) {
        return DnDConstants.ACTION_COPY_OR_MOVE;
    }

    @Override
    protected Transferable createTransferable(JComponent c) {
        Transferable t = new StringSelection(getValue());
        return t;
    }

    @Override
    protected void exportDone(JComponent source, Transferable data, int action) {
        super.exportDone(source, data, action);
        // Decide what to do after the drop has been accepted
    }

}

class ValueImportTransferHandler extends TransferHandler {

    public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;

    public ValueImportTransferHandler() {
    }

    @Override
    public boolean canImport(TransferHandler.TransferSupport support) {
        return support.isDataFlavorSupported(SUPPORTED_DATE_FLAVOR);
    }

    @Override
    public boolean importData(TransferHandler.TransferSupport support) {
        boolean accept = false;
        if (canImport(support)) {
            try {
                Transferable t = support.getTransferable();
                Object value = t.getTransferData(SUPPORTED_DATE_FLAVOR);
                if (value instanceof String) {
                    Component component = support.getComponent();
                    if (component instanceof JLabel) {
                        ((JLabel) component).setText(value.toString());
                        accept = true;
                    }
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
        return accept;
    }
}
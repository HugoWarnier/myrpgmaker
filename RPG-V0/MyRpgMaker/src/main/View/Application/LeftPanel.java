package View.Application;

import javafx.scene.layout.Pane;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders;

/**
 * Created by root on 28/04/17.
 */
public class LeftPanel extends JFrame{

    // File representing the folder that you select using a FileChooser
     File dir;

    // array of supported   extensions (use a List if you prefer)
    final String[] EXTENSIONS = new String[]{
            "png" // Format filter
    };
    // filter to identify images based on their extensions
    final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };

    final JPanel LeftPanel = new JPanel();
    final DefaultListModel model = new DefaultListModel();
    final JTabbedPane Tab = new JTabbedPane();
    final ButtonGroup group = new ButtonGroup();

    public JPanel CreateLeftPanel () {

        DefaultListModel Model = ReadImage("src/main/resources/sprites/");
        DefaultListModel listModel1 = new DefaultListModel();
        DefaultListModel listModel2 = new DefaultListModel();
        DefaultListModel listModel3 = new DefaultListModel();


        JList list = new JList(listModel1);
        JList list2 = new JList(listModel2);
        JList list3 = new JList(listModel3);

        LeftPanel.setLayout(new GridLayout(1,1));
        LeftPanel.setSize(500,500);
        LeftPanel.setBorder(BorderFactory.createTitledBorder("Image Editor"));

        PanelRenderer renderer = new PanelRenderer();
        list.setCellRenderer(renderer);
        list2.setCellRenderer(renderer);
        list3.setCellRenderer(renderer);


        JTabbedPane Tab = new JTabbedPane();
        JPanel PanTab1 = new JPanel();
        JPanel PanTab2 = new JPanel();
        JPanel PanTab3 = new JPanel();

        for (int i = 0; i < Model.getSize(); i++) {
            //JPanel Panel = new JPanel();
            JButton button = (JButton) Model.getElementAt(i);

            if (button.getToolTipText().contains("backgroundTile"))
                listModel1.addElement(button);

            else if (button.getToolTipText().contains("foregroundObject"))
                listModel2.addElement(button);

            else if (button.getToolTipText().contains("npc"))
                listModel3.addElement(button);
        }
        PanTab1.add(list);
        PanTab2.add(list2);
        PanTab3.add(list3);

        JScrollPane scrollPane1 = new JScrollPane(PanTab1);
        JScrollPane scrollPane2 = new JScrollPane(PanTab2);
        JScrollPane scrollPane3 = new JScrollPane(PanTab3);

        Tab.addTab("BackGround", scrollPane1);
        Tab.addTab("ForeGround", scrollPane2);
        Tab.addTab("Character", scrollPane3);
        LeftPanel.add(Tab, LeftPanel);

        return LeftPanel;
    }
    public DefaultListModel ReadImage(String Path) {

        dir = new File(Path);

        if (dir.isDirectory()) { // make sure it's a directory

            for (final File f : dir.listFiles()) {
                if (f.isDirectory()) {
                    ReadImage(f.getAbsolutePath());
                    continue;
                }

                BufferedImage img = null;

                try {
                    img = ImageIO.read(f);
                    if (f.getPath().contains("npc")) {
                        BufferedImage BufImg = img;
                        JButton button = new JButton(new ImageIcon(BufImg.getSubimage(7,7,50,50)));
                        button.setToolTipText("npc");
                        model.addElement((JButton) button );
                    }
                    else if (f.getPath().contains("backgroundTile")){
                        JButton button = new JButton(new ImageIcon(img));
                        button.setToolTipText("backgroundTile");
                        model.addElement((JButton) button );
                    }

                    else if (f.getPath().contains("foregroundObject")){
                        JButton button = new JButton(new ImageIcon(img));
                        button.setToolTipText("foregroundObject");
                        model.addElement((JButton) button );
                    }
                }
                catch (final IOException e) {
                    // handle errors here
                }
            }
            return model;
        }
        return null;
    }
}

class PanelRenderer implements ListCellRenderer {

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasfocus) {
        JButton renderer = (JButton) value;
        renderer.setBackground(isSelected ? Color.ORANGE : list.getBackground());
        return renderer;
    }
}

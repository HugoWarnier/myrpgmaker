package View.Application;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
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
    final File dir = new File("/home/hugo/myrpgmaker/RPG-V0/MyRpgMaker/Pictures");

    // array of supported extensions (use a List if you prefer)
    final String[] EXTENSIONS = new String[]{
            "png" // and other formats you need
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

    public JScrollPane ReadImage() {

        JPanel LeftPanel = new JPanel();
        DefaultListModel model = new DefaultListModel();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));


        if (dir.isDirectory()) { // make sure it's a directory
            for (final File f : dir.listFiles(IMAGE_FILTER)) {
                BufferedImage img = null;

                try {
                    img = ImageIO.read(f);
                    JButton button = new JButton(new ImageIcon(img));
                    model.addElement(button);

                    System.out.println(" width : " + img.getWidth());
                    System.out.println(" height: " + img.getHeight());
                } catch (final IOException e) {
                    // handle errors here
                }
            }
            //LeftPanel.setVisible(true);
            JList list = new JList(model);
            list.setCellRenderer(new PanelRenderer());
            JScrollPane Scroll = new JScrollPane(list);
            final JScrollBar ScrollBar = Scroll.getVerticalScrollBar();
            return Scroll;
        }
        return null;
    }
}

class PanelRenderer implements ListCellRenderer {

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasfocus) {
        JButton renderer = (JButton) value;
        renderer.setBackground(isSelected ? Color.red : list.getBackground());
        return renderer;
    }
}

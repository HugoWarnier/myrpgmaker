package View;

import Controller.GameController;
import View.Application.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by hugo on 27/04/17.
 */
public class GlobalView extends JFrame implements Observer {

    public GameController GmControl;

    private JPanel container =  new JPanel();
    JButton Create = new JButton();
    JButton Load = new JButton();
    JButton LoadB = new JButton();
    JButton Quit = new JButton();

    private JLabel newLabel = new JLabel();
    private JLabel loadLabel = new JLabel();

    private JLabel XLabel = new JLabel();
    private JLabel YLabel = new JLabel();

    private JLabel loadSelect = new JLabel();
    private JTextField newSelect = new JTextField();

    private JTextField XSelect = new JTextField();
    private JTextField YSelect = new JTextField();

    public GlobalView(GameController GmC){

        this.setSize(800,700);
        setTitle("My PwnedMaker");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.GmControl = GmC;
        initComposant();
        this.setContentPane(container);
    }

    public void initComposant(){

        loadLabel = new JLabel("Load World: ");
        newLabel = new JLabel("New World: ");

        XLabel = new JLabel("X size");
        YLabel = new JLabel("Y size");

        XSelect = new JTextField("");
        XSelect.setPreferredSize(new Dimension(50,20));

        YSelect = new JTextField("");
        YSelect.setPreferredSize(new Dimension(50,20));

        loadSelect = new JLabel("");
        loadSelect.setPreferredSize(new Dimension(300,20));
        loadSelect.setBackground(Color.WHITE);

        newSelect = new JTextField("");
        newSelect.setPreferredSize(new Dimension(50,20));

        Create = new JButton("Create");
        ActionListener CGame = new CreateGame();
        Create.addActionListener(CGame);

        Load = new JButton("Search");
        LoadB = new JButton("Load");
        ActionListener loadB = new LoadGame();
        LoadB.addActionListener(loadB);

        Quit = new JButton("Exit");
        ActionListener quit = new Quit();
        Quit.addActionListener(quit);

        JPanel pan1 = new JPanel();

        pan1.add(loadLabel);
        pan1.add(Load);
        pan1.add(loadSelect);
        pan1.add(LoadB);

        JPanel pan2 = new JPanel();

        pan2.add(newLabel);
        pan2.add(newSelect);
        pan2.add(Create);

        JPanel pan3 = new JPanel();

        pan3.add(YLabel);
        pan3.add(XLabel);

        JPanel pan6 = new JPanel();
        pan6.add(XSelect);
        pan6.add(YSelect);

        JPanel pan4 = new JPanel();

        pan4.add(Quit);

        JPanel pan5 = new JPanel();

        pan1.setBackground(Color.GRAY);
        pan2.setBackground(Color.GRAY);
        pan3.setBackground(Color.GRAY);
        pan4.setBackground(Color.GRAY);
        pan5.setBackground(Color.GRAY);
        pan6.setBackground(Color.GRAY);

        JPanel pan7 = new JPanel();
        pan7.setBackground(Color.GRAY);
        ImageIcon Bg = new ImageIcon("/home/hugo/PROJECTS/myrpgmaker/RPG-V0/MyRpgMaker/src/test/resources/BackgroundTitlte.png");
        JLabel ImgLbl = new JLabel(Bg);
        pan7.add(ImgLbl);

        pan5.add(pan7, BorderLayout.EAST);

        pan5.add(pan1, BorderLayout.EAST);

        pan5.add(pan2 , BorderLayout.CENTER);

        pan5.add(pan3, BorderLayout.CENTER);

        pan5.add(pan6, BorderLayout.CENTER);

        pan5.add(pan4, BorderLayout.WEST);

        pan5.setLayout(new BoxLayout(pan5, BoxLayout.PAGE_AXIS));

        container.add(pan5);
        container.setBackground(Color.GRAY);

        final JFileChooser fc = new JFileChooser();
        Load.addActionListener((ActionEvent event) -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File tmp = fileChooser.getSelectedFile();
                System.out.println("File"+tmp);
                loadSelect.setText(""+tmp);
                System.out.println("HEY"+XSelect.getText());
                revalidate();
                repaint();
            }
        });
    }

    class CreateGame implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int X = Integer.parseInt(XSelect.getText());
            int Y = Integer.parseInt(YSelect.getText());
            GmControl.CreateGame(X, Y);
        }
    }

    class Quit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    class LoadGame implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            GmControl.LoadGame(loadSelect.getText());
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}

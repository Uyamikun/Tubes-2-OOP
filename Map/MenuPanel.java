package Map;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.*;

public class MenuPanel extends JPanel {
    private String[] optionsMenu;
    private static final String START_GAME = "Start Game!";
    private static final String LOAD_GAME = "Load Game";
    private static final String QUIT_GAME = "Quit Game";
    private int selected;
    private FrameMenu frameobj;
    private FrameUtama frameUtamaObj;
    JPanel labelsLoad = new JPanel();

    public MenuPanel(FrameMenu menu, FrameUtama futama){
        this.optionsMenu = new String[]{START_GAME,LOAD_GAME,QUIT_GAME};
        this.selected = 0;
        this.frameobj = menu;
        this.frameUtamaObj = futama;

        labelsLoad.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
        labelsLoad.setLayout(new BoxLayout(labelsLoad, BoxLayout.Y_AXIS));

        this.add(labelsLoad);
        labelsLoad.setVisible(false);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //create gambar component
        g.setColor(new Color(30,30,70));
        //g.setColor(new Color(105,123,165));
        g.fillRect(0,0,800,450);

        g.setFont(new Font("Roboto Light",Font.BOLD,50));
        g.setColor(Color.WHITE);
        g.drawString("~Wangkymon~", 20, 75);

        g.setFont(new Font("Arial",Font.PLAIN,25));
        for (int i=0; i<this.optionsMenu.length;i++)
        {
            if (i==this.selected) g.setColor(Color.GREEN);
            else g.setColor(Color.WHITE);
            g.drawString(this.optionsMenu[i], 20, 75+50+i*40);
        }
    }

    public void keypress(KeyEvent e) {
        int key = e.getKeyCode();
        //JOptionPane.showMessageDialog(null, "Arrow Key ditekan");
        //jika panah atas ditekan
        if (key==KeyEvent.VK_UP || key==KeyEvent.VK_W) {
            if (this.selected > 0) this.selected--;
            repaint();
        } else if (key==KeyEvent.VK_DOWN || key==KeyEvent.VK_S) {
            if(this.selected < this.optionsMenu.length-1) this.selected++;
            repaint();
        } else if (key==KeyEvent.VK_ENTER) {
            switch (this.optionsMenu[selected]){
                case START_GAME:
                    frameobj.setVisible(false);
                    frameUtamaObj.setVisible(true);
                    frameUtamaObj.getObjBoardPanel().requestFocusInWindow();
                    break;
                case LOAD_GAME:
                    //JOptionPane.showMessageDialog(null, "Belum implemented :)");
                    File f = new File("Saves");
                    JComboBox cb = new JComboBox(f.list());
                    JButton buttonLoad = new JButton(new AbstractAction("Load"){
                        public void actionPerformed(ActionEvent e){
                            frameobj.setVisible(false);
                            frameUtamaObj.getObjBoardPanel().load(Objects.requireNonNull(cb.getSelectedItem()).toString());
                            frameUtamaObj.setVisible(true);
                            frameUtamaObj.getObjBoardPanel().requestFocusInWindow();
                        }
                    });

                    labelsLoad.add(cb);
                    labelsLoad.add(buttonLoad);
                    labelsLoad.setVisible(true);
                    this.revalidate();
                    this.repaint();

                    break;
                case QUIT_GAME:
                    System.exit(0);
                    break;
            }
            repaint();
        }
    }
}

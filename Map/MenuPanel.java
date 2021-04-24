package Map;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

public class MenuPanel extends JPanel {
    private String[] optionsMenu;
    private static final String START_GAME = "Start Game!";
    private static final String QUIT_GAME = "Quit Game";
    private int selected;
    private FrameMenu frameobj;
    private FrameUtama frameUtamaObj;

    public MenuPanel(FrameMenu menu, FrameUtama futama){
        this.optionsMenu = new String[]{START_GAME,QUIT_GAME};
        this.selected = 0;
        this.frameobj = menu;
        this.frameUtamaObj = futama;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //create gambar component
        g.setColor(new Color(30,30,70));
        //g.setColor(new Color(105,123,165));
        g.fillRect(0,0,800,450);

        g.setFont(new Font("Araial",Font.PLAIN,25));
        for (int i=0; i<this.optionsMenu.length;i++)
        {
            if (i==this.selected) g.setColor(Color.GREEN);
            else g.setColor(Color.WHITE);
            g.drawString(this.optionsMenu[i], 20, 50+i*40);
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
                case QUIT_GAME:
                    System.exit(0);
                    break;
            }
            repaint();
        }
    }
}

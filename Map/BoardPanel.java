package Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

public class BoardPanel extends JLayeredPane{
    private PlayerUI playerUI;
    private Map peta;

    public BoardPanel(PlayerUI player,Map peta){
        this.playerUI = player;
        this.peta = peta;
        this.setLayout(new GridBagLayout());
    }

    public void load(String Path){
        this.peta.load("Saves/"+Path);
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //create gambar component
        
        //peta
        peta.paint(g);
        //gambar orang
        //Player ID= 0
        g.drawImage(Resources.TEXTURES.get(0),playerUI.getPosX(),playerUI.getPosY(),null);
    }

    public void keypress(KeyEvent e) {
        int key = e.getKeyCode();
        //JOptionPane.showMessageDialog(null, "Arrow Key ditekan");
        //jika panah atas ditekan
        try {
            if (key==KeyEvent.VK_UP || key==KeyEvent.VK_W) {
                playerUI.atas();
                repaint();
            } else if (key==KeyEvent.VK_DOWN || key==KeyEvent.VK_S) {
                playerUI.bawah();
                repaint();
            } else if (key==KeyEvent.VK_RIGHT || key==KeyEvent.VK_D) {
                playerUI.kanan();
                repaint();
            } else if (key==KeyEvent.VK_LEFT || key==KeyEvent.VK_A) {
                playerUI.kiri();
                repaint();
            }
            else{
                JOptionPane.showMessageDialog(null, "Masukan salah");
            }
        }
        catch (Exception exception){
            System.out.println(exception.toString());
            System.out.println(exception.getMessage());
            //System.out.println(exception.getLocalizedMessage());
            //System.out.println(exception.getCause());
            //System.out.println("Something wrong");
        }
    }
}
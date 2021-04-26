package Map;

import Player.Player;

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
        Player P = new Player("Traveller");
        peta.setPlayer(P);
        this.peta.getPlayer().load("Saves/"+Path);
        this.peta.load("Saves/"+Path);
        this.playerUI.setPlayerPos();
        int level = Math.max(peta.getPlayer().getActive_engimon().getLevel(), peta.getPlayer().getEngimon_as_object().getMaxLevel());
        peta.setMinSpawnLevel(level);
        repaint();
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
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

public class BoardPanel extends JPanel{
    private PlayerUI playerUI;
    private Map peta;

    public BoardPanel(PlayerUI player,Map peta){
        this.playerUI = player;
        this.peta = peta;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //create gambar component
        
        //peta
        ArrayList<ArrayList<Cell>> matriks = peta.getMap();
        for (ArrayList<Cell> ac :matriks){
            for (Cell c : ac){
                int cellX = c.getPosisi().get_y();
                int cellY = c.getPosisi().get_x();
                //1 Mountain, 2 Tundra, 3 Grass, 4 Sea
                switch ((c.getType()).toString()) {
                    case "MOUNTAINS": 
                        g.drawImage(Resources.TEXTURES.get(2),cellX*Tile.SIZE,cellY*Tile.SIZE,null);
                        g.drawImage(Resources.TEXTURES.get(1),cellX*Tile.SIZE,cellY*Tile.SIZE,null);
                        break;
                    case "TUNDRA": 
                        g.drawImage(Resources.TEXTURES.get(2),cellX*Tile.SIZE,cellY*Tile.SIZE,null);
                        break;
                    case "GRASSLAND": 
                        g.drawImage(Resources.TEXTURES.get(3),cellX*Tile.SIZE,cellY*Tile.SIZE,null);
                        break;
                    case "SEA": 
                        g.drawImage(Resources.TEXTURES.get(4),cellX*Tile.SIZE,cellY*Tile.SIZE,null);
                        break;
                    default:
                }
            }
        }
        //gambar orang
        //Player ID= 0
        g.drawImage(Resources.TEXTURES.get(0),playerUI.getPosX(),playerUI.getPosY(),null);
    }

    public void keypress(KeyEvent e) {
        int key = e.getKeyCode();
        //JOptionPane.showMessageDialog(null, "Arrow Key ditekan");
        //jika panah atas ditekan
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
    }
}
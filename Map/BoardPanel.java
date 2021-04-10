import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class BoardPanel extends JPanel{
    // private Orang objOrang;

    public BoardPanel(){
        // objOrang = new Orang();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //create gambar componenr
        //gambar orang
        // g.drawImage(objOrang.getObjImage(),objOrang.getPosX(),objOrang.getPosY(),null);
        // //teks
        // g.drawString(String.format("Kesehatan: %d",objOrang.getKesehatan()),200,200);
    }

    public void keypress(KeyEvent e) {
        int key = e.getKeyCode();
        //jika panah atas ditekan
        // if (key==KeyEvent.VK_UP) {
        //     objOrang.atas();
        //     repaint();
        // } else if (key==KeyEvent.VK_DOWN) {
        //     objOrang.bawah();
        //     repaint();
        // } else if (key==KeyEvent.VK_RIGHT) {
        //     objOrang.kanan();
        //     repaint();
        // } else if (key==KeyEvent.VK_LEFT) {
        //     objOrang.kiri();
        //     repaint();
        // }
    }
}
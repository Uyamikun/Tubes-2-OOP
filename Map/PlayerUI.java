import javax.swing.*;
import java.awt.*;

public class PlayerUI {
    private int posX,posY;
    private int boundX,boundY;

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public PlayerUI(Map peta) {
        //inisialisasi
        posX = 5*Tile.SIZE;
        posY = 2*Tile.SIZE;
        boundX = peta.getMap().get(0).size()-1;
        boundY = peta.getMap().size()-1;
    }

    public void kiri() {
        posX = posX - Tile.SIZE;
    }

    public void kanan() {
        posX = posX + Tile.SIZE;
    }

    public void atas() {
        posY = posY - Tile.SIZE;
    }

    public void bawah() {
        posY = posY + Tile.SIZE;
    }
}

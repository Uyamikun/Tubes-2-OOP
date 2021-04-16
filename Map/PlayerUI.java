import javax.swing.*;
import java.awt.*;

public class PlayerUI {
    private int posX,posY;
    private int boundX,boundY;
    private Map peta;

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public PlayerUI(Map peta) {
        //inisialisasi
        this.peta = peta;
        posX = peta.getPlayerPos().get_x()*Tile.SIZE;
        posY = peta.getPlayerPos().get_y()*Tile.SIZE;
        boundX = (peta.getMap().get(0).size()-1)*Tile.SIZE;
        boundY = (peta.getMap().size()-1)*Tile.SIZE;
    }

    public void kiri() throws Exception{
        if (posX==0){
            throw new Exception("Out of bounds");
        }
        //peta.movePlayer(new Point(peta.getPlayerPos().get_x()-1,peta.getPlayerPos().get_y()));
        posX = posX - Tile.SIZE;
    }

    public void kanan() throws Exception{
        if (posX==boundX){
            throw new Exception("Out of bounds");
        }
        //peta.movePlayer(new Point(peta.getPlayerPos().get_x()+1,peta.getPlayerPos().get_y()));
        posX = posX + Tile.SIZE;
    }

    public void atas() throws Exception{
        if (posY==0){
            throw new Exception("Out of bounds");
        }
        //peta.movePlayer(new Point(peta.getPlayerPos().get_x(),peta.getPlayerPos().get_y()+1));
        posY = posY - Tile.SIZE;
    }

    public void bawah() throws Exception{
        if (posY==boundY){
            throw new Exception("Out of bounds");
        }
        //peta.movePlayer(new Point(peta.getPlayerPos().get_x(),peta.getPlayerPos().get_y()-1));
        posY = posY + Tile.SIZE;
    }
}

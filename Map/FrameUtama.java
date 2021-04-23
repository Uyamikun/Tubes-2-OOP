package Map;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrameUtama extends JFrame {

    private BoardPanel objBoardPanel;

    public FrameUtama(PlayerUI player, Map peta) throws HeadlessException {
        objBoardPanel = new BoardPanel(player,peta);
        add(objBoardPanel); //tambah panel ke frame
        //ukuran 
        int lebarPeta = peta.getMap().get(0).size();
        int panjangPeta = peta.getMap().size();
        setSize((lebarPeta)*Tile.SIZE+16,(panjangPeta+1)*Tile.SIZE+8);
        setTitle("Game Wankymon");
        //setBounds(70,70,0,0);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addKeyListener(new TAdapter());
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            objBoardPanel.keypress(e);
        }
    }
}
package Map;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FrameUtama extends JFrame{

    private BoardPanel objBoardPanel;
    private JPanel inputPanel;
    private JSplitPane splitPane;

    public FrameUtama(PlayerUI player, Map peta) throws HeadlessException{
        objBoardPanel = new BoardPanel(player,peta);
        inputPanel = new JPanel();

        //ukuran 
        int lebarPeta = peta.getMap().get(0).size();
        int panjangPeta = peta.getMap().size();
        setSize(((lebarPeta)*Tile.SIZE+16)+200,((panjangPeta+1)*Tile.SIZE+8));
        setTitle("Game Wankymon");
        //ukuran 12*32 = 384
        //setBounds(70,70,(lebarPeta)*Tile.SIZE+16,(panjangPeta+1)*Tile.SIZE+8);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //split panel
        splitPane = new JSplitPane();
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(splitPane); //tambah panel ke frame
        //configure split panel
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(((lebarPeta)*Tile.SIZE+16)-16);
        //input panel
        inputPanel.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));     // we set the max height to 75 and the max width to (almost) unlimited
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        //Component
        splitPane.setLeftComponent(objBoardPanel);
        //splitPane.setRightComponent(objBoardPanel);
        splitPane.setRightComponent(inputPanel);
        
        //add key listener
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
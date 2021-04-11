import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrameUtama extends JFrame {

    private BoardPanel objBoardPanel;

    public FrameUtama() throws HeadlessException {
        objBoardPanel = new BoardPanel();
        add(objBoardPanel); //tambah panel ke frame
        setSize(600,400);
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
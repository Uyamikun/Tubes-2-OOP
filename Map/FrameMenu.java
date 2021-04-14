import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrameMenu extends JFrame {
    private MenuPanel objMenuPanel;
    private FrameUtama objFrame;

    public  FrameMenu(FrameUtama futama){
        objFrame = futama;
        objMenuPanel = new MenuPanel(this,objFrame);
        add(objMenuPanel);
        setSize(600,400);
        setTitle("Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addKeyListener(new TAdapter());
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            objMenuPanel.keypress(e);
        }
    }
}

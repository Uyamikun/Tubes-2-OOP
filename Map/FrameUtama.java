package Map;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class FrameUtama extends JFrame implements ActionListener {

    private BoardPanel objBoardPanel;
    private JPanel inputPanel;
    private JPanel subPane;
    private JSplitPane splitPane;


    private JScrollPane scrollPane;
    private JButton button_help;
    private JButton button_list_engimon;
    private JButton button_data_engimon;


    public FrameUtama(PlayerUI player, Map peta) throws HeadlessException{
        objBoardPanel = new BoardPanel(player,peta);
        inputPanel = new JPanel();
        //scrollPane = new JScrollPane();
        button_help = new JButton("Test_Help");
        button_help = new JButton( new AbstractAction("Test_Help") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                //Test tambah panel lain
                subPane.setVisible(true);
            }
        });
        button_list_engimon = new JButton("Test_List_Engimon");
        button_data_engimon = new JButton("Test_Data_Engimon");

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

        objBoardPanel.setRequestFocusEnabled(true);

        //split panel
        splitPane = new JSplitPane();
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(splitPane); //tambah panel ke frame
        //configure split panel
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(((lebarPeta)*Tile.SIZE+16)-16);
        //input panel
        inputPanel.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(new Color(105,123,165));
        //Component
        splitPane.setLeftComponent(objBoardPanel);
        splitPane.setRightComponent(inputPanel);
        //inputPanel.add(scrollPane);
        inputPanel.setBorder(new EmptyBorder(10, 15, 10, 15));
        inputPanel.setLayout(new GridBagLayout());

        //Title
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        inputPanel.add(new JLabel("<html><h1><strong><i>Commands</i></strong></h1><hr></html>"), gbc);

        //Kumpulan button dalam grid
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.add(button_help,gbc);
        buttons.add(button_data_engimon,gbc);
        buttons.add(button_list_engimon,gbc);
        inputPanel.add(buttons,gbc);

        subPane = new JPanel();
        subPane.setSize((((lebarPeta)*Tile.SIZE+16)+200)/2,(((panjangPeta+1)*Tile.SIZE+8))/2);
        JButton back = new JButton( new AbstractAction("Back") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                //Test tambah panel lain
                subPane.setVisible(false);
            }
        });
        back.addActionListener(this);
        subPane.add(back);
        objBoardPanel.add(subPane);
        subPane.setVisible(false);

        //Add action listener
//        button_list_engimon.addActionListener(this);
//        button_data_engimon.addActionListener(this);
//        button_help.addActionListener(this);

        //add key listener
        objBoardPanel.addKeyListener(new TAdapter());
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            objBoardPanel.keypress(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //subPane.requestFocusInWindow();
        objBoardPanel.requestFocusInWindow();
    }

    public BoardPanel getObjBoardPanel() {
        return objBoardPanel;
    }
}
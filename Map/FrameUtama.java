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
        //ukuran
        int lebarPeta = peta.getMap().get(0).size();
        int panjangPeta = peta.getMap().size();

        //komponen
        objBoardPanel = new BoardPanel(player,peta);
        inputPanel = new JPanel();
        //scrollPane = new JScrollPane();
        button_help = new JButton( new AbstractAction("Help") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                //Test tambah panel lain
                //Loop through the components
                for(Component c : subPane.getComponents()){
                    //Find the components you want to remove
                    if(c instanceof JPanel || c instanceof JLabel){
                        //Remove it
                        subPane.remove(c);
                    }
                }
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.anchor = GridBagConstraints.NORTH;
                subPane.add(new JLabel("<html><h1><strong><i>HELP</i></strong></h1><hr></html>"), gbc);

                //Kumpulan button dalam grid
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                JPanel labels = new JPanel(new GridBagLayout());
                labels.add(new JLabel("HELP:"),gbc);
                labels.add(new JLabel("W,A,S,D to move"),gbc);
                labels.add(new JLabel("Arrow keys to move"),gbc);
                subPane.add(labels,gbc);
                subPane.setVisible(true);
                //objBoardPanel.moveToFront(objBoardPanel);
            }
        });
        button_list_engimon = new JButton( new AbstractAction("List Engimon") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                //Test tambah panel lain
                //Loop through the components
                for(Component c : subPane.getComponents()){
                    //Find the components you want to remove
                    if(c instanceof JPanel || c instanceof JLabel){
                        //Remove it
                        subPane.remove(c);
                    }
                }
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.anchor = GridBagConstraints.NORTH;
                subPane.add(new JLabel("<html><h1><strong><i>List Engimon</i></strong></h1><hr></html>"), gbc);

                //Kumpulan button dalam grid
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                JPanel labels = new JPanel(new GridBagLayout());
                labels.add(new JLabel("BELUM IMPLEMENTED"),gbc);
                subPane.add(labels,gbc);
                subPane.setVisible(true);
                //objBoardPanel.moveToFront(objBoardPanel);
            }
        });
        button_data_engimon = new JButton( new AbstractAction("Data Engimon") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                //Test tambah panel lain
                //Loop through the components
                for(Component c : subPane.getComponents()){
                    //Find the components you want to remove
                    if(c instanceof JPanel || c instanceof JLabel){
                        //Remove it
                        subPane.remove(c);
                    }
                }
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.anchor = GridBagConstraints.NORTH;
                subPane.add(new JLabel("<html><h1><strong><i>List Engimon</i></strong></h1><hr></html>"), gbc);

                //Kumpulan button dalam grid
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                JPanel labels = new JPanel(new GridBagLayout());
                labels.add(new JLabel("BELUM IMPLEMENTED"),gbc);
                subPane.add(labels,gbc);
                subPane.setVisible(true);
                //objBoardPanel.moveToFront(objBoardPanel);
            }
        });

        //Configure
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

        //subpanel
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        subPane = new JPanel();
        subPane.setLayout(new GridBagLayout());
        subPane.setSize((((lebarPeta)*Tile.SIZE+16)+200)/2,(((panjangPeta+1)*Tile.SIZE+8))/2);
        JButton back = new JButton( new AbstractAction("Back") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                //Test tambah panel lain
                subPane.setVisible(false);
            }
        });
        back.addActionListener(this);
        subPane.add(back,gbc);
        objBoardPanel.add(subPane);
        subPane.setVisible(false);
        //objBoardPanel.moveToBack(subPane);

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
package Map;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class FrameUtama extends JFrame implements ActionListener {

    private BoardPanel objBoardPanel;
    private JPanel inputPanel;
    private JPanel subPane;
    private JSplitPane splitPane;

    private JScrollPane scrollPane;

    //for submenu
//    private String[] optionsMenu;
//    private int selected;
    private JButton button_battle;
    private JButton button_breed;
    private JButton button_rename;
    private JButton button_help;
    private JButton button_interact;
    private JButton button_data_engimon;
    private JButton button_inventory_engimon;
    private JButton button_inventory_skill;
    private JButton button_switch;
    private JButton button_remove_engimon;
    private JButton button_remove_skill;
    private JButton button_save;

    public FrameUtama(PlayerUI player, Map peta) throws HeadlessException{
        //ukuran
        int lebarPeta = peta.getMap().get(0).size();
        int panjangPeta = peta.getMap().size();

        //komponen
        objBoardPanel = new BoardPanel(player,peta);
        inputPanel = new JPanel();
        //scrollPane = new JScrollPane();

        //Sub menu buttons
        button_battle = new JButton( new AbstractAction("Battle") {
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
                subPane.add(new JLabel("<html><h1><strong><i>Battle</i></strong></h1><hr></html>"), gbc);

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

        button_breed = new JButton( new AbstractAction("Breed") {
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
                subPane.add(new JLabel("<html><h1><strong><i>Breed</i></strong></h1><hr></html>"), gbc);

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

        button_rename = new JButton( new AbstractAction("Rename") {
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
                subPane.add(new JLabel("<html><h1><strong><i>Rename</i></strong></h1><hr></html>"), gbc);

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

        button_interact = new JButton( new AbstractAction("Interact") {
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
                subPane.add(new JLabel("<html><h1><strong><i>Interact</i></strong></h1><hr></html>"), gbc);

                //Kumpulan button dalam grid
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                JPanel labels = new JPanel(new GridBagLayout());
                labels.add(new JLabel(peta.getPlayer().interact()),gbc);
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
                subPane.add(new JLabel("<html><h1><strong><i>Data Engimon</i></strong></h1><hr></html>"), gbc);

                //Kumpulan button dalam grid
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                JPanel subs = new JPanel(new GridBagLayout());
                String[] arrListEngimon = peta.getPlayer().display_list_engimon().split("\n");
                for (String arg: arrListEngimon) {
                    subs.add(new JButton( new AbstractAction("Data Engimon") {
                        @Override
                        public void actionPerformed( ActionEvent e ) {

                        }
                    }),gbc);
                }
                subs.add(new JLabel("BELUM IMPLEMENTED"),gbc);
                subPane.add(subs,gbc);
                subPane.setVisible(true);
                //objBoardPanel.moveToFront(objBoardPanel);
            }
        });

        button_inventory_engimon = new JButton( new AbstractAction("Inventory Engimon") {
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
                String[] arrListEngimon = peta.getPlayer().display_list_engimon().split("\n");
                for (String arg: arrListEngimon) {
                    labels.add(new JLabel(arg),gbc);
                }
                subPane.add(labels,gbc);
                subPane.setVisible(true);
                //objBoardPanel.moveToFront(objBoardPanel);
            }
        });

        button_inventory_skill = new JButton(new AbstractAction("Inventory Skill") {
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
                subPane.add(new JLabel("<html><h1><strong><i>List Skill</i></strong></h1><hr></html>"), gbc);

                //Kumpulan button dalam grid
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                JPanel labels = new JPanel(new GridBagLayout());
                String[] arrListSkill = peta.getPlayer().display_list_skill().split("\n");
                for (String arg: arrListSkill) {
                    labels.add(new JLabel(arg),gbc);
                }
                subPane.add(labels,gbc);
                subPane.setVisible(true);
                //objBoardPanel.moveToFront(objBoardPanel);
            }
        });

        button_switch = new JButton( new AbstractAction("Switch Engimon") {
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
                subPane.add(new JLabel("<html><h1><strong><i>Switch Engimon</i></strong></h1><hr></html>"), gbc);

                //Kumpulan button dalam grid
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                JPanel labels = new JPanel(new GridBagLayout());
                labels.add(new JLabel("BELUM IMPLEMENTED"),gbc);
//                String[] arrListSkill = peta.getPlayer().display_list_skill().split("\n");
//                for (String arg: arrListSkill) {
//                    labels.add(new JLabel(arg),gbc);
//                }
                subPane.add(labels,gbc);
                subPane.setVisible(true);
                //objBoardPanel.moveToFront(objBoardPanel);
            }
        });

        button_remove_engimon = new JButton( new AbstractAction("Remove Engimon") {
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
                subPane.add(new JLabel("<html><h1><strong><i>Remove Engimon</i></strong></h1><hr></html>"), gbc);

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

        button_remove_skill = new JButton( new AbstractAction("Remove Skill") {
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
                subPane.add(new JLabel("<html><h1><strong><i>Remove Skill</i></strong></h1><hr></html>"), gbc);

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

        button_save = new JButton( new AbstractAction("Save") {
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
                subPane.add(new JLabel("<html><h1><strong><i>Save</i></strong></h1><hr></html>"), gbc);

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
        buttons.setBackground(new Color(105,123,165));
        buttons.add(button_help,gbc);
        buttons.add(button_battle,gbc);
        buttons.add(button_breed,gbc);
        buttons.add(button_rename,gbc);
        buttons.add(button_interact,gbc);
        buttons.add(button_data_engimon,gbc);
        buttons.add(button_inventory_engimon,gbc);
        buttons.add(button_inventory_skill,gbc);
        buttons.add(button_switch,gbc);
        buttons.add(button_remove_engimon,gbc);
        buttons.add(button_remove_skill,gbc);
        buttons.add(button_save,gbc);
        inputPanel.add(buttons,gbc);

        //subpanel
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        subPane = new JPanel();
        subPane.setLayout(new GridBagLayout());
        //subPane.setBackground(new Color(105,123,165));
        subPane.setSize((((lebarPeta)*Tile.SIZE+16)+200)/2,(((panjangPeta+1)*Tile.SIZE+8))/2);
        inputPanel.setBorder(new EmptyBorder(10, 15, 10, 15));
        JButton back = new JButton( new AbstractAction("Back") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                //Test tambah panel lain
                subPane.setVisible(false);
            }
        });
        back.addActionListener(this);
        subPane.add(back,gbc);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridwidth = GridBagConstraints.CENTER;
        gbc2.anchor = GridBagConstraints.NORTH;
        objBoardPanel.add(subPane,gbc2);
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
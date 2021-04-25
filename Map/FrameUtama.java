package Map;
import Engimon.Engimon;
import Player.InventoryEngimon;
import Player.InventorySkillItem;
import Player.SkillItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class FrameUtama extends JFrame implements ActionListener {

    private BoardPanel objBoardPanel;
    private JPanel inputPanel;
    private SubPanel subPane;
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
    private JButton button_learn_skill;
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
                //Create combobox
                InventoryEngimon invEngimon = peta.getPlayer().getEngimon_as_object();
                ArrayList<String> namaEngimon = new ArrayList<String>();
                if(invEngimon.getObject().size() > 0){
                    for(Engimon engi : invEngimon.getObject()){
                        namaEngimon.add(engi.getName());
                    }
                }
                subPane.c1 = new JComboBox(namaEngimon.toArray());
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                JPanel labels2 = new JPanel();
                labels2.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                labels2.setLayout(new BoxLayout(labels2, BoxLayout.Y_AXIS));
                subPane.c1.addItemListener(subPane);
                subPane.l = new JLabel("Select your engimon ");
                subPane.l2 = new JLabel("");
                JLabel nama = new JLabel("Masukkan nama yang baru:");
                JTextField tf1=new JTextField();

                JButton buttonEnter = new JButton(new AbstractAction("Enter") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        subPane.remove(labels2);
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.anchor = GridBagConstraints.CENTER;
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        JPanel labels3 = new JPanel();
                        labels3.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                        labels3.setLayout(new BoxLayout(labels3, BoxLayout.Y_AXIS));
                        //debug
                        System.out.println(subPane.c1.getSelectedIndex());
                        if(peta.getPlayer().getEngimon_as_object().rename(subPane.c1.getSelectedIndex()+1, tf1.getText())){
                            labels3.add(new JLabel("Berhasil mengganti nama engimon :)"),gbc);
                        } else{
                            labels3.add(new JLabel("Gagal mengganti nama engimon :("),gbc);
                        }
                        subPane.add(labels3,gbc);
                        subPane.revalidate();
                        subPane.repaint();
                    }
                });

                labels2.add(subPane.l,gbc);
                labels2.add(subPane.l2,gbc);
                labels2.add(subPane.c1,gbc);
                labels2.add(nama,gbc);
                labels2.add(tf1,gbc);
                labels2.add(buttonEnter,gbc);
                subPane.add(labels2,gbc);
                subPane.revalidate();
                subPane.repaint();
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

                //Bentuk grid
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                JPanel labels = new JPanel(new GridBagLayout());
                //Invent engimon
                String[] arrListEngimon = peta.getPlayer().display_list_engimon().split("\n");
                for (String arg: arrListEngimon) {
                    labels.add(new JLabel(arg),gbc);
                }

                JButton button1 = new JButton(new AbstractAction("Active Engimon") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for(Component c : subPane.getComponents()){
                            //Find the components you want to remove
                            if(c instanceof JPanel || c instanceof JLabel){
                                //Remove it
                                subPane.remove(c);
                            }
                        }
                        //subPane.remove(labels);
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.anchor = GridBagConstraints.CENTER;
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        JPanel labels2 = new JPanel();
                        labels2.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                        labels2.setLayout(new BoxLayout(labels2, BoxLayout.Y_AXIS));
                        //JPanel labels2 = new JPanel(new GridBagLayout());
                        //System.out.println(peta.getPlayer().getActive_engimon().printDetail());
                        String[] arrListDetail = peta.getPlayer().getActive_engimon().printDetail().split("\n");
                        for (String arg: arrListDetail) {
                            System.out.println(arg);
                            labels2.add(new JLabel(arg),gbc);
                        }

                        subPane.add(labels2,gbc);
                        subPane.revalidate();
                        subPane.repaint();
                    }
                });

                JButton button2 = new JButton(new AbstractAction("Inventory Engimon") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for(Component c : subPane.getComponents()){
                            //Find the components you want to remove
                            if(c instanceof JPanel || c instanceof JLabel){
                                //Remove it
                                subPane.remove(c);
                            }
                        }
                        //Create combobox
                        InventoryEngimon invEngimon = peta.getPlayer().getEngimon_as_object();
                        ArrayList<String> namaEngimon = new ArrayList<String>();
                        if(invEngimon.getObject().size() > 0){
                            for(Engimon engi : invEngimon.getObject()){
                                namaEngimon.add(engi.getName());
                            }
                        }
                        subPane.c1 = new JComboBox(namaEngimon.toArray());
//                        this.engimon_as_object.get(idx1).printDetail();
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.anchor = GridBagConstraints.CENTER;
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        JPanel labels2 = new JPanel();
                        labels2.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                        labels2.setLayout(new BoxLayout(labels2, BoxLayout.Y_AXIS));
                        subPane.c1.addItemListener(subPane);
                        subPane.l = new JLabel("Select your engimon ");
                        subPane.l2 = new JLabel("");

                        JButton buttonEnter = new JButton(new AbstractAction("Enter") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                subPane.remove(labels2);
                                GridBagConstraints gbc = new GridBagConstraints();
                                gbc.anchor = GridBagConstraints.CENTER;
                                gbc.fill = GridBagConstraints.HORIZONTAL;
                                JPanel labels3 = new JPanel();
                                labels3.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                                labels3.setLayout(new BoxLayout(labels3, BoxLayout.Y_AXIS));
                                //debug
                                System.out.println(subPane.c1.getSelectedIndex());
                                String[] arrListDetail = peta.getPlayer().getEngimon_as_object().get(subPane.c1.getSelectedIndex()+1).printDetail().split("\n");
                                for (String arg: arrListDetail) {
                                    System.out.println(arg);
                                    labels3.add(new JLabel(arg),gbc);
                                }
                                subPane.add(labels3,gbc);
                                subPane.revalidate();
                                subPane.repaint();
                            }
                        });

                        labels2.add(subPane.l,gbc);
                        labels2.add(subPane.l2,gbc);
                        labels2.add(subPane.c1,gbc);
                        labels2.add(buttonEnter,gbc);
                        subPane.add(labels2,gbc);
                        subPane.revalidate();
                        subPane.repaint();
                    }
                });
                JPanel buttons = new JPanel(new GridBagLayout());
                buttons.add(button1,gbc);
                buttons.add(button2,gbc);
                subPane.add(labels,gbc);
                subPane.add(buttons,gbc);
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
                //Create combobox
                InventoryEngimon invEngimon = peta.getPlayer().getEngimon_as_object();
                ArrayList<String> namaEngimon = new ArrayList<String>();
                if(invEngimon.getObject().size() > 0){
                    for(Engimon engi : invEngimon.getObject()){
                        namaEngimon.add(engi.getName());
                    }
                }
                subPane.c1 = new JComboBox(namaEngimon.toArray());
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                JPanel labels2 = new JPanel();
                labels2.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                labels2.setLayout(new BoxLayout(labels2, BoxLayout.Y_AXIS));
                subPane.c1.addItemListener(subPane);
                subPane.l = new JLabel("Select your engimon ");
                subPane.l2 = new JLabel("");

                JButton buttonEnter = new JButton(new AbstractAction("Switch") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        subPane.remove(labels2);
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.anchor = GridBagConstraints.CENTER;
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        JPanel labels3 = new JPanel();
                        labels3.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                        labels3.setLayout(new BoxLayout(labels3, BoxLayout.Y_AXIS));
                        //debug
                        System.out.println(subPane.c1.getSelectedIndex());
                        if(peta.getPlayer().getEngimon_as_object().isIdxValid(subPane.c1.getSelectedIndex()+1)){
                            //Untuk switch engimonUI perlu switch manual
                            peta.getPlayer().setActive_engimon(peta.getPlayer().getEngimon_as_object().switchObj(subPane.c1.getSelectedIndex()+1,peta.getPlayer().getActive_engimon()));
                            peta.setActiveEngimon(peta.getPlayer().getActive_engimon());
                            //peta.getPlayer().getActive_engimon() = peta.getPlayer().getEngimon_as_object().switchObj(subPane.c1.getSelectedIndex()+1,peta.getPlayer().getActive_engimon());
                            labels3.add(new JLabel("Berhasil menukar active engimon :)"),gbc);
                        } else{
                            labels3.add(new JLabel("Gagal menukar active engimon :("),gbc);
                        }
                        objBoardPanel.repaint();
                        subPane.add(labels3,gbc);
                        subPane.revalidate();
                        subPane.repaint();
                    }
                });

                labels2.add(subPane.l,gbc);
                labels2.add(subPane.l2,gbc);
                labels2.add(subPane.c1,gbc);
                labels2.add(buttonEnter,gbc);
                subPane.add(labels2,gbc);
                subPane.revalidate();
                subPane.repaint();
                subPane.setVisible(true);
            }
        });

        button_learn_skill = new JButton( new AbstractAction("Learn Skill") {
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
                subPane.add(new JLabel("<html><h1><strong><i>Learn Skill</i></strong></h1><hr></html>"), gbc);

                //Bentuk grid
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                JPanel labels = new JPanel(new GridBagLayout());
                //Invent engimon
                String[] arrListSkill = peta.getPlayer().display_list_skill().split("\n");
                for (String arg: arrListSkill) {
                    labels.add(new JLabel(arg),gbc);
                }

                //Combo box skill
                InventorySkillItem invSkill = peta.getPlayer().getSkill_as_object();
                ArrayList<String> namaSkill = new ArrayList<String>();
                if(invSkill.getObject().size() > 0){
                    for(SkillItem si : invSkill.getObject()){
                        namaSkill.add(si.getSkillName());
                    }
                }
                JComboBox comboSkill = new JComboBox(namaSkill.toArray());

                JButton button1 = new JButton(new AbstractAction("Active Engimon") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for(Component c : subPane.getComponents()){
                            //Find the components you want to remove
                            if(c instanceof JPanel || c instanceof JLabel){
                                //Remove it
                                subPane.remove(c);
                            }
                        }
                        //subPane.remove(labels);
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.anchor = GridBagConstraints.CENTER;
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        JPanel labels2 = new JPanel();
                        labels2.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                        labels2.setLayout(new BoxLayout(labels2, BoxLayout.Y_AXIS));
                        //JPanel labels2 = new JPanel(new GridBagLayout());
                        //System.out.println(peta.getPlayer().getActive_engimon().printDetail());
                        Engimon temp = peta.getPlayer().getActive_engimon();
                        if(peta.getPlayer().getSkill_as_object().learnSkill(comboSkill.getSelectedIndex()+1,temp)){
                            labels2.add(new JLabel("Berhasil melakukan learn skill item ^_^"),gbc); // Jika x > jumlah skill item, skill item tersebut akan dihapus
                        } else{
                            labels2.add(new JLabel("Gagal melakukan learn skill item :{ "),gbc);
                        }
                        subPane.add(labels2,gbc);
                        subPane.revalidate();
                        subPane.repaint();
                    }
                });

                JButton button2 = new JButton(new AbstractAction("Inventory Engimon") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for(Component c : subPane.getComponents()){
                            //Find the components you want to remove
                            if(c instanceof JPanel || c instanceof JLabel){
                                //Remove it
                                subPane.remove(c);
                            }
                        }
                        //Create combobox
                        InventoryEngimon invEngimon = peta.getPlayer().getEngimon_as_object();
                        ArrayList<String> namaEngimon = new ArrayList<String>();
                        if(invEngimon.getObject().size() > 0){
                            for(Engimon engi : invEngimon.getObject()){
                                namaEngimon.add(engi.getName());
                            }
                        }
                        subPane.c1 = new JComboBox(namaEngimon.toArray());
//                        this.engimon_as_object.get(idx1).printDetail();
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.anchor = GridBagConstraints.CENTER;
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        JPanel labels2 = new JPanel();
                        labels2.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                        labels2.setLayout(new BoxLayout(labels2, BoxLayout.Y_AXIS));
                        subPane.c1.addItemListener(subPane);
                        subPane.l = new JLabel("Select your engimon ");
                        subPane.l2 = new JLabel("");

                        JButton buttonEnter = new JButton(new AbstractAction("Enter") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                subPane.remove(labels2);
                                GridBagConstraints gbc = new GridBagConstraints();
                                gbc.anchor = GridBagConstraints.CENTER;
                                gbc.fill = GridBagConstraints.HORIZONTAL;
                                JPanel labels3 = new JPanel();
                                labels3.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                                labels3.setLayout(new BoxLayout(labels3, BoxLayout.Y_AXIS));
                                //debug
                                System.out.println(subPane.c1.getSelectedIndex());
                                Engimon temp = peta.getPlayer().getEngimon_as_object().get(subPane.c1.getSelectedIndex()+1);
                                if(peta.getPlayer().getSkill_as_object().learnSkill(comboSkill.getSelectedIndex()+1,temp)){
                                    labels3.add(new JLabel("Berhasil melakukan learn skill item ^_^"),gbc); // Jika x > jumlah skill item, skill item tersebut akan dihapus
                                } else{
                                    labels3.add(new JLabel("Gagal melakukan learn skill item :{ "),gbc);
                                }
                                subPane.add(labels3,gbc);
                                subPane.revalidate();
                                subPane.repaint();
                            }
                        });

                        labels2.add(subPane.l,gbc);
                        labels2.add(subPane.l2,gbc);
                        labels2.add(subPane.c1,gbc);
                        labels2.add(buttonEnter,gbc);
                        subPane.add(labels2,gbc);
                        subPane.revalidate();
                        subPane.repaint();
                    }
                });
                JPanel buttons = new JPanel(new GridBagLayout());
                buttons.add(new JLabel("Pilih skill yang akan di-learn: "));
                buttons.add(comboSkill,gbc);
                buttons.add(button1,gbc);
                buttons.add(button2,gbc);
                subPane.add(labels,gbc);
                subPane.add(buttons,gbc);
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

                //Create combobox
                InventoryEngimon invEngimon = peta.getPlayer().getEngimon_as_object();
                ArrayList<String> namaEngimon = new ArrayList<String>();
                if(invEngimon.getObject().size() > 0){
                    for(Engimon engi : invEngimon.getObject()){
                        namaEngimon.add(engi.getName());
                    }
                }
                subPane.c1 = new JComboBox(namaEngimon.toArray());
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                JPanel labels2 = new JPanel();
                labels2.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                labels2.setLayout(new BoxLayout(labels2, BoxLayout.Y_AXIS));
                subPane.c1.addItemListener(subPane);
                subPane.l = new JLabel("Select your engimon ");
                subPane.l2 = new JLabel("");

                JButton buttonEnter = new JButton(new AbstractAction("Enter") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        subPane.remove(labels2);
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.anchor = GridBagConstraints.CENTER;
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        JPanel labels3 = new JPanel();
                        labels3.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                        labels3.setLayout(new BoxLayout(labels3, BoxLayout.Y_AXIS));
                        //debug
                        System.out.println(subPane.c1.getSelectedIndex());
                        if(peta.getPlayer().getEngimon_as_object().removeItem(subPane.c1.getSelectedIndex()+1)){
                            labels3.add(new JLabel("Berhasil menelantarkan engimon :)"),gbc); // Jika x > jumlah skill item, skill item tersebut akan dihapus
                        } else{
                            labels3.add(new JLabel("Gagal menelantarkan engimon :("),gbc);
                        }
                        subPane.add(labels3,gbc);
                        subPane.revalidate();
                        subPane.repaint();
                    }
                });

                labels2.add(subPane.l,gbc);
                labels2.add(subPane.l2,gbc);
                labels2.add(subPane.c1,gbc);
                labels2.add(buttonEnter,gbc);
                subPane.add(labels2,gbc);
                subPane.revalidate();
                subPane.repaint();
                subPane.setVisible(true);
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

                //Create combobox
                InventorySkillItem invSkill = peta.getPlayer().getSkill_as_object();
                ArrayList<String> namaSkill = new ArrayList<String>();
                if(invSkill.getObject().size() > 0){
                    for(SkillItem si : invSkill.getObject()){
                        namaSkill.add(si.getSkillName());
                    }
                }
                subPane.c1 = new JComboBox(namaSkill.toArray());
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                JPanel labels2 = new JPanel();
                labels2.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                labels2.setLayout(new BoxLayout(labels2, BoxLayout.Y_AXIS));
                subPane.c1.addItemListener(subPane);
                subPane.l = new JLabel("Pilih skill item mana yang ingin dibuang: ");
                subPane.l2 = new JLabel("");
                JLabel kuantitas = new JLabel("Pilih berapa jumlah skill item yang akan dibuang: ");
                JTextField tf1=new JTextField();

                JButton buttonEnter = new JButton(new AbstractAction("Enter") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        subPane.remove(labels2);
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.anchor = GridBagConstraints.CENTER;
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        JPanel labels3 = new JPanel();
                        labels3.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                        labels3.setLayout(new BoxLayout(labels3, BoxLayout.Y_AXIS));
                        //debug
                        System.out.println(subPane.c1.getSelectedIndex());
                        if(peta.getPlayer().getSkill_as_object().removeX(subPane.c1.getSelectedIndex()+1,Integer.parseInt(tf1.getText()))){
                            labels3.add(new JLabel("Berhasil membuang skill item :)"),gbc); // Jika x > jumlah skill item, skill item tersebut akan dihapus
                        } else{
                            labels3.add(new JLabel("Gagal membuang skill item :("),gbc);
                        }
                        subPane.add(labels3,gbc);
                        subPane.revalidate();
                        subPane.repaint();
                    }
                });

                labels2.add(subPane.l,gbc);
                labels2.add(subPane.l2,gbc);
                labels2.add(subPane.c1,gbc);
                labels2.add(kuantitas,gbc);
                labels2.add(tf1,gbc);
                labels2.add(buttonEnter,gbc);
                subPane.add(labels2,gbc);
                subPane.revalidate();
                subPane.repaint();
                subPane.setVisible(true);
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
        setSize(((lebarPeta)*Tile.SIZE+16)+416,((panjangPeta+1)*Tile.SIZE+8));
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
        inputPanel.setBorder(new EmptyBorder(0, 15, 10, 15));
        inputPanel.setLayout(new GridBagLayout());
        //Scrollable
        inputPanel.setAutoscrolls(true);
        JScrollPane scrollFrame = new JScrollPane(inputPanel);
        scrollFrame.setPreferredSize(new Dimension( 800,300));
        this.add(scrollFrame);

        //Title
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        inputPanel.add(new JLabel("<html><h1>Commands</h1></html>"), gbc);

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
        buttons.add(button_learn_skill,gbc);
        buttons.add(button_remove_engimon,gbc);
        buttons.add(button_remove_skill,gbc);
        buttons.add(button_save,gbc);
        inputPanel.add(buttons,gbc);

        //subpanel
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
//        subPane = new JPanel();
        subPane = new SubPanel();
        subPane.setLayout(new GridBagLayout());
        //subPane.setBackground(new Color(105,123,165));
        subPane.setSize((((lebarPeta)*Tile.SIZE+16)+200)/2,(((panjangPeta+1)*Tile.SIZE+8)));
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
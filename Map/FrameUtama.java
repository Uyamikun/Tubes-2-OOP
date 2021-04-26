package Map;
import Battle.Battle;
import Engimon.Engimon;
import Engimon.Breeding;
import Engimon.BreedingInvalidException;
import Player.InventoryEngimon;
import Player.InventorySkillItem;
import Player.SkillItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;
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
                ArrayList<Engimon> engimons = peta.getNearbyEngimon();
                ArrayList<String> namaEngimon = new ArrayList<String>();
                if(engimons.size() > 0){
                    for(Engimon engi : engimons){
                        namaEngimon.add(engi.getSpecies() + "/Lvl: " + engi.getLevel());
                    }
                }
                subPane.c1 = new JComboBox(namaEngimon.toArray());
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                JPanel labels2 = new JPanel();
                labels2.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                labels2.setLayout(new BoxLayout(labels2, BoxLayout.Y_AXIS));
                subPane.c1.addItemListener(subPane);
                subPane.l = new JLabel("Select engimon to battle");
                subPane.l2 = new JLabel("");

                JButton buttonEnter = new JButton(new AbstractAction("Select") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        subPane.remove(labels2);
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.anchor = GridBagConstraints.CENTER;
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        JPanel labels4 = new JPanel();
                        labels4.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                        labels4.setLayout(new BoxLayout(labels4, BoxLayout.Y_AXIS));
                        String[] arrListDetail = engimons.get(subPane.c1.getSelectedIndex()).printDetail().split("\n");
                        labels4.add(new JLabel(arrListDetail[3]),gbc);
                        labels4.add(new JLabel(arrListDetail[5]),gbc);
                        for (int i=13;i<arrListDetail.length;i++) {
                            labels4.add(new JLabel(arrListDetail[i]),gbc);
                        }
                        labels4.add(new JLabel("================== Power ==================" ), gbc);

                        Battle b = new Battle(peta.getPlayer().getActive_engimon(), engimons.get(subPane.c1.getSelectedIndex()));
                        labels4.add(new JLabel("Your Power: " + b.calculatePowerPlayer()), gbc);
                        labels4.add(new JLabel("Enemy Power: " + b.calculatePowerEnemy()), gbc);
                        //labels4.add(new JLabel(arg),gbc);

                        JButton buttonBattle = new JButton(new AbstractAction("Battle"){
                            public void actionPerformed(ActionEvent e) {
                                subPane.remove(labels4);
                                GridBagConstraints gbc = new GridBagConstraints();
                                gbc.anchor = GridBagConstraints.CENTER;
                                gbc.fill = GridBagConstraints.HORIZONTAL;
                                JPanel labels3 = new JPanel();
                                labels3.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                                labels3.setLayout(new BoxLayout(labels3, BoxLayout.Y_AXIS));

                                if(subPane.c1.getSelectedIndex() < engimons.size()){
                                    boolean win = false;
                                    try{
                                        win = peta.getPlayer().Battle(engimons.get(subPane.c1.getSelectedIndex()));
                                    }catch (Exception err){
                                        if (err.getMessage().equals("Game Over")){
                                            labels3.add(new JLabel("Anda tidak punya engimon lagi"));
                                            //game over
                                        }else {
                                            labels3.add(new JLabel(err.getMessage()));
                                        }
                                    }
                                    if (win){
                                        peta.getPlayer().getActive_engimon().changeExp(50);
                                        peta.removeEngimon(engimons.get(subPane.c1.getSelectedIndex()));
                                        labels3.add(new JLabel("You Win"),gbc);
                                    }else {
                                        labels3.add(new JLabel("You Lose"), gbc);
                                        peta.setActiveEngimon(peta.getPlayer().getActive_engimon());
                                    }
                                    int level = Math.max(peta.getPlayer().getActive_engimon().getLevel(), peta.getPlayer().getEngimon_as_object().getMaxLevel());
                                    peta.setMinSpawnLevel(level);

                                } else{
                                    labels3.add(new JLabel("Gagal Memulai Battle"),gbc);
                                }
                                objBoardPanel.repaint();
                                subPane.add(labels3,gbc);
                                subPane.revalidate();
                                subPane.repaint();
                            }
                        });
                        labels4.add(buttonBattle);
                        //debug
                        objBoardPanel.repaint();
                        subPane.add(labels4,gbc);
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
                if(peta.getPlayer().getEngimon_as_object().getNeff() >= 2)
                {
                    //Create combobox
                    InventoryEngimon invEngimon = peta.getPlayer().getEngimon_as_object();
                    ArrayList<String> namaEngimon = new ArrayList<String>();
                    if(invEngimon.getObject().size() > 0){
                        for(Engimon engi : invEngimon.getObject()){
                            namaEngimon.add(engi.getName());
                        }
                    }
                    subPane.c1 = new JComboBox(namaEngimon.toArray());
                    subPane.c2 = new JComboBox(namaEngimon.toArray());
                    gbc.anchor = GridBagConstraints.CENTER;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    JPanel labels2 = new JPanel();
                    labels2.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                    labels2.setLayout(new BoxLayout(labels2, BoxLayout.Y_AXIS));
                    subPane.c1.addItemListener(subPane);
                    subPane.l2 = new JLabel("");
                    subPane.c2.addItemListener(subPane);
                    subPane.l3 = new JLabel("");

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
                            System.out.println(subPane.c2.getSelectedIndex());
                            int idx1 = subPane.c1.getSelectedIndex()+1;
                            int idx2 = subPane.c2.getSelectedIndex()+1;
                            if(idx1 != idx2 && idx1 >= 1 && idx1 <= peta.getPlayer().getEngimon_as_object().getNeff() && idx2 >= 1 && idx2 <= peta.getPlayer().getEngimon_as_object().getNeff()) {
                                Engimon e1 = peta.getPlayer().getEngimon_as_object().get(idx1);
                                Engimon e2 = peta.getPlayer().getEngimon_as_object().get(idx2);
                                try
                                {
                                    Engimon Child = Breeding.startBreeding(e1, e2);
                                    if (!tf1.getText().equals(""))
                                    {
                                        Child.setName(tf1.getText());
                                    }
                                    peta.getPlayer().getEngimon_as_object().setObj(idx1, e1);
                                    peta.getPlayer().getEngimon_as_object().setObj(idx2, e2);
                                    if(peta.getPlayer().getEngimon_as_object().insert(Child)){
                                        labels3.add(new JLabel("Berhasil menyimpan anak engimon ke Inventory :)"),gbc);
                                    } else{
                                        labels3.add(new JLabel("Maaf inventory anda penuh"),gbc);
                                        //menelantarkan tidak ada
                                    }
                                }
                                catch(BreedingInvalidException exce){
                                    labels3.add(new JLabel("Maaf engimon untuk breeding invalid (level salah)"),gbc);
                                }
                                //peta.getPlayer().breeding(e1, e2, idx1, idx2);
                            }
                            else
                            {
                                labels3.add(new JLabel("Engimon yang anda masukkan tidak valid :("),gbc);
                            }
                            subPane.add(labels3,gbc);
                            subPane.revalidate();
                            subPane.repaint();
                        }
                    });

                    labels2.add(new JLabel("Select first engimon"),gbc);
                    labels2.add(subPane.l2,gbc);
                    labels2.add(subPane.c1,gbc);
                    labels2.add(new JLabel("Select second engimon"),gbc);
                    labels2.add(subPane.l3,gbc);
                    labels2.add(subPane.c2,gbc);
                    labels2.add(nama,gbc);
                    labels2.add(tf1,gbc);
                    labels2.add(buttonEnter,gbc);
                    subPane.add(labels2,gbc);
                    subPane.revalidate();
                    subPane.repaint();
                }
                else
                {
                    JPanel labels2 = new JPanel();
                    labels2.add(new JLabel("Anda tidak mempunyai cukup engimon di Inventory :("),gbc);
                    subPane.add(labels2,gbc);
                    subPane.revalidate();
                    subPane.repaint();
                }
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
                        //punya 4 skill
                        if(temp.getEngimonSkill().size()>=4){
                            JComboBox comboSkill2 = new JComboBox(namaSkill.toArray());
                            labels2.add(new JLabel("Harus melupakan salah satu skill"),gbc);
                            JButton buttonForget = new JButton(new AbstractAction("Forget") {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    for(Component c : subPane.getComponents()){
                                        //Find the components you want to remove
                                        if(c instanceof JPanel || c instanceof JLabel){
                                            //Remove it
                                            subPane.remove(c);
                                        }
                                    }
                                    peta.getPlayer().getEngimon_as_object().setObj(comboSkill2.getSelectedIndex()+1,temp);
                                    temp.setEngimonSkill(peta.getPlayer().getSkill_as_object().get(comboSkill.getSelectedIndex()+1));
                                    labels2.add(new JLabel("Berhasil melakukan learn skill item ^_^"),gbc);
                                    subPane.add(labels2,gbc);
                                    subPane.revalidate();
                                    subPane.repaint();
                                }
                            });
                            labels2.add(comboSkill2,gbc);
                            labels2.add(buttonForget,gbc);
                        }
                        else{
                            if(peta.getPlayer().getSkill_as_object().learnSkill(comboSkill.getSelectedIndex()+1,temp)){
                                labels2.add(new JLabel("Berhasil melakukan learn skill item ^_^"),gbc);
                            } else{
                                labels2.add(new JLabel("Gagal melakukan learn skill item :{ "),gbc);
                            }
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
                                Engimon temp = peta.getPlayer().getEngimon_as_object().get(subPane.c1.getSelectedIndex()+1);
                                //punya 4 skill
                                if(temp.getEngimonSkill().size()>=4){
                                    JComboBox comboSkill2 = new JComboBox(namaSkill.toArray());
                                    labels3.add(new JLabel("Harus melupakan salah satu skill"),gbc);
                                    JButton buttonForget = new JButton(new AbstractAction("Forget") {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            subPane.remove(labels3);
                                            JPanel labels4 = new JPanel();
                                            labels4.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                                            labels4.setLayout(new BoxLayout(labels4, BoxLayout.Y_AXIS));
                                            peta.getPlayer().getEngimon_as_object().setObj(comboSkill2.getSelectedIndex()+1,temp);
                                            temp.setEngimonSkill(peta.getPlayer().getSkill_as_object().get(comboSkill.getSelectedIndex()+1));
                                            labels4.add(new JLabel("Berhasil melakukan learn skill item ^_^"),gbc);
                                            subPane.add(labels4,gbc);
                                            subPane.revalidate();
                                            subPane.repaint();
                                        }
                                    });
                                    labels3.add(comboSkill2,gbc);
                                    labels3.add(buttonForget,gbc);
                                }
                                else{
                                    if(peta.getPlayer().getSkill_as_object().learnSkill(comboSkill.getSelectedIndex()+1,temp)){
                                        labels3.add(new JLabel("Berhasil melakukan learn skill item ^_^"),gbc);
                                    } else{
                                        labels3.add(new JLabel("Gagal melakukan learn skill item :{ "),gbc);
                                    }
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

                String[] arrListSkill = peta.getPlayer().display_list_skill().split("\n");
                for (String arg: arrListSkill) {
                    labels2.add(new JLabel(arg),gbc);
                }

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
                JLabel nama = new JLabel("Masukkan nama save:");
                JTextField tf1=new JTextField();

                JButton buttonEnter = new JButton(new AbstractAction("Enter") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        subPane.remove(labels);
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.anchor = GridBagConstraints.CENTER;
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        JPanel labels3 = new JPanel();
                        labels3.setMaximumSize(new Dimension(75,Integer.MAX_VALUE));
                        labels3.setLayout(new BoxLayout(labels3, BoxLayout.Y_AXIS));
                        // Save player state belum
                        try{
                            peta.save("Saves/"+tf1.getText());
                            labels3.add(new JLabel("Berhasil melakukan save"),gbc);
                        }catch (Exception err){
                            labels3.add(new JLabel(err.getMessage()),gbc);
                        }
                        subPane.add(labels3,gbc);
                        subPane.revalidate();
                        subPane.repaint();
                    }
                });
                labels.add(buttonEnter);
                labels.add(nama,gbc);
                labels.add(tf1,gbc);
                subPane.add(labels);
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
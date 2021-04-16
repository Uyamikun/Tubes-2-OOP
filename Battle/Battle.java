package Battle;

import Engimon.*;

import java.util.ArrayList;

public class Battle {
    private Engimon player;
    private Engimon enemy;

    private static Double[][] matrixAdvantage =
    {
        {1.0,0.0,1.0,0.5,2.0},
        {2.0,1.0,0.0,1.0,1.0},
        {1.0,2.0,1.0,0.0,1.5},
        {1.5,1.0,2.0,1.0,0.0},
        {0.0,1.0,0.5,2.0,1.0}
    };

    private static ArrayList<String> arrayElemenString = new ArrayList<String>(){{add("Fire");add("Water");add("Electric");add("Ground");add("Ice");}};

    public Battle(Engimon player_input, Engimon enemy_input){
        this.player = player_input;
        this.enemy = enemy_input;
    }

    //setter
    public void setPlayer(Engimon player_input) {
        this.player = player_input;
    }

    public void setEnemy(Engimon enemy_input) {
        this.enemy = enemy_input;
    }

    public static int getIndexElement(String elemen){
        return arrayElemenString.indexOf(elemen);
    }

    //Hitung power: level * element advantage + SUM(every skill’s base power *Mastery Level)
    public double calculatePowerPlayer(){
        int idxplayer,idxenemy;
        double hasil = 0;
        double advantage = 0;
        ArrayList<String> elementplayer = player.getElements();
        ArrayList<String> elementenemy = enemy.getElements();
        for (String arg:elementplayer) {
            idxplayer = getIndexElement(arg);
            for (String arg2:elementenemy) {
                idxenemy = getIndexElement(arg2);
                if (matrixAdvantage[idxplayer][idxenemy]>advantage) {
                    advantage = matrixAdvantage[idxplayer][idxenemy];
                }
            }
        }

        ArrayList<Skill> playerskill = player.getEngimonSkill();
        int jumlah = 0;
        for (Skill argskill:playerskill) {
            jumlah += argskill.getBasePower()*argskill.getMasteryLevel();
        }
        hasil = (player.getLevel() * advantage) + jumlah;

        //debug
//        System.out.println(player.getLevel() * advantage);
//        System.out.println(jumlah);

        return hasil;
    }

    //Hitung power: level * element advantage + SUM(every skill’s base power *Mastery Level)
    public double calculatePowerEnemy(){
        int idxplayer,idxenemy;
        double hasil = 0;
        double advantage = 0;
        ArrayList<String> elementplayer = player.getElements();
        ArrayList<String> elementenemy = enemy.getElements();
        for (String arg:elementenemy) {
            idxenemy = getIndexElement(arg);
            for (String arg2:elementplayer) {
                idxplayer = getIndexElement(arg2);
                if (matrixAdvantage[idxenemy][idxplayer]>advantage) {
                    advantage = matrixAdvantage[idxenemy][idxplayer];
                }
            }
        }

        ArrayList<Skill> enemyskill = enemy.getEngimonSkill();
        int jumlah = 0;
        for (Skill argskill:enemyskill) {
            jumlah += argskill.getBasePower()*argskill.getMasteryLevel();
        }
        hasil = (enemy.getLevel() * advantage) + jumlah;

        //debug
//        System.out.println(enemy.getLevel() * advantage);
//        System.out.println(jumlah);

        return hasil;
    }
}

package Characters;

import Logic.GameLogic;

import java.util.Scanner;

public class Enemy extends Character {
    private Scanner scan;
    private boolean isDead;
    public Enemy() {
        super("Chel", 1);
        isDead = false;
        scan = new Scanner(System.in);
    }

    public boolean getIsDead() {
        return isDead;
    }

    public int getHP() {
        return healthPoints;
    }
    public void battle(Pudge pudge, Enemy enemy) {
        boolean pass = false;
        for (boolean fight = true; (enemy.getHP() > 0 && pudge.getHP() > 0) && fight == true; ) {
            System.out.println("You can: " +
                    "\n1. Attack" +
                    "\n2. Escape");
            try {
                switch (scan.nextInt()) {
                    case 1:
                        enemy.setHP(enemy.getHP() - pudge.baseDamage);
                        System.out.println("You dealt " + pudge.baseDamage + " damage." +
                                "\nNow enemy has " + enemy.getHP() + " health points." +
                                "\n It's enemy turn");
                        pudge.setHP(pudge.getHP() - enemy.baseDamage);
                        System.out.println("Enemy dealt " + enemy.baseDamage + " damage." +
                                "\nNow you have " + pudge.getHP() + " health points." +
                                "\nNow it's your turn.");
                        break;
                    case 2:
                        System.out.println("You have escaped");
                        fight = false;
                    default:
                        break;
                }
                pass = true;
            } catch (Exception ex) {
                System.out.println("Input 1 or 2");
            }
        }
        if (enemy.getHP() <= 0) {
            pudge.setKillCounter(pudge.getKillCounter() + 1);
            System.out.println("You killed " + pudge.getKillCounter() + " enemies");
            pudge.levelUP();
            System.out.println("You got 1 level!" +
                    "\nNow your level is: " + pudge.getLevel());
            enemy.setLevel(enemy.getLevel() + 1);
            enemy.setHP(230 + enemy.level * 10);
            enemy.isDead = true;
        }
        if (pudge.getHP() <= 0) {
            System.out.println("You was killed by an enemy, game is over.");
            GameLogic.gameEnd(pudge);
        }
    }
}

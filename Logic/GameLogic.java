package Logic;

import Actions.Movement;
import Game_World.*;
import Objects.*;
import Characters.*;
import java.util.Scanner;

public class GameLogic {
    private static final Scanner scan = new Scanner(System.in);
    public static void Logic(Map map, Pudge pudge, Coordinates coordinates, Enemy enemy) {
        System.out.println("Where do you want to go?" +
                "\nW is North" +
                "\nA is West" +
                "\nS is South" +
                "\nD is East");
        Coordinates nextCoordinates = Movement.playerMove(scan.next().charAt(0), coordinates);
        if (map.getValue(nextCoordinates) == Map.Map_code.EMPTY_SPACE) {
            map.setValue(coordinates, Map.Map_code.EMPTY_SPACE);
            coordinates.setY(nextCoordinates.getY());
            coordinates.setX(nextCoordinates.getX());
            map.setValue(coordinates, Map.Map_code.PLAYER);
        } else {
            switch (map.getValue(nextCoordinates)) {
                case TREE:
                    System.out.println("You cut a tree and got 1 wood!");
                    pudge.setWood(pudge.getWood() + Tree.cutTree());
                    map.clearObject(nextCoordinates);
                    break;
                case TOWN:
                    System.out.println("You came into a town");
                    Town.townOptions(pudge);
                    break;
                case CHEST:
                    System.out.println("You found a chest!");
                    Chest.randomContent(pudge);
                    map.clearObject(nextCoordinates);
                    break;
                case RIVER:
                    System.out.println("You saw a river");
                    River.choice(pudge, map, nextCoordinates);
                    break;
                case NPC:
                    System.out.println("You have met an NPC");
                    NPC.talk(pudge);
                    break;
                case ENEMY:
                    System.out.println("You have met an Enemy");
                    enemy.battle(pudge, enemy);
                    if(enemy.getIsDead() == true)
                        map.clearObject(nextCoordinates);
                    break;
            }
            System.out.print("Press any key to continue: ");
            scan.next().charAt(0);
        }
    }
    public static boolean gameEnd(Pudge pudge) {
        if (pudge.getHP() <= 0) {
            System.out.println("You lost!");
            return true;
        }
        if (pudge.getKillCounter() >= 2) {
            System.out.println("You won!");
            return true;
        }
        return false;
    }
}

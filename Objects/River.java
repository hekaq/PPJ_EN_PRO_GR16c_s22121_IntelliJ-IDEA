package Objects;

import Characters.Pudge;
import java.util.Scanner;

import Game_World.Map;
import Game_World.Coordinates;

public class River {
    private static final Scanner scan = new Scanner(System.in);

    public static void choice(Pudge pudge, Map map, Coordinates coordinates) {

        if (pudge.getWood() > 0) {
            boolean pass = false;
            System.out.print("You have " + pudge.getWood() + " wood, do you want to build a bridge? (y/n): ");
            while (pass == false)
            try {
                if (scan.next().charAt(0) == 'y') {
                    System.out.println("You built a bridge!");
                    map.setValue(coordinates, Map.Map_code.EMPTY_SPACE);
                    pudge.setWood(pudge.getWood() - 1);
                    pass = true;
                }
            } catch (Exception ex) {
                System.out.println("Input y or n");
            }
        } else
            System.out.println("You have not enough wood to build a bridge");
    }
}


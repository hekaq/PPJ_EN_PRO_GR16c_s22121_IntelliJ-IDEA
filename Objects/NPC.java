package Objects;

import java.util.Scanner;
import Characters.Pudge;

public class NPC {
    private static final Scanner scan = new Scanner(System.in);

    public static void talk(Pudge pudge) {
        boolean pass = false;
        System.out.println("You met a NPC" +
                "\nChoose one option:" +
                "\n1. Talk" +
                "\n2. Take a quest" +
                "\n3. Leave.");
        try {
            switch (scan.nextInt()) {
                case 1:
                    switch ((int) (Math.random() * 4)) {
                        case 0:
                            System.out.println("You need something?");
                            break;
                        case 1:
                            System.out.println("Tomorrow is another day.");
                            break;
                        case 2:
                            System.out.println("What can I do for you?");
                            break;
                        case 3:
                            System.out.println("Speak quickly!");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("I need 1 wood, can you bring it to me?" +
                            "\n1. Y" +
                            "\n2. N");
                    switch (scan.nextInt()) {
                        case 1:
                            if (pudge.getWood() > 0) {
                                pudge.setWood(pudge.getWood() - 1);
                                pudge.setHP(pudge.getHP() + 50);
                                System.out.println("Quest is completed! You got 50 health points! Now you have: " + pudge.getHP() + " health points");
                            } else {
                                System.out.println("You have only " + pudge.getWood() + " wood.");
                            }
                            break;
                        default:
                            System.out.println("You refused");
                            break;
                    }
                default:
                    System.out.println("You left NPC");
                    break;
            }
            pass = true;
        } catch (Exception ex) {
            System.out.println("Input 1 or 2");
        }
    }
}

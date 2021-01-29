package Objects;

import Characters.Pudge;
import java.util.Scanner;

public class Town {
    private static final Scanner scan = new Scanner(System.in);
    public static void townOptions(Pudge pudge) {
        boolean pass = false;
        System.out.print("In the town you can:" +
                "\n1. Rest" +
                "\n2. Quit" +
                "\nInput your choice: ");
        try {
            switch (scan.nextInt()) {
                case 1:
                    pudge.restoreHP(pudge);
                    System.out.println("Your health points were restored");
                    break;
                default:
                    System.out.println("You left the town");
                    break;
            }
            pass = true;
        } catch (Exception ex) {
            System.out.println("Input 1 or 2.");
        }
    }
}


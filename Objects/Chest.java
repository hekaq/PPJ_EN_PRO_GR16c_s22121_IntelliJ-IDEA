package Objects;

import Characters.Pudge;

public class Chest {
    public static void randomContent(Pudge pudge) {
        switch ((int) (Math.random() * 4)) {
            case 0:
                System.out.println("You found health potion!");
                pudge.setHP(pudge.getHP() + pudge.getHP() / 4);
                break;
            case 1:
                System.out.println("You found 1 wood!");
                pudge.setWood(pudge.getWood() + 1);
                break;
            case 2:
                System.out.println("You found some experience points!");
                pudge.levelUP();
                break;
            case 3:
            System.out.println("It was empty!");
                break;
        }

    }
}

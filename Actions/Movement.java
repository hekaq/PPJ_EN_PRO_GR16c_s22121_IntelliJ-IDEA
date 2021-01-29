package Actions;

import Game_World.Coordinates;

public class Movement {
    public static Coordinates playerMove(char key, Coordinates coordinates) {
        Coordinates coordinatesToReturn = new Coordinates(coordinates.getX(), coordinates.getY());
        switch (key) {
            case 'w':
            case 'W': coordinatesToReturn.setY(coordinatesToReturn.getY() - 1); break;
            case 'a':
            case 'A': coordinatesToReturn.setX(coordinatesToReturn.getX() - 1); break;
            case 's':
            case 'S': coordinatesToReturn.setY(coordinatesToReturn.getY() + 1); break;
            case 'd':
            case 'D': coordinatesToReturn.setX(coordinatesToReturn.getX() + 1); break;
            default: break;

        }
        return coordinatesToReturn;
    }
}

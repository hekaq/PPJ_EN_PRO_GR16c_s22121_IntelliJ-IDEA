package Game_World;

import Actions.Movement;

public class Map {

    public static final int vision = 3;
    public static int map_size = 100;

    Map_code[][] map;

    public static enum Map_code {
        EMPTY_SPACE, // ' '
        PLAYER, // '🐲'
        CHEST, // '☐'
        TOWN, // 'T'
        RIVER, // '💧'
        ENEMY, // '☠'
        NPC, // '👀'
        TREE, // '🌳'
        BRIDGE // '='

    }

    public Map() {
        map = new Map_code[map_size][map_size];

        // Creating the centre of the map
        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                map[i][j] = Map_code.EMPTY_SPACE;
            }
        }
        for (int i = 0; i < 5; i++) {
            Map_code element = Map_code.EMPTY_SPACE;
            switch (i) {
                case 0:
                    element = Map_code.CHEST;
                    break;
                case 1:
                    element = Map_code.TOWN;
                    break;
                case 2:
                    element = Map_code.ENEMY;
                    break;
                case 3:
                    element = Map_code.NPC;
                    break;
                case 4:
                    element = Map_code.TREE;
                    break;
            }
            for (int j = 0; j < map_size; j++) {
                Coordinates c1 = new Coordinates((int) (Math.random() * (map_size - (vision * 2))) + vision, (int) (Math.random() * (map_size - vision * 2)) + vision);
                if (map[c1.getY()][c1.getX()] == Map_code.EMPTY_SPACE) {
                    map[c1.getY()][c1.getX()] = element;
                }
            }
        }
        for (int i = 0; i < 5; i++) {

            Coordinates riverCoordinates = new Coordinates((int) (Math.random() * (map_size - (vision * 2))) + vision, (int) (Math.random() * (map_size - vision * 2)) + vision);
            for (int j = 0; j < 20; j++) {
                Coordinates copyCoordinates = new Coordinates(riverCoordinates.getX(), riverCoordinates.getY());

                setValue(riverCoordinates, Map_code.RIVER);

                do {
                    riverCoordinates = copyCoordinates;
                    switch ((int) (Math.random() * 4)) {
                        case 0:
                            riverCoordinates.setY(riverCoordinates.getY() + 1);
                            break;
                        case 1:
                            riverCoordinates.setY(riverCoordinates.getY() - 1);
                            break;
                        case 2:
                            riverCoordinates.setX(riverCoordinates.getX() + 1);
                            break;
                        case 3:
                            riverCoordinates.setX(riverCoordinates.getX() - 1);
                            break;
                    }
                } while (map[riverCoordinates.getY()][riverCoordinates.getX()] != Map_code.EMPTY_SPACE);
            }
        }
        // Creating corners of the map
        for (int i = vision; i < map_size - vision; i++) {
            // left wall
            map[i][vision] = Map_code.TOWN;
            // right wall
            map[i][map_size - vision] = Map_code.TOWN;
            // top wall
            map[vision][i] = Map_code.TOWN;
            // bottom wall
            map[map_size - vision][i] = Map_code.TOWN;
        }
    }

    public void map_print(Coordinates coordinates) {
        // top vision corner
        for (int i = 0; i < vision * 2 + 3; i++) {
            System.out.print('*');
        }
        // space in order to start a new line
        System.out.println();
        for (int i = coordinates.getY() - vision; i < coordinates.getY() + vision + 1; i++) {
            // left vision corner
            System.out.print('*');
            // map elements
            for (int j = coordinates.getX() - vision; j < coordinates.getX() + vision + 1; j++) {
                System.out.print(conversionFromEnumToSymbol(map[i][j]));
            }
            // right vision corner
            System.out.println('*');
        }
        // bottom vision corner
        for (int i = 0; i < vision * 2 + 3; i++) {
            System.out.print('*');
        }
        System.out.println();
    }

    private String conversionFromEnumToSymbol(Map_code toConvert) {
        switch (toConvert) {
            case EMPTY_SPACE:
                return " ";
            case PLAYER:
                return "\uD83D\uDC32";
            case CHEST:
                return "☐";
            case TOWN:
                return "T";
            case RIVER:
                return "-";
            case ENEMY:
                return "☠";
            case NPC:
                return "👀";
            case TREE:
                return "🌳";
            case BRIDGE:
                return "=";
            default:
                return "e";
        }
    }

    public void setValue(Coordinates coordinates, Map_code value) {
        map[coordinates.getY()][coordinates.getX()] = value;
    }

    public Map_code getValue(Coordinates coordinates) {
        return map[coordinates.getY()][coordinates.getX()];
    }

    public void clearObject(Coordinates coordinates) {
        map[coordinates.getY()][coordinates.getX()] = Map_code.EMPTY_SPACE;
    }
}


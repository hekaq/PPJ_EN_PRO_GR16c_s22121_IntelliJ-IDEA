import Characters.Enemy;
import Characters.Pudge;
import Logic.GameLogic;
import Game_World.*;

public class Main{
    public static void main (String [] args) {
        Pudge pudge = new Pudge();
        Enemy enemy = new Enemy();
        Coordinates coordinates = new Coordinates(Map.map_size / 2 - 1, Map.map_size / 2 - 1);
        Map map = new Map();

        while (GameLogic.gameEnd(pudge) == false ) {
            map.setValue(coordinates, Map.Map_code.PLAYER);
            map.map_print(coordinates);
            GameLogic.Logic(map, pudge, coordinates, enemy);
            ClearScreen.cls();
        }
    }
}

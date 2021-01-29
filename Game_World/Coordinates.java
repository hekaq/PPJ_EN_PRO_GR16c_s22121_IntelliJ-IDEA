package Game_World;

import Game_World.Map;

public class Coordinates {
    private int x, y;
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (!(x > Map.map_size - Map.vision || x < Map.vision))
        this.x = x;
    }
    public void setY(int y) {
        if (!(y > Map.map_size - Map.vision || y < Map.vision))
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

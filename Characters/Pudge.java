package Characters;

public class Pudge extends Character{
    private int wood;
    private int killCounter;
    private int maxHP;

    public Pudge() {
        super("Pudge");
        maxHP = 400;
        healthPoints = 400;
        baseDamage = 60;
        wood = 1;

    }

    public void setWood(int wood) {
        this.wood = wood;
    }
    public int getHP() {
        return healthPoints;
    }

    public int getWood() {
        return wood;
    }

    public int getKillCounter() {
        return killCounter;
    }

    public void setKillCounter(int killCounter) {
        this.killCounter = killCounter;
    }
    public void setHP(int HP) {
        if (healthPoints > maxHP)
            super.setHP(maxHP);
        else super.setHP(HP);
    }

    public int getMaxHP() {
        return maxHP;
    }
    public void levelUP() {
        level++;
        maxHP += 50;
        baseDamage += 10;
    }
}

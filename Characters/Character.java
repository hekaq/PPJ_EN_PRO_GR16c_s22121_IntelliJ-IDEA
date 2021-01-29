package Characters;

public class Character {
    private String name;

    protected int healthPoints, baseDamage, level;

    Character(){
        name = "";
        level = 1;
        healthPoints = 230;
        baseDamage = 40;
    }
    Character(String name) {
        this();
        this.name = name;
    }
    Character(String name, int level){
        this(name);
        this.level = level;
        healthPoints += level * 10;
        baseDamage += level * 2;
    }

    public int getLevel() {
        return level;
    }
    public void restoreHP(Pudge pudge) {
        healthPoints = pudge.getMaxHP();
    }

    public void setHP(int HP) {
        this.healthPoints = HP;
    }
    public void setLevel(int level) {
        this.level = level;
    }
}


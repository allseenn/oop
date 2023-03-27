package org.example.units;

public abstract class BaseHero {
    float hp,maxHp;
    String name;
    int x, y;
    int atk;
    int def;
    int[] damage;

    public BaseHero(float hp, String name, int x, int y, int atk, int def, int[] damage) {
        this.hp = hp;
        this.maxHp = hp;
        this.name = name;
        this.x = x;
        this.y = y;
        this.atk = atk;
        this.def = def;
        this.damage = damage;
    }

    protected int getInt(){
        return 1;
    }


}

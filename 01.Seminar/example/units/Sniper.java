package org.example.units;

import java.util.Arrays;

public class Sniper extends BaseHero {
    int arrows;
    int accuracy;

    public Sniper(String name) {
        super(7, name, 1, 6, 12, 2, new int[]{6, 12});
        arrows = 10;
        accuracy = 70;
        super.getInt();
    }
}

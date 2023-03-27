package org.example;

import org.example.units.BaseHero;
import org.example.units.Sniper;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<BaseHero> hero = new ArrayList<>();
        hero.add(new Sniper("Иван"));
        hero.add(new Sniper("Лёха"));
        hero.add(new Sniper("Елизавет"));

        hero.forEach(n -> System.out.println(n));

    }
}
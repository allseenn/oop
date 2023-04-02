// Злой Мясник - расширяет абстрактный класс Солдат
package ms.aoe.units;

import ms.aoe.abstr.Soldier;

public class Butcher extends Soldier {

    public Butcher(boolean team, int id, String name, int x, int y) {
        super(team, id, "Мясник", name, x, y);
    }

}


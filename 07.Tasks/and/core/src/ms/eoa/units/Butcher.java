// Злой Мясник - расширяет абстрактный класс Солдат
package ms.eoa.units;

import ms.eoa.abstr.Soldier;

public class Butcher extends Soldier {

    public Butcher(boolean team, int priority, String name, int x, int y) {
        super(team, priority, ButcherIcon, ButcherRank, name, x, y);
    }

}


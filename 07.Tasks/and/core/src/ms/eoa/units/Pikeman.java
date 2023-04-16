// Добрый Копейщик - расширяет абстрактный класс Солдат
package ms.eoa.units;

import ms.eoa.abstr.Soldier;

public class Pikeman extends Soldier {

    public Pikeman(boolean team, int priority, String name, int x, int y) {
        super(team, priority, PikemanIcon, PikemanRank, name, x, y);
    }

}


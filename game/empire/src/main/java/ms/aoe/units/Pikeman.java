// Добрый Копейщик - расширяет абстрактный класс Солдат
package ms.aoe.units;

import ms.aoe.abstr.Soldier;

public class Pikeman extends Soldier {

    public Pikeman(boolean team, int id, String name, int x, int y) {
        super(team, id, PikemanRank, name, x, y);
    }

}


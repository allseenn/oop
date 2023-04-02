// Добрый Арбалетчик - расширяет абстрактный класс Стрелок
package ms.aoe.units;

import ms.aoe.abstr.Bower;

public class Crossbow extends Bower {

    public Crossbow(boolean team, int id, String name, int x, int y) {
        super(team, id, "Стрелок", name, x, y);
    }

}

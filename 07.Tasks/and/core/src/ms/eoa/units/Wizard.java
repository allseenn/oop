// Добрый Волшебник - расширяет абстрактный класс Волшебник
package ms.eoa.units;

import ms.eoa.abstr.Magican;

public class Wizard extends Magican {

    public Wizard(boolean team, int priority, String name, int x, int y) {
        super(team, priority, WizardIcon, WizardRank, name, x, y);
    }
}

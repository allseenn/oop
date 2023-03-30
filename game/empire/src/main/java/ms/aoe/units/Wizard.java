// Добрый Волшебник - расширяет абстрактный класс Волшебник
package ms.aoe.units;
public class Wizard extends AbstrMagic{

    public Wizard(String name, int x, int y) {
        super(name, x, y, 50, 50, 100);
    }
}

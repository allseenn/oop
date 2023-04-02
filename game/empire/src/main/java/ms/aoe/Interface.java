// Основной интерфейс игры
package ms.aoe;
import ms.aoe.abstr.Actor;
import java.util.LinkedList;
public interface Interface{
    void step(LinkedList<Actor> units);
    String toString();

    // ЛУЧНИКИ
    String BowmanRank = "Снайпер";
    String CrossbowRank = "Стрелок";
    int BowerAmmo = 10;
    int BowerArmor = 45;
    int BowerForce = 55;
    int BowerAccuracy = 75;
    // СОЛДАТЫ
    String ButcherRank = "Мясник";
    String PikemanRank = "Копейщик";
    int SoldierAmmo = 999;
    int SoldierArmor = 100;
    int SoldierForce = 100;
    // Оруженосцы
    String PunkRank = "Шестерка";
    String SquireRank = "Эсквайр";
    int ServantAmmo = 10;
    int ServantArmor = 0;
    int ServantForce = 0;
    // Маги
    String WitchRank = "Колдун";
    String WizarkRank = "Волшебник";
    int MagicanAmmo = 999;
    int MagicanArmor = 25;
    int MagicanForce = 25;

}

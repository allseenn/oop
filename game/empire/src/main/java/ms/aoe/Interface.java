// Основной интерфейс игры
package ms.aoe;
import ms.aoe.abstr.Actor;
import java.util.LinkedList;
public interface Interface{
    // функция хода (ряда действий)
    void step(LinkedList<Actor> units);
    // функция вывода полей в строку
    String toString();
    // Функция поиска врага
    int findEnemy(LinkedList<Actor> units);
    // Функция помощи другу
    int findFriend(LinkedList<Actor> units);
    // Функция расчета ущерба наносимого Лучниками и Пехотой
    int[] damage(int myForce, int myArmor, int enemyArmor, int enemyHp);
    // ЛУЧНИКИ
    String BowmanRank = "Снайпер";
    String CrossbowRank = "Стрелок";
    int BowerAmmo = 10;
    int BowerArmor = 45;
    int BowerForce = 55;
    // СОЛДАТЫ
    String ButcherRank = "Мясник";
    String PikemanRank = "Копейщик";
    int SoldierAmmo = 999;
    int SoldierArmor = 100;
    int SoldierForce = 100;
    // Оруженосцы
    String PunkRank = "Шестерка";
    String SquireRank = "Эсквайр";
    int ServantAmmo = 1;
    int ServantArmor = 0;
    int ServantForce = 0;
    // Маги
    String WitchRank = "Колдун";
    String WizarkRank = "Волшебник";
    int MagicanAmmo = 999;
    int MagicanArmor = 25;
    int MagicanForce = 25;

}

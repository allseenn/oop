// Основной интерфейс игры
package ms.aoe;
import ms.aoe.abstr.Actor;
import java.util.LinkedList;
public interface Interface{
    // Размер команды
    int teamSize = 10;
    // функция хода (ряда действий)
    void step(LinkedList<Actor> units);
    // функция вывода полей в строку
    String toString();
    // Функция вывода подробной информации
    String getInfo();
    // Функция поиска врага
    int findEnemy(LinkedList<Actor> units);
    // Функция помощи другу
    int findFriend(LinkedList<Actor> units);
    // Функция расчета ущерба наносимого Лучниками и Пехотой
    int[] damage(int myForce, int myArmor, int enemyArmor, int enemyHp);
    // ЛУЧНИКИ
    String BowmanRank = "Снайпер";
    String CrossbowRank = "Стрелок";
    String BowmanIcon = "♛";
    String CrossbowIcon = "♕";
    int BowerAmmo = 10;
    int BowerArmor = 45;
    int BowerForce = 55;
    // СОЛДАТЫ
    String ButcherRank = "Мясник";
    String PikemanRank = "Копейщик";
    String ButcherIcon = "♜";
    String PikemanIcon = "♖";
    int SoldierAmmo = 999;
    int SoldierArmor = 200;
    int SoldierForce = 500;
    // Оруженосцы
    String PunkRank = "Шестерка";
    String SquireRank = "Эсквайр";
    String PunkIcon = "♝";
    String SquireIcon = "♗";
    int ServantAmmo = 1;
    int ServantArmor = 0;
    int ServantForce = 0;
    // Маги
    String WitchRank = "Колдун";
    String WizardRank = "Маг";
    String WitchIcon = "♚";
    String WizardIcon = "♔";
    int MagicanAmmo = 999;
    int MagicanArmor = 25;
    int MagicanForce = 25;

}

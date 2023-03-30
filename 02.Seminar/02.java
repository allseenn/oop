
   ArrayList<BaseHero> heroList = new ArrayList<>();
   Random random = new Random();
       for (int i = 0; i < 10; i++) {
   switch (random.nextInt(7)) {
   case 0 -> heroList.add(new Spearman(getName(), 1, 5));
   case 1 -> heroList.add(new Sniper(getName(), 2, 8));
   case 2 -> heroList.add(new Crossbowman(getName(), 3, 5));
   case 3 -> heroList.add(new Peasant(getName(), 1, 6));
   case 4 -> heroList.add(new Monk(getName(), 6, 5));
   case 5 -> heroList.add(new Witch(getName(), 7, 5));
default -> heroList.add(new Thief(getName(), 2, 10));
   }
   }
   heroList.forEach(n-> System.out.println(n.getInfo() +" "+ n.getName()));

   }
@Override
public void step() {

}

   @Override
   public String getInfo() {
       return this.getClass().getSimpleName();
   }
}
public interface GameInterface {
   void step();
   String getInfo();
}
public enum Names {
   Bond, Nick, Max, John, Pete, Ann, Mary, Bruce, Iov, Luka, Thomas;
}

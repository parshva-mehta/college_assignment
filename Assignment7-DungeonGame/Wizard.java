public class Wizard{

    public static int health = (int) Math.random() * 12 + 12;
    public static int damage = (int) Math.random() * 4 + 4;

    public static void attack(Hero hero){
        System.out.println("The wizard attacks back");
        Hero.health -= damage;
        Hero.printResultW();
    }
    
}
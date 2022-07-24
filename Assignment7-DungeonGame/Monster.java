public class Monster{

    public static int health = (int) Math.random() * 5 + 5;
    public static int damage = (int) Math.random() * 3 + 1;

    public static void attack(Hero hero){
        System.out.println("The monster attacks back");
        Hero.health -= damage;
        Hero.printResult();
    }

    public static void regenerate(){
        health = (int) Math.random() * 5 + 5;
        damage = (int) Math.random() * 3 + 1;
    }
    
}
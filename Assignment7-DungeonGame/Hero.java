import java.util.ArrayList;
import java.util.Scanner;

public class Hero {

    static int health = (int) (Math.random() * 20) + 10;
    static int damage = (int) (Math.random() * 5) + 1; 
    static int dexterity = (int) (Math.random() * 5) + 3;
    static ArrayList<String> inventory = new ArrayList<String>();
    String weapon = "None"; 
    static int reducedDmg = damage/2;
    static double dodgeProb = Math.random();
    static int x;
    static int y;

    Scanner in = new Scanner(System.in);

    public static void attack(Monster monster, int choice){
        if(choice == 1){
            System.out.println("Hero Move: ");
            System.out.println("The hero attacks, but is met by a tough shield");
            printResult();

            System.out.println("Enemy Move: ");
            System.out.println("The monster defends, but the attack goes through");
            Monster.health -= reducedDmg;
            printResult();
        }
        else{
            System.out.println("The hero attacks");
            Monster.health -= damage;
        }
    
    }
    public static void attackWizard(Wizard monster, int choice){
        if(choice == 1){
            System.out.println("Hero Move: ");
            System.out.println("The hero attacks, but is met by a tough shield");
            printResultW();

            System.out.println("Enemy Move: ");
            System.out.println("The wizard defends, but the attack goes through");
            Wizard.health -= reducedDmg;
            printResultW();
        }
        else{
            System.out.println("The hero attacks");
            Wizard.health -= damage;
        }
    
    }  
    public static void dodge(Monster monster){
        if(dodgeProb <= (dexterity/10)){
            System.out.println("Hero Move: ");
            System.out.println("The hero dodges");
            x = 1;
            printResult();
        }
        else{
            System.out.println("Hero Move: ");
            System.out.println("The hero fails to dodge and takes damage");
            x = 2;
            printResult();
        }
    }
    public static void dodgeWizard(Wizard monster){
        if(dodgeProb <= (dexterity/10)){
            System.out.println("Hero Move: ");
            System.out.println("The hero dodges");
            x = 1;
            printResultW();
        }
        else{
            System.out.println("Hero Move: ");
            System.out.println("The hero fails to dodge and takes damage");
            x = 2;
            printResultW();
        }
    }
    public static void run(Monster monster){
        if(dodgeProb <= (dexterity/10)){
            System.out.println("Hero Move: ");
            System.out.println("The hero runs away");
            y = 1;
            int newLoc = (int) Math.random() * 3 + 1;
            if(newLoc == 1){
                Dungeon.heroPosX++;
            }
            if(newLoc == 2){
                Dungeon.heroPosY++;
            }
            if(newLoc == 3){
                Dungeon.heroPosX--;
            }
            if(newLoc == 4){
                Dungeon.heroPosY++;
            }
        }
        else{
            System.out.println("Hero Move: ");
            System.out.println("The hero could not run away from the battle");
            y = 2;
            printResult();
        }
    }
    public static void runWizard(Wizard monster){
        if(dodgeProb <= (dexterity/10)){
            System.out.println("Hero Move: ");
            System.out.println("The hero runs away");
            y = 1;
            int newLoc = (int) Math.random() * 3 + 1;
            if(newLoc == 1){
                Dungeon.heroPosX++;
            }
            if(newLoc == 2){
                Dungeon.heroPosY++;
            }
            if(newLoc == 3){
                Dungeon.heroPosX--;
            }
            if(newLoc == 4){
                Dungeon.heroPosY++;
            }
        }
        else{
            System.out.println("Hero Move: ");
            System.out.println("The hero could not run away from the battle");
            y = 2;
            printResultW();
        }
    }
    public String move(String direction){
            return direction;
    }
    
    public static String getStats(){
        String damageStat = "Damage: " + damage;
        String dexStat = "Dexterity: " + dexterity;
        String healthStat = "Health: " + health;
        
        return "\n" + healthStat + "\n" + damageStat + "\n" + dexStat; 
    }

    public static void printResult(){

        if(Monster.health > 0 && Hero.health > 0){
            System.out.println("-------------------------------");
            System.out.println("Monster HP: " + Monster.health);
            System.out.println("Hero HP: " + Hero.health);
            System.out.println("-------------------------------");
        }

        else{
            System.out.println("-------------------------------");
            System.out.println("The battle has concluded");
            System.out.println("-------------------------------");

            if(Monster.health <= 0){
                System.out.println("The hero has triumphed");
            }
            else{
                System.out.println("The monster claims the soul of the fallen hero");
                System.exit(0);
            }
        }
    }
    public static void printResultW(){

        if(Wizard.health > 0 && Hero.health > 0){
            System.out.println("-------------------------------");
            System.out.println("Wizard HP: " + Wizard.health);
            System.out.println("Hero HP: " + Hero.health);
            System.out.println("-------------------------------");
        }

        else{
            System.out.println("-------------------------------");
            System.out.println("The battle has concluded");
            System.out.println("-------------------------------");

            if(Wizard.health <= 0){
                System.out.println("The hero has triumphed");
            }
            else{
                System.out.println("The wizard claims the soul of the fallen hero");
                System.exit(0);
            }
        }
    }
}
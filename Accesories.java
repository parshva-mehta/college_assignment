import java.util.Random;

public class Accesories{
    static Random rand = new Random();
    static String[] itemList = {"Key", "Potion", "Ring", "Shield"};
    static String item1 = itemList[rand.nextInt(itemList.length)];
    static String item2 = itemList[rand.nextInt(itemList.length)];
    static String item3 = itemList[rand.nextInt(itemList.length)];
    static String item4 = itemList[rand.nextInt(itemList.length)];

    public static void ensureNonDouble(String item1, String item2, String item3, String item4){
        while(item1 != item2 && item1 != item3 && item1 != item4 && item2 != item3 && item2 != item4 && item3 != item4){
            item1 = itemList[rand.nextInt(itemList.length)];
            item2 = itemList[rand.nextInt(itemList.length)];
            item3 = itemList[rand.nextInt(itemList.length)];
            item4 = itemList[rand.nextInt(itemList.length)];
        }
    }

    public static String getItem(int room){
        ensureNonDouble(item1, item2, item3, item4);

        if(room == 1){
            return item1;
        }
        if(room == 2){
            return item2;
        }
        if(room == 3){
            return item3;
        }
        if(room == 4){
            return item4;
        }
        else{
            return "Invalid";
        }
    }

    public static void useItem(String item, Hero hero, int turn){
        if(item.equalsIgnoreCase("Key")){}
        if(item.equalsIgnoreCase("Potion")){
            if(Hero.inventory.contains("Potion")){
                if(turn > 0){
                    Hero.health++;
                }
            }
            else{
                System.out.println("You do not have the potion");
            }

        }
        if(item.equalsIgnoreCase("Ring")){
            Hero.dexterity++;
        }
        if(item.equalsIgnoreCase("Shield")){
            Monster.damage--;
        }
        
    }
}
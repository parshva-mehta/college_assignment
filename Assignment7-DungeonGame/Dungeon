import java.util.Scanner;


public class Dungeon{
    public static final int monsterChoice = 0;
    public static int heroPosX = 5;
    public static int heroPosY = 3;
    static String weaponName = null;
    public static String item = "horse";
    static int a11 = 0;
    static int a12 = 0;
    static int a13 = 0;
    static int a10 = 0;
    static int[][] layout ={{0 , 0 , 0 , 0 , 0 , 0 , 0}, 
                            {0 , 0 , 0 , 5 , 0 , 0 , 0},
                            {0 , 0 , 10, 2 ,11 , 0 , 0},
                            {0 , 1 , 2 , 4 , 2 , 1 , 0},
                            {0 , 0 , 12, 2 ,13 , 0 , 0},
                            {0 , 0 , 0 , 6 , 0 , 0 , 0},
                            {0 , 0 , 0 , 0 , 0 , 0 , 0}};

    public static void main(String[] args) {
        Scanner readIn = new Scanner(System.in);
        Hero player = new Hero();
        Monster monster = new Monster();
        boolean game = true;
        
        while(game){
            if(Hero.health >= 0){
                if(nextAction(player, monster) == 7){
                    break;
                }
                nextAction(player, monster);
            }
        }


        readIn.close();
    }
    
    public static int nextAction(Hero player, Monster monster){
        System.out.println("-------------------------------------------------");
        System.out.println("Action: ");
        System.out.println("1) Move to a different room \n2) Check inventory \n3) Check stats \n4) Get item (if present) \n5) Drop item \n6) Quit");
        Scanner read = new Scanner(System.in);
        int playerChoice = read.nextInt();
        
        switch (playerChoice){
            case 1:
                String direction = nextMove();
                room(player, monster, direction); 
                break;
            case 2: 
                System.out.println("Inventory: " + Hero.inventory);
                break;
            case 3:
                System.out.println("Stats: " + Hero.getStats()); //create getstats method
                break;
            case 4:
                if(Hero.inventory.size() < 3){
                    Hero.inventory.add(item);
                }
                else{
                    System.out.println("Inventory is full, drop an item first");
                }

                break;
            case 5: 
                int drop;
                System.out.println("Which item would you like to drop? " + Hero.inventory);
                drop = read.nextInt();
                if(drop == 1){
                    Hero.inventory.remove(0);
                }
                else if(drop == 2){
                    Hero.inventory.remove(1);
                }
                else if(drop == 3){
                    Hero.inventory.remove(2);
                }
                else{
                    System.out.println("Invalid item");
                }
                break;
            case 6:
                System.exit(0);
            default:
                while(playerChoice != 1 && playerChoice != 2 && playerChoice != 3 && playerChoice != 4 && playerChoice != 5 && playerChoice != 6){
                    System.out.println("Invalid choice: Please try again");
                    playerChoice = read.nextInt();
                }
            }
            return playerChoice;
    }
    public static void determineDirection(Hero hero, String dir){
        if(hero.move(dir).equalsIgnoreCase("n")){
            heroPosX--;
        }
        else if(hero.move(dir).equalsIgnoreCase("s")){
            heroPosX++;
        }
        else if(hero.move(dir).equalsIgnoreCase("e")){
            heroPosY++;
        }
        else if(hero.move(dir).equalsIgnoreCase("w")){
            heroPosY--;
        }
        else{
            dir = nextMove();
            determineDirection(hero, dir);
        }
    }

    public static void room(Hero hero, Monster monster, String dir){
        Scanner sc = new Scanner(System.in);
        String direction;
        determineDirection(hero, dir);


        while(layout[heroPosX][heroPosY] == 0){

            if(dir.equalsIgnoreCase("n")){
                heroPosX++;
            }
            if(dir.equalsIgnoreCase("s")){
                heroPosX--;
            }
            if(dir.equalsIgnoreCase("w")){
                heroPosY++;
            }
            if(dir.equalsIgnoreCase("e")){
                heroPosY--;
            }

            System.out.println("You cannot go there, please choose a different direction");
            direction = nextMove();
            determineDirection(hero, direction);
        }

        if(layout[heroPosX][heroPosY] == 1){
            System.out.println("You have encountered a weapon.");
            hero.weapon = weaponChoice(hero);
            System.out.println("You now wield the " + weaponName);

            if(weaponName.equals("Sword")){
                Hero.damage+=3;
            }
            else if(weaponName.equals("Flamethrower")){
                Hero.damage+=10;
                Hero.dexterity+=2;
            }
        }
        else if(layout[heroPosX][heroPosY] == 2){
            if(Monster.health <= 0){
                System.out.println("Here lie the remains of the slain monster");
            }
            else{
                System.out.println("You have encountered a monster.");
            }
            int turn = 0;
            while(Hero.health > 0 && Monster.health > 0){
                System.out.println("Turn: " + turn);
                System.out.println("What would you like to do?\n 1) Fight \n 2) Dodge \n 3) Run");
                int playerChoice = sc.nextInt();
                double monsterAorD = Math.random(); 
                int monsterChoice;

                if(monsterAorD > 0.7){
                    monsterChoice = 1;
                }
                else{
                    monsterChoice = 0;
                }

                if(playerChoice == 1){
                    System.out.println("Hero's move: ");
                    Hero.attack(monster, monsterChoice);
                    if(monsterChoice == 0){
                        System.out.println("Enemy Move: ");
                        Monster.attack(hero);
                    }
                    turn++;
                }
                else if(playerChoice == 2){
                    Hero.dodge(monster);
                    if(Hero.x == 2){
                        System.out.println("Enemy Move: ");
                        Monster.attack(hero);
                    }
                    turn++;
                }
                else if(playerChoice == 3){
                    Hero.dodge(monster);
                    if(Hero.y == 1){
                        break;
                    }
                    else{
                        if(monsterChoice == 0){
                            System.out.println("Enemy Move: ");
                            Monster.attack(hero);
                        }
                        turn++;
                    }
                }
                Accesories.useItem(item, hero, turn);
            }
            Monster.regenerate();
        }
        else if(layout[heroPosX][heroPosY] == 10){
            if(a10 == 0){
                item = Accesories.getItem(4);
                System.out.println("There is a " + item + " in the room. Press 4 to pick it up.");
            }
            else{
                System.out.println("An item used to be here. Press 5 to drop an item from your inventory");
                a10++;
            }
        }
        else if(layout[heroPosX][heroPosY] == 11){
            if(a11 == 0){
                item = Accesories.getItem(1);
                System.out.println("There is a " + item + " in the room. Press 4 to pick it up.");
            }
            else{
                System.out.println("An item used to be here. Press 5 to drop an item from your inventory");
                a11++;
            }
        }
        else if(layout[heroPosX][heroPosY] == 12){
            if(a12 == 0){
                item = Accesories.getItem(2);
                System.out.println("There is a " + item + " in the room. Press 4 to pick it up.");
                a12++;
            }
            else{
                System.out.println("An item used to be here. Press 5 to drop an item from your inventory");
            }
        }
        else if(layout[heroPosX][heroPosY] == 13){
            if(a13 == 0){
                item = Accesories.getItem(3);
                System.out.println("There is a " + item + " in the room. Press 4 to pick it up.");
                a13++;
            }
            else{
                System.out.println("An item used to be here. Press 5 to drop an item from your inventory");
            }
        }
        else if(layout[heroPosX][heroPosY] == 4){
            System.out.println("You have encountered the fountain");
            System.out.println("Do you want to take a sip? ");
            String fountainChoice = sc.nextLine();
            if(fountainChoice.equalsIgnoreCase("Yes")){
                double randChance = Math.random();
                if(randChance <= 0.2){
                    System.out.println("The fountain blesses the hero with more power");
                    Hero.damage+=2;
                }
                else if(randChance <= 0.4 && randChance > 0.2){
                    System.out.println("The fountain blesses the hero with evasiveness");
                    Hero.dexterity++;
                }
                else if(randChance <= 0.6 && randChance > 0.4){
                    System.out.println("The murky water poisons the hero taking away 2 health");
                    Hero.health-=2;
                }
                else{
                    System.out.println("The hero waits yet nothing happens");
                }
            }
        }
        else if(layout[heroPosX][heroPosY] == 5){
            System.out.println("You have encountered the wizard");
            if(Hero.inventory.contains("Key")){
                //battle
                Wizard wizard = new Wizard();
                int turn = 0;
                while(Hero.health > 0 && Wizard.health > 0){
                    System.out.println("Turn: " + turn);
                    System.out.println("What would you like to do?\n 1) Fight \n 2) Dodge \n 3) Run");
                    int playerChoice = sc.nextInt();
                    double monsterAorD = Math.random(); 
                    int wizardChoice;
    
                    if(monsterAorD > 0.7){
                        wizardChoice = 1;
                    }
                    else{
                        wizardChoice = 0;
                    }
    
                    if(playerChoice == 1){
                        System.out.println("Hero's move: ");
                        Hero.attackWizard(wizard, wizardChoice);
                        if(wizardChoice == 0){
                            System.out.println("Enemy Move: ");
                            Wizard.attack(hero);
                        }
                        turn++;
                    }
                    else if(playerChoice == 2){
                        Hero.dodgeWizard(wizard);
                        if(Hero.x == 2){
                            System.out.println("Enemy Move: ");
                            Wizard.attack(hero);
                        }
                        turn++;
                    }
                    else if(playerChoice == 3){
                        Hero.dodgeWizard(wizard);
                        if(Hero.y == 1){
                            break;
                        }
                        else{
                            if(wizardChoice == 0){
                                System.out.println("Enemy Move: ");
                                Wizard.attack(hero);
                            }
                            turn++;
                        }
                    }
                    Accesories.useItem(item, hero, turn);
                }
            }
            else{
                System.out.println("You do not have the key, keep exploring");
            }
        }
        else if(layout[heroPosX][heroPosY]== 6){
            System.out.println("This is where you started, maybe keep a mark to avoid getting lost");
        }
    }
    
    public static String weaponChoice(Hero hero){
        int weaponIndex = (int) (Math.random()*2) + 1;
            if(weaponIndex == 1){
                weaponName = "Sword";
                Hero.damage += 3;
            }
            else{
                weaponName = "Flamethrower";
                Hero.damage += 10;
                Hero.dexterity += 3;
            }
            return weaponName;
    }

    public static String nextMove(){
        Scanner input = new Scanner(System.in);
        System.out.println("Where do you want to go? ");
        String newMove = input.next();
        if(newMove.equalsIgnoreCase("n")){}
        else if(newMove.equalsIgnoreCase("s")){}
        else if(newMove.equalsIgnoreCase("w")){}
        else if(newMove.equalsIgnoreCase("e")){}
        else{
            System.out.println("Incorrect Direction");
            System.out.println("Choose a direction from [n,s,w,e]");
            newMove = input.nextLine();
        }
        return newMove;
    }
}

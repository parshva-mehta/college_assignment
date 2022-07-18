public class MakeChange{
    public static void main(String[] args) {
        int input = Integer.parseInt(args[0]);
        System.out.println(numWays(input) + " Ways:");
        printWays(input);
    }

    public static int numWays(int input){
        int count = 0;     
        for(int quarter = 0; quarter <= input; quarter++){
            for(int dime = 0; dime <= input; dime++){   
                for(int nickel = 0; nickel <= input; nickel++){
                    for(int penny = 0; penny <= input; penny++){
                        if((quarter*25) + (dime*10) + (nickel*5) + (penny*1) == input){
                            count++;
                        }
                    }
                }
            }
        } 
        return count;
    }

    public static void printWays(int input){
        for(int quarter = 0; quarter <= input; quarter++){
            for(int dime = 0; dime <= input; dime++){
                for(int nickel = 0; nickel <= input; nickel++){
                    for(int penny = 0; penny <= input; penny++){
                        if((quarter*25) + (dime*10) + (nickel*5) + (penny*1) == input){
                            System.out.println(quarter + " Quarters, " + dime + " Dimes, " + nickel + " Nickels, " + penny + " Pennies");
                        }
                    }
                }
            }
        } 
    }
}




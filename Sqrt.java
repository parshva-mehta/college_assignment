public class Sqrt{
    public static void main(String[] args){
        double x = Integer.parseInt(args[0]);
        double y = x/2; 
        double newGuess = y;
        
        while(true){
            newGuess = (y+(x/y))/2;
            if(Math.abs(y - newGuess) < 1e-6){
                break;
            }
            else{
                y = newGuess;
            }
        }
        System.out.println(newGuess);
    }
}
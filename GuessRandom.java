import java.util.*;

public class GuessRandom {
    public static void main(String[] args){
        int random_num = (int) Math.random() * 10 + 1;
        Scanner readIn = new Scanner(System.in);
        System.out.println("I'm thinking of a number from 1 to 10. Your guess?");
        int guess = readIn.nextInt();
        readIn.close();
        int diff = Math.abs(random_num - guess);
        System.out.printf("It was %d. You were off by %d", random_num, diff);
    }
}

package Java.CS111;

public class Calculations{
    public static void main(String[] args){

        //gets first 2 arguments
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);

        //add
        int sum = num1 + num2;
        //difference
        int difference = num1 - num2;
        //product
        int product = num1 * num2;
        //quotient
        double quotient = (double) num1/num2;
        //remainder 
        int remainder = num1 % num2;
        //average
        double average = (num1 + num2)/2;

        //output
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient " + quotient);
        System.out.println("Remainder: " + remainder);
        System.out.println("Average: " + average);
    }
}
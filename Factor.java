public class Factor {
    public static void main(String[] args){
        int num = Integer.parseInt(args[0]);
        System.out.print(num + ": ");

        for(int i = 2; i <= num; i++){
            while(num % i == 0){
                System.out.print(i + " ");
                num /= i;
            }
        }
    }
}
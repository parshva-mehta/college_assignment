public class BinToDec{
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);

        int decimal = 0;
        int i = 0;
        while(true){
            if(num == 0){
                break;
            }
            else{
                int temp = num % 10;
                decimal = decimal + temp * (int) Math.pow(2,i);
                num /= 10;
                i++;
            }
        }
        System.out.println(decimal);
    }
}
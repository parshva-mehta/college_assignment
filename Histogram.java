public class Histogram {
    public static void main(String[] args) {
        String input = args[0];
        input = input.toLowerCase();
        int len = input.length();
        char currentLetter;
        int letterIndex = 0;
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";


        int [] result = new int[26]; 
        for(int i = 0; i < len; i++){
            currentLetter = input.charAt(i);
            for(int j = 0; j < ALPHABET.length(); j++){
                if(currentLetter == ALPHABET.charAt(j)){
                    letterIndex = j;
                    result[letterIndex] += 1;
                    break;
                }
            }
        }
        printArray(result);
    }   

    public static void printArray(int[] arr){
        System.out.print("[");
        for(int k = 0; k < arr.length; k++){
            if(k == arr.length-1){
                System.out.print(arr[k]);
            }
            else{
                System.out.print(arr[k] + ",");
            }
            
        }
        System.out.println("]");
    }

}

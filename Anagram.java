public class Anagram{ //change to do histogram of both strings and compare them ! ! !!! 
    public static void main(String[] args) {
        String str1 = args[0];
        String str2 = args[1];
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        System.out.println(checkString(str1, str2));

    }
    
    public static boolean checkString(String string1, String string2){
        int checkletterCount = 0;
        int letterCount = 0;

        if(string1.length() != string2.length()){
            return false;
        }
        
        for(int i = 0; i < string1.length(); i++){
            for(int j = 0; j < string2.length(); j++){
                if(string1.charAt(i) == string2.charAt(j)){
                    letterCount++;
                    break;
                }
            }
        }
        for(int k = 0; k < string2.length(); k++){
            for(int l = 0; l < string1.length(); l++){
                if(string2.charAt(k) == string1.charAt(l)){
                    checkletterCount++;
                    break;
                }
            }
        }
        if(letterCount == string1.length() && letterCount == checkletterCount){
            return true;
        }
        else{
            return false;
        }
    }
}
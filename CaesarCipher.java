import java.util.*;

public class CaesarCipher{
    public static void main(String[] args) {
        Scanner readIn = new Scanner(System.in);
        System.out.println("What's the message? ");
        String message = readIn.nextLine();
        System.out.println("What's the shift? ");
        int shift = readIn.nextInt();
        readIn.close();

        if(shift >= 0){
            System.out.println(shift(message, shift));
        }
        else{
            System.out.println(unshift(message, Math.abs(shift)));
        }
    }
    public static String shift(String message, int key){
        
        String newMessage = "";
        char alphabet;
        for(int i=0; i < message.length();i++) 
        {
            alphabet = message.charAt(i);
            
            if(alphabet >= 'a' && alphabet <= 'z') 
            {
             alphabet = (char) (alphabet + key);
             if(alphabet > 'z') {
                alphabet = (char) (alphabet+'a'-'z'-1);
             }
             newMessage = newMessage + alphabet;
            }
            
            else if(alphabet >= 'A' && alphabet <= 'Z') {
             alphabet = (char) (alphabet + key);    
                
             if(alphabet > 'Z') {
                 alphabet = (char) (alphabet+'A'-'Z'-1);
             }
                newMessage = newMessage + alphabet;
            }
            else {
                newMessage = newMessage + alphabet;   
            }
        }
        return newMessage;
    }
    public static String unshift(String message, int key){
        String newMessage = "";
        for(int i=0; i < message.length();i++)  

        {
            char alphabet = message.charAt(i);
            if(alphabet >= 'a' && alphabet <= 'z')
            {
                alphabet = (char) (alphabet - key);
            
                if(alphabet < 'a') {
                    alphabet = (char) (alphabet-'a'+'z'+1);
                }
                newMessage = newMessage + alphabet;
            }    
            else if(alphabet >= 'A' && alphabet <= 'Z')
            {
                alphabet = (char) (alphabet - key);
                
                if (alphabet < 'A') {
                    alphabet = (char) (alphabet-'A'+'Z'+1);
                }
                newMessage = newMessage + alphabet;            
            }
            else 
            {
                newMessage = newMessage + alphabet;            
            } 
        }
        return newMessage;
    }
}
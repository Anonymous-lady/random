/**
 * practice 
 */
import java.util.Scanner;
import java.util.Random;
public class PasswordEncryptor
{
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter your desired password.");
        String password = kb.next();
        System.out.println();
        if (isPasswordValid(password)){
            String encryption = encryptPassword(password);
            System.out.println("Orginal Password: " + password);
            System.out.println("Encrypted Password: " + encryption);
        }
        else{
            System.out.println("Password is invalid");
        }
    }
    
    public static boolean isPasswordValid(String s){
        boolean valid = true;
        if (s.length() >= 8 && s.length() <= 12){
            for(int i = 0; i < s.length(); i++){
                char j = s.charAt(i);
                if (!(Character.isLetter(j) || Character.isDigit(j))){
                    valid = false;
                }
            }
        }
        else {
            valid = false;
        }
        return valid;
    }
    
    public static String encryptPassword(String s){
        Random rand = new Random();
        int r = rand.nextInt(51) + 350;
        String encrypted = "";
        for(int i = 0; i < s.length(); i++){
            char k = s.charAt(i);
            int numericValue = Character.getNumericValue(k);
            double squared = Math.pow(numericValue, 2);
            //int r = rand.nextInt(51) + 350;
            double newNumber = squared + r;
            newNumber = newNumber % 94;
            newNumber += 33;
            char newLetter = (char)newNumber;
            encrypted += newLetter;
        }
        
        return encrypted;
    }
}

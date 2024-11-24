
import java.util.Random;
import java.util.Scanner;
public class CreatureBattle
{
    public static void main (String[] args){
        int randomNumber; 
        String creature;
        Scanner kb = new Scanner(System.in);
        int userScore = 0, computerScore = 0;
        boolean isValid;
        System.out.println("\nPrepare for battle!\n");
        do{
            //prompt user
            System.out.println("Choose your creature (Dragon,Unicorn, Phoenix):");
            System.out.print("Player: "); 
            creature = kb.next();
            isValid = validateInput(creature);
            while(isValid != true){
            //prompt again incase of invalid input
            System.out.println("\nInvalid choice.Choose your creature (Dragon,Unicorn, Phoenix): ");
            System.out.print("Player: "); 
            creature = kb.next();
            isValid = validateInput(creature);
            }
            //get computer's input from method
            String computer = computerPlays();
            System.out.println("System: "+ computer); 
            //determine who gets a score or if it ends as a tie
            if (creature.equals("Dragon") && computer.equals("Phoenix")){
                userScore ++;
            }
            else if (creature.equals("Phoenix") && computer.equals("Dragon")){
                computerScore++;
            }
            else if(creature.equals("Phoenix") && computer.equals("Unicorn")){
                userScore++;
            }
            else if(creature.equals("Unicorn") && computer.equals("Phoenix")){
                computerScore++;
            }
            else if (creature.equals("Dragon") && computer.equals("Unicorn")){
                computerScore++;
            }
            else if(creature.equals("Unicorn") && computer.equals("Dragon")){
                userScore++;
            }
            else if(creature.equals(computer)){
                System.out.println("Tie.");
            }
            System.out.println("Score: " + userScore + "-" + computerScore);
            System.out.println();
        } 
        //condition stops when user or computer has a 3
        while(userScore < 3 && computerScore < 3 );
        announceOutcome(userScore, computerScore);
    }
    
    //method to confirm user's input
    public static boolean validateInput(String creature){
        boolean valid = true;
        if (creature.equals("Dragon") || creature.equals("Phoenix") || creature.equals("Unicorn")){
            valid = true;
        }
        else{
            valid = false;
        }
        return valid;
    }
    
    //method to get a random input from system
    public static String computerPlays(){
        Random rand = new Random();
        int randomNumber = rand.nextInt(3);
        String creature = " ";
        switch(randomNumber){
            case 0: creature = "Dragon";
                break;
            case 1: creature = "Phoenix";
                break;
            case 2: creature = "Unicorn";
        }
        return creature;
    }
    
    //method announces the final decision of the battle 
    public static void announceOutcome(int userScore, int computerScore){
        if (userScore < computerScore){
            System.out.println("Defeat.");
        }
        else{
            System.out.println("Victory!!!");
        }
    }
}

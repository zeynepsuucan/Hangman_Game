
import java.util.Scanner;

public class HangmanMain {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        Hangman hangman = new Hangman();

        while (hangman.isGameOver() == false) { //while isGameOver is false asks for the player to select a letter.
            System.out.println("Letters used so far: " + hangman.getUsedLetters() + "\n"); // displays the letters that the player has guessed so far.
            System.out.println(hangman.getKnownSoFar() + "\n"); 

            System.out.print("Please make a guess (a capital letter): "); // the alphabet given is in capital letter, so we ask the player to make a guess (a capital letter)
            String letter = in.next();

            if(hangman.getAllLetters().contains(letter)){

                char letterC = letter.charAt(0);

                int quantityOfLetter = hangman.tryThis(letterC);

                if (quantityOfLetter == 0) {
                    System.out.println("Incorrect guess!");
                } 
                
                else {
                    System.out.println("The letter " + letter + " occurs " + quantityOfLetter + " times.");
                }
            } 
            
            else {
                System.out.println("Please enter a capital letter! ");
            }
        }

        if (hangman.isGameOver()==true) {
            if(hangman.hasLost()== true){
                System.out.println("You lost!");
                System.out.println("The secret word was " + hangman.getSecretWord());
            }

            else{
                System.out.println("You won!");
                System.out.println("The secret word was " + hangman.getSecretWord());
            }
            
        } 
    
        in.close();
    }
}

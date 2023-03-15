import java.util.Random;

public class Hangman {

    //variables
    private StringBuffer secretWord;
    private StringBuffer allLetters;
    private StringBuffer knownSoFar;
    private StringBuffer usedLetters;
    private int incorrectTries;
    private static final int MAX_ALLOWED_INCORRECT_TRIES = 6;


    //constructor
    public Hangman() { // chooses the secret word, gives the alphabet from which the player choses the letter, starts to form the secret word with only the letters we know so far.
        this.secretWord = chooseSecretWord();
        this.incorrectTries = 0;
        this.allLetters = new StringBuffer("ABCDEFGHIJKLMNOPRSTUVWXYZ");
        this.usedLetters = new StringBuffer("");
        knownSoFar = new StringBuffer("");
        for(int i = 0; i < this.secretWord.length(); i++)
        {
            this.knownSoFar.append("_"); // shows each letter of the secret word as "_"
        }
    }

    
    //getAllLetters
    public String getAllLetters(){
        return allLetters.toString();
    }

    //selects the secret word
    public String getSecretWord(){
        return secretWord.toString();
    }

    //getUsedLetters
    public String getUsedLetters(){
        return usedLetters.toString();
    }

    //getNumberOfIncorrectTries
    public int getNumberOfIncorrectTries(){
        return incorrectTries;
    }

    //getMaxAllowedIncorrectTries
    public static int getMaxAllowedIncorrectTries(){
        return MAX_ALLOWED_INCORRECT_TRIES;
    }

    //getKnownSoFar
    public String getKnownSoFar(){
        return knownSoFar.toString();
    }
    
    // this methods takes a letter and updates knownSoFar, isTheLetterExists etc.
    public int tryThis(char ch) {
        int count = 0;
        for (int i = 0; i < this.secretWord.length(); i++) {
            if (this.secretWord.charAt(i) == ch) {
                count++;
                this.knownSoFar.deleteCharAt(i);
                this.knownSoFar.insert(i, ch);
            }
        }
        this.usedLetters.append(ch);
        if (count == 0) {
            this.incorrectTries++;
        }
        return count;
    }
  
    private StringBuffer chooseSecretWord() {
        //These are some of the secret words that can be used during the game.
        String[] secretWordList = {"ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", "CHAR", "CLASS", "CONST",
        "CONTINUE", "DEFAULT", "DOUBLE", "DO", "ELSE", "ENUM", "EXTENDS", "FALSE", "FINAL", "FINALLY", "FLOAT", "FOR", "GOTO", 
        "IF", "IMPLEMENTS", "IMPORT", "INSTANCEOF", "INT", "INTERFACE", "LONG", "NATIVE", "NEW", "NULL", "PACKAGE",
        "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", 
        "THROW", "THROWS", "TRANSIENT", "TRUE", "TRY", "VOID", "VOLATILE", "WHILE"};

        Random rand = new Random();
        int randIndex = rand.nextInt(secretWordList.length); 

        StringBuffer result = new StringBuffer(secretWordList[randIndex]);
        return result;
    }

    public boolean hasLost(){
        if(this.incorrectTries != MAX_ALLOWED_INCORRECT_TRIES)
        return false;
        
        return true;
    }

 
    public boolean isGameOver(){
        if(this.hasLost()||(this.getKnownSoFar().toString().equals(this.getSecretWord())))
        return true;

        return false;
    }

    public boolean hasWon(){
        if(this.getKnownSoFar().toString().equals(this.getSecretWord()))
        return false;
        
        return true;
    }

}
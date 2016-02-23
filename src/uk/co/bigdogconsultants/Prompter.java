package uk.co.bigdogconsultants;

/**
 * Created by Steve on 10/12/2015.
 */
import java.io.Console;
public class Prompter{

    //Private member variable for game
    private Game mGame;
    Console console = System.console();

    //Adding a constructor that takes the game logic object
    public Prompter (Game game){
        mGame = game;// So now if you go to create a prompter, you'll give it a game object and we'll store that in a private variable called mGame
    }
    public void play(){
        while (mGame.getRemainingTries()> 0){
            displayProgress();
            promptForGuess();
        }
    }
    //Grant the prompter ability to prompt for a guess w/ the goal of returning T or F
    public boolean promptForGuess(){
        Console console = System.console(); // Using the imported io.Console package above (now the sys knows what we're talking about)
        boolean isHit = false;
        boolean isValidGuess = false;
        String guessAsString = "";
        while (!isValidGuess){
            // Returning a string back from what the guesser guesses
            guessAsString = console.readLine("Enter a letter:  ");
            // Our apply guess method only takes a char (de Game.java), we need to get one using the charAt() method to get the 1st character back
        }
        try{
// Pass whatever our game object returns as a guess (de the applyGuess Boolean) ie we're going to call the applyGuess method and pass in guess that we got, which was the first character de the String) which will return T or F
            isHit = mGame.applyGuess(guessAsString);
            isValidGuess = true;}
        catch (IllegalArgumentException iae){
            console.printf ("%s. Please try again. %n", iae.getMessage());
        }

        return isHit;}
    //Allow prompter to display the progress
    public void displayProgress(){
        System.out.printf("You have %d tries left to solve: %s%n",
                mGame.getRemainingTries(),//for %d
                mGame.getCurrentProgress()); //for %s
    }
}

package uk.co.bigdogconsultants;

public class Hangman {

    public static void main(String[] args) {
	// write your code here
        Game game = new Game ("treehouse");
        //Prompter takes in a new game object.
        Prompter prompter = new Prompter(game);
        // New variable to see if it's working temporarily.
        prompter.play();

    }
}

package uk.co.bigdogconsultants;

/**
 * Created by Steve on 10/12/2015.
 */
public class Game{
    public static final int MAX_MISSES = 7; //Added exposed constant that shouldn't be changed (hence final)
    private String mAnswer;
    private String mHits = "";   //Added declaration needed to initialize below
    private String mMisses = "";  //Added declaration needed to initialize below

    public Game(String answer){
        mAnswer = answer;
        mHits ="";
        mMisses = "";
    }
    //Added private method that will validate/return a guaranteed lowercase version
    private char validateGuess(char letter){
        if (! Character.isLetter(letter)){
            throw new IllegalArgumentException ("A letter is required");
        }
        letter = Character.toLowerCase(letter);
        if (mMisses.indexOf(letter) >= 0 || mHits.indexOf(letter) >= 0) {
            throw new IllegalArgumentException (letter + " has already been guessed");
        }
        return letter;
    }
    public boolean applyGuess(String letters){
        if (letters.length() == 0) {
            throw new IllegalArgumentException("No letter found");
        }
        return applyGuess(letters.charAt(0));
    }
    //Public method will return true for a hit and false for miss/allow us to apply a guess
    public boolean applyGuess (char letter){
        letter = validateGuess (letter);
        boolean isHit = mAnswer.indexOf(letter) >=0;
        //if true, we'll increment our hit variable.....else: if false, e
        if (isHit){
            mHits += letter;
        }
        else {
            mMisses += letter;
        }
        return isHit;
    }
    //Method to display the current progress that'll show dashes for unguessed letters or letters for the letters that have been guessed
    public String getCurrentProgress(){
        String progress ="";
        for (char letter: mAnswer.toCharArray()){
            char display = '_';
            if(mHits.indexOf(letter) >= 0){ // if the letter is in the answer, we'll change the display to letter
                display = letter;
            }
            progress += display; // Progress changing depending on value guessed
        }
        return progress;
    }
    //Code that exposes how many tires are left (MAX_MISSES - how many misses they've already made)...the return equates to a #....like MATH
    public int getRemainingTries(){
        return MAX_MISSES - mMisses.length();
    }
}

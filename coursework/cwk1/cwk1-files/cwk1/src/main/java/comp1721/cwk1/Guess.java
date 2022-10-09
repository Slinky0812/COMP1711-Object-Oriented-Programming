package comp1721.cwk1;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;


public class Guess {
  // Use this to get player input in readFromPlayer()
  private static final Scanner INPUT = new Scanner(System.in);
  private int guessNumber;
  private String chosenWord;
  //ANSI escape codes
  public static final String ANSI_GREEN = "[30;102m";
  public static final String ANSI_YELLOW = "[30;103m";
  public static final String ANSI_WHITE = "[30;107m";
  public static final String ANSI_RESET = "[0m";

  public Guess (int number) {

    if (number < 1 || number > 6) {
      throw new GameException("Error: Game number out of range");
    }
    guessNumber = number;

  }

  public Guess (int number, String word) {
    if (number < 1 || number > 6) {
      throw new GameException("Error: Game number out of range");
    }
    guessNumber = number;

    //checks the word length
    if (word.length() != 5) {
      throw new GameException("Error");
    }

    //checks if all the characters in the chosenWord are letters
    for (int i = 0; i < word.length(); i++) {
      char character = word.charAt(i);
      if (!Character.isLetter(character)) {
        throw new GameException("Error: the word isn't all letters");
      }
    }

    this.chosenWord = word.toUpperCase();
  }

  public int getGuessNumber() {
    return guessNumber;
  }

  public String getChosenWord() {
    return chosenWord;
  }

  public void readFromPlayer() {
    //asks the player for their guess, sets it to chosenWord, and makes it all upperCase()
    System.out.printf("Enter Guess (%d/6): ", guessNumber);
    chosenWord = INPUT.nextLine();
    chosenWord = chosenWord.toUpperCase();
  }

  public String compareWith(String targetWord) {
    //an array of the letters in the target word
    ArrayList<Character> targetLetters = new ArrayList<Character>();
    //an array of the letters that have been printed yellow or green
    ArrayList<Character> colouredLetters = new ArrayList<Character>();
    //an array of the letters that are repeated in the target word
    ArrayList<Character> repeatedLetters = new ArrayList<Character>();

    //building the string with the coloured letters
    StringBuilder lineBuilder = new StringBuilder();

    //puts all the letters of targetWord into targetLetters
    for (int t = 0; t < targetWord.length(); t++) {
      targetLetters.add(targetWord.charAt(t));
    }

    //finds the letters that have been repeated in targetWord and stores them into repeatedLetters
    for (int p = 0; p < targetWord.length(); p++) {
      int count = 1;
      //q is set to always be one index above p when p is incremented
      for (int q = p + count; q < targetLetters.size(); q++) {
        if (targetWord.charAt(p) == targetLetters.get(q)) {
          repeatedLetters.add(targetLetters.get(p));
          q = targetLetters.size();
        }
        count += 1;
      }
    }

    //i traverses through chosenWord
    for (int i = 0; i < chosenWord.length(); i++) {
      //j traverses through targetWord
      for (int j = 0; j < targetWord.length(); j++) {
        if (chosenWord.charAt(i) == targetWord.charAt(j)) {

          //checks if a letter has been repeated
          boolean check = false;
          for (int p = 0; p < colouredLetters.size(); p++) {
            if (chosenWord.charAt(i) == colouredLetters.get(p)) {
              for (int r = 0; r < repeatedLetters.size(); r++) {
                if (!(repeatedLetters.get(r) == targetLetters.get(i))) {
                  lineBuilder.append(ANSI_WHITE + " " + chosenWord.charAt(i) + " " + ANSI_RESET); //white
                  r = repeatedLetters.size(); //breaks out of the for loop
                }
              }
              //if the letter has already been coloured, but isn't a repeated letter in the targetWord, then print it as white
              lineBuilder.append(ANSI_WHITE + " " + chosenWord.charAt(i) + " " + ANSI_RESET); //white
              p = colouredLetters.size(); //breaks out of the for loop
              check = true;
            }
          }

          //checks if a repeated letter has already been printed white
          if (check == true) {
            j = targetWord.length();
          //prints green if the position is the same for both chosenWord and targetWord
          } else if (i == j) {
            lineBuilder.append(ANSI_GREEN + " " + chosenWord.charAt(i) + " " + ANSI_RESET);
            colouredLetters.add(chosenWord.charAt(i)); //adds the letter to the colouredLetters array
            j = targetWord.length(); //breaks out of the inner for loop
          //prints yellow if the position is not the same
          } else {
            lineBuilder.append(ANSI_YELLOW + " " + chosenWord.charAt(i) + " " + ANSI_RESET); //yellow
            colouredLetters.add(chosenWord.charAt(i)); //adds the letter to the colouredLetters array
            j = targetWord.length(); //breaks out of the inner for loop
          }
        }
        //if j has reached the end of the for loop and hasn't been coloured, then print it as white
        if (j == (targetWord.length() - 1)) {
          lineBuilder.append(ANSI_WHITE + " " + chosenWord.charAt(i) + " " + ANSI_RESET);
          j = targetWord.length(); //breaks out of the inner for loop
        }
      }
    }
    //builds the string and stores it into word
    String word = lineBuilder.toString();
    return word;
  }

  public boolean matches(String word) {
    //counts how many letters in the chosen word match the letters in the target word
    int count = 0;

    //i traverses through chosenWord
    for (int i = 0; i < chosenWord.length(); i++) {
      //j traverses through the targetWord
      for (int j = 0; j < word.length(); j++) {
        //increment count if the letters are the same and in the same position, i.e. if the letters are green
        if (chosenWord.charAt(i) == word.charAt(j)) {
          count += 1;
          j = word.length();
        }
      }
    }

    //only returns true if count == 5
    if (count == word.length()) {
      return true;
    } else {
      return false;
    }

  }
}

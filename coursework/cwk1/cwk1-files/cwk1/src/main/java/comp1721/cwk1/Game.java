package comp1721.cwk1;


import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Game {
    private int gameNumber;
    private String target;
    //stores an array of strings to store the guesses made
    private String[] guesses = new String[6];


    public Game(String filename) throws IOException {
        //creates an instance of WordList called word
        WordList word = new WordList(filename);

        LocalDate firstDay = LocalDate.of(2021, 6, 19);
        LocalDate today = LocalDate.now();

        //sets gameNumber equal to the difference between the today and the first day in days
        gameNumber = (int) DAYS.between(firstDay, today);
        //sets the target word by calling the getWord function from word
        target = word.getWord(gameNumber);
    }


    public Game (int number, String filename) throws IOException {
        //same as the above constructor
        WordList word = new WordList(filename);
        gameNumber = number;
        target = word.getWord(gameNumber);
    }


    public void play() {
        System.out.printf("WORDLE: %d\n", gameNumber);
        //loops through each round of guessing
        for (int i = 0; i < 6; i++) {
            Guess chosen = new Guess(i + 1); //instance of guess
            chosen.readFromPlayer(); //asks the player for their guess

            //sets colouredWord equal to the string made by the compareWith function, and prints it out
            String colouredWord = chosen.compareWith(target);
            System.out.println(colouredWord);

            //checks if the chosenWord matches the targetWord by calling matches
            boolean check = chosen.matches(target);

            if (check) {
                if (i == 0) {
                    System.out.println("Superb - Got it in one!");
                    guesses[i] = colouredWord; //stores the string colouredWord into the array guesses
                } else if (i <= 4) {
                    System.out.println("Well done!");
                    guesses[i] = colouredWord; //stores the string colouredWord into the array guesses
                } else {
                    System.out.println("That was a close call!");
                    guesses[i - 1] = colouredWord; //stores the string colouredWord into the array guesses
                }
                break;
            //if i == 6 and check is not true, then the word hasn't been guessed
            } else if (i == 5) {
                System.out.println("Nope - Better luck next time!");
                System.out.printf("%s", target);
            //if i != 6 but the word wasn't guessed
            } else {
                guesses[i] = chosen.compareWith(target); //stores the string colouredWord into the array guesses
            }
        }
    }


    public void save(String filename) throws IOException{
        //create path object to the filename
        Path path = Paths.get(filename);
        //creates PrintWriter object to write to the file
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(path))) {
            //i traverses through the guesses array
            for (int i = 0; i < guesses.length; i++) {
                out.printf("%s\n", guesses[i]); //prints it out onto the file
            }
        }
    }
}

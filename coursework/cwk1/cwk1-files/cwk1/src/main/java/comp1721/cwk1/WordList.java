package comp1721.cwk1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class WordList {
    List<String> Words;

    public WordList(String filename) throws IOException {
        Words = new ArrayList<>();

        Scanner input = new Scanner(Paths.get(filename));

        //prints out each word within the list
        while (input.hasNextLine()) {
            String lines = input.nextLine();
            Words.add(lines);
        }

        input.close();
    }

    public int size() {
        int length = Words.size();

        //checks the length of the list Words
        if (length == 0) {
            throw new ArithmeticException ("Error: No data in the file");
        }

        return length;
    }

    public String getWord(int gameNumber) {
        int length = Words.size();

        //checks to see if the gameNumber is in the correct range
        if (gameNumber < 0 || gameNumber >= length) {
            throw new GameException("Error: Game Number out of range");
        }

        return Words.get(gameNumber);
    }
}

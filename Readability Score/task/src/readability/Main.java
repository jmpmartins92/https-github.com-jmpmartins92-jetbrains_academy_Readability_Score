package readability;

import java.io.*;

public class Main {

    static int numCharacters = -1;
    static int numWords = 1;
    static int numSentences = 1;
    static double scoreCalc;
    static int readChar;
    static char lastChar;

    public static void numCharacters(char readChar) {
        if (Character.toString(readChar).matches("\\S")) {
            numCharacters++;
        }
    }

    public static void numWords(char readChar) {
        if (Character.toString(readChar).matches("[ \n\t]")) {
            numWords++;
        }
    }

    public static void numSentences(int readChar) {
        if (Character.toString((char) readChar).matches("[.!?]")) {
            numSentences++;
        }
        if ((readChar == -1) && (Character.toString(lastChar).matches("[.!?]"))) {
            numSentences--;
        }
    }

    public static void main(String[] args) {

        String fileName = args[0];

        try {
            File textFile = new File(fileName);
            FileReader reader = new FileReader(textFile);
            System.out.println("The text is:");


            do {
                readChar = reader.read();
                System.out.print((char) readChar);
                numCharacters((char) readChar);
                numWords((char) readChar);
                numSentences(readChar);
                lastChar = (char) readChar;
            } while (readChar != -1);

            reader.close();

        } catch (IOException e) {
            System.out.println("File not found.");
        }
        scoreCalc = Calculations.scoreCalc(numCharacters, numWords, numSentences);

        System.out.printf("\nWords: %d", numWords);
        System.out.printf("\nSentences: %d", numSentences);
        System.out.printf("\nCharacters: %d", numCharacters);
        System.out.printf("\nThe score is: %.2f", scoreCalc);
        System.out.printf("\nThis text should be understood by %syear-olds.", Calculations.ageInterval(scoreCalc));
    }
}

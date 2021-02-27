package readability;

import java.io.*;
import java.util.Scanner;

public class Main {

    static int numCharacters = -1;
    static int numWords = 1;
    static int numSentences = 1;
    static int numSyllables = 0;
    static int numPolySyllables = 0;
    static int readChar;
    static char lastChar;


    public static void numCharacters(char readChar) {
        if (Character.toString(readChar).matches("\\S")) {
            numCharacters++;
        }
    }

    public static void numSyllables(String word) {
        int numSyllablesWord = 0;
        word = word.toLowerCase();
        /*if ("e ".equals(word.substring(word.length() - 2))) {
            word = word.substring(0, word.length() - 2);
        }
        if (word.matches("[^aeiouy]+$")) {
            numSyllablesWord++;
        } else {
            for (int letterIndex = 1; letterIndex < word.length(); letterIndex++) {

                if (word.substring(letterIndex - 1, letterIndex + 1).matches("[aeiouy]{2}")) {
                    numSyllablesWord++;
                    letterIndex++;

                } else if (word.substring(letterIndex - 1, letterIndex + 1).matches("[aeiouy]")) {
                    System.out.println(word.substring(letterIndex - 1, letterIndex + 1));
                    numSyllablesWord++;
                }
            }
        }*/

        word = word.replaceAll(" ","");
        word = word.replaceAll("e\\b", "");
        word = word.replaceAll("[aeiouy]{2,3}", "a");
        word = word.replaceAll("[eiouy]", "a");
        word = word.replaceAll("th ","a");
        word = word.replaceAll("[,.!?]","");
        if (word.equals("th")) {
            word = "a";
        }
        System.out.println(word);

        char[] wordArray = word.toCharArray();
        for (char letter : wordArray) {
            if (letter == 'a') {
                numSyllablesWord++;
            }
        }

        numSyllables += numSyllablesWord;
        if (numSyllablesWord > 2) {
            numPolySyllables++;
        }
    }

    public static String wordSeparator(char readChar, String word) {
        if (Character.toString(readChar).matches("[ \n\t]")) {
            numWords++;
            numSyllables(word);
            word = "";
        }
        return word;
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
        Scanner scanner = new Scanner(System.in);
        File textFile = new File(fileName);
        System.out.println("The text is:");
        String word = "";

        try (FileReader reader = new FileReader(textFile)) {

            do {
                readChar = reader.read();
                System.out.print((char) readChar);
                word = word.concat(Character.toString(readChar));
                numCharacters((char) readChar);
                word = wordSeparator((char) readChar, word);
                numSentences(readChar);
                lastChar = (char) readChar;
            } while (readChar != -1);

        } catch (IOException e) {
            System.out.println("File not found.");
        } catch (IllegalArgumentException ignored) {

        }


        System.out.printf("\nWords: %d", numWords);
        System.out.printf("\nSentences: %d", numSentences);
        System.out.printf("\nCharacters: %d", numCharacters);
        System.out.printf("\nSyllables: %d", numSyllables);
        System.out.printf("\nPolysyllables: %d", numPolySyllables);
        System.out.print("\nEnter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        System.out.println();
        String scoreType = scanner.next();
        ScoreRequests.printRequest(scoreType);
        scanner.close();
    }
}


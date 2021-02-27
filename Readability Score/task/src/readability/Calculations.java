package readability;

import static readability.Main.*;

public class Calculations {

    public static double scoreARI() {
        return 4.71 * Main.numCharacters / numWords + 0.5 * numWords / numSentences - 21.43;
    }
    static double scoreARI = scoreARI();


    public static double scoreFK() {
        return 0.39 * numWords / numSentences + 11.8 * numSyllables / numWords - 15.59;
    }
    static double scoreFK = scoreFK();

    public static double scoreSMOG() {
        return 1.043 * Math.sqrt(numPolySyllables * 30 / numSentences) + 3.1291;
    }
    static double scoreSMOG = scoreSMOG();

    public static double scoreCL() {
        double l = numCharacters * 100 / numWords;
        double s = numSentences * 100 / numWords;
        return 0.0588 * l - 0.296 * s - 15.8;
    }
    static double scoreCL = scoreCL();

    public static double scoreAverage() {
        return (scoreARI + scoreFK + scoreSMOG + scoreCL) / 4;
    }
    static double scoreAverage = scoreAverage();

    public static String ageScore(double scoreCalc) {
        int scoreRoundedUp = (int) Math.ceil(scoreCalc);
        switch (scoreRoundedUp) {
            case 1: return "6";
            case 2: return "7";
            case 3: return "9";
            case 4: return "10";
            case 5: return "11";
            case 6: return "12";
            case 7: return "13";
            case 8: return "14";
            case 9: return "15";
            case 10: return "16";
            case 11: return "17";
            case 12: return "18";
            case 13: return "24";
            default: return "24+";
        }
    }


}

package readability;

public class Calculations {

    public static double scoreCalc (int numCharacters, int numWords, int numSentences) {
        return 4.71 * numCharacters / numWords + 0.5 * numWords / numSentences - 21.43;
    }

    public static String ageInterval (double scoreCalc) {
        int scoreRoundedUp = (int) Math.ceil(scoreCalc);
        switch (scoreRoundedUp) {
            case 1: return "5-6-";
            case 2: return "6-7-";
            case 3: return "7-9-";
            case 4: return "9-10-";
            case 5: return "10-11-";
            case 6: return "11-12-";
            case 7: return "12-13-";
            case 8: return "13-14-";
            case 9: return "14-15-";
            case 10: return "15-16-";
            case 11: return "16-17-";
            case 12: return "17-18-";
            case 13: return "18-24-";
            default: return "24+ ";
        }
    }
}

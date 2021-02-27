package readability;

import static readability.Calculations.*;


public class ScoreRequests {

    public static void requestARI() {
        System.out.printf("\nAutomated Readability Index: %.2f (about %s-year-olds).",
                scoreARI, Calculations.ageScore(scoreARI));
    }

    public static void requestFK() {
        System.out.printf("\nFlesch-Kincaid readability tests: %.2f (about %s-year-olds).",
                scoreFK, Calculations.ageScore(scoreFK));
    }

    public static void requestSMOG() {
        System.out.printf("\nSimple Measure of Gobbledygook: %.2f (about %s-year-olds).",
                scoreSMOG, Calculations.ageScore(scoreSMOG));
    }

    public static void requestCL() {
        System.out.printf("\nColeman-Liau index: %.2f (about %s-year-olds).",
                scoreCL, Calculations.ageScore(scoreCL));
    }

    public static void requestAverage(double scoreCalc) {
        System.out.printf("\n\nThis text should be understood in average by %s-year-olds.", Calculations.ageScore(scoreCalc));
    }

    public static void printRequest(String scoreType) {
        switch (scoreType) {
            case "ARI": requestARI(); requestAverage(scoreARI);
            case "FK": requestFK(); requestAverage(scoreFK);
            case "SMOG": requestSMOG(); requestAverage(scoreSMOG);
            case "CL": requestCL(); requestAverage(scoreCL);
            case "all": requestARI(); requestFK(); requestSMOG(); requestCL(); requestAverage(scoreAverage);
        }
    }


}

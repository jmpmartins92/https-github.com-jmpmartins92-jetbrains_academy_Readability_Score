package Questions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


class largestYear {

    public static void main(String[] args) throws IOException {
        String filePath = "C:/Users/filon/Downloads/dataset_91069.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        long greatestNumber = 0;
        String correspondingYear = null;
        String pastYearLine;
        reader.readLine();
        while ((pastYearLine = reader.readLine()) != null) {
            try {
                String[] pastYearSplit = pastYearLine.split("\\s+");
                long pastYearValue = Long.parseLong(pastYearSplit[1].replaceAll(",", ""));
                String[] currentYearSplit = reader.readLine().split("\\s+");
                long currentYearValue = Long.parseLong(currentYearSplit[1].replaceAll(",", ""));
                long varYear = currentYearValue - pastYearValue;
                if (varYear > greatestNumber) {
                    greatestNumber = varYear;
                    correspondingYear = currentYearSplit[0];
                }
            } catch (NullPointerException e) {}
        }
        System.out.println(correspondingYear);
    }
}




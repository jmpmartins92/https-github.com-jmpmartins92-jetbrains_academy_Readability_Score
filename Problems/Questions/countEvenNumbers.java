package Questions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class countEvenNumbers {

    public static void main(String[] args) throws IOException {
        String filePath = "C:/Users/filon/Downloads/dataset_91065.txt";

        int countNumbers = 0;
        int number = -1;

        try {
            File dataset_91065 = new File(filePath);
            Scanner scanner = new Scanner(dataset_91065);
            while (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number == 0) {
                    break;
                } else if (number % 2 == 0) {
                    countNumbers++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(countNumbers);

    }

}
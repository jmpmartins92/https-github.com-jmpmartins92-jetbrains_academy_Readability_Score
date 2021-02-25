package Questions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class sumNumbers {

    public static void main(String[] args) throws IOException {
        String filePath = "C:/Users/filon/Downloads/dataset_91033.txt";

        int sumNumbers = 0;

        try {
            File dataset_91033 = new File(filePath);
            Scanner scanner = new Scanner(dataset_91033);
            while (scanner.hasNextInt()) {
                sumNumbers += scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(sumNumbers);

    }

}
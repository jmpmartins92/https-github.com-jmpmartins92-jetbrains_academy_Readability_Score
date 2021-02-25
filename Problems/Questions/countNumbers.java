package Questions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class countNumbers {

    public static void main(String[] args) throws IOException {
        String filePath = "C:/Users/filon/Downloads/dataset_91022.txt";

        int countNumbers = 0;

        try {
            File dataset_91022 = new File(filePath);
            Scanner scanner = new Scanner(dataset_91022);
            while (scanner.hasNextInt()) {
                if (scanner.nextInt() >= 9999) {
                    countNumbers++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(countNumbers);

    }

}
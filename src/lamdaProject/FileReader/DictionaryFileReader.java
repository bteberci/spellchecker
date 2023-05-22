package lamdaProject.FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class DictionaryFileReader {

    public static ArrayList<String> readLinesOfFile(String filePath) throws FileNotFoundException, IOException {

        ArrayList<String> lines = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filePath)) {

            BufferedReader reader = new BufferedReader(fileReader);

            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line.toLowerCase());
            }

        }

        return lines;
    }


}

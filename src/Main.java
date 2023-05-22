import lamdaProject.Correction.ClosestMatch;
import lamdaProject.FileReader.DictionaryFileReader;
import lamdaProject.Punctuation.PunctuationRemover;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ClosestMatch closestMatch = new ClosestMatch();

        String filePath = "/Users/edateberci/Desktop/1st/CS101/JAVA/GroupProject/web2.txt";

        ArrayList<String> dictionary =  DictionaryFileReader.readLinesOfFile(filePath);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a line of text:");
        String input = scanner.nextLine();
        String[] split_input = input.split(" ");

        StringBuilder correctedSentence = new StringBuilder();


        for (String inputWord: split_input){
            String correct_word ="";
            String word = inputWord.toLowerCase();
            PunctuationRemover.PunctuationRemovalResult result = PunctuationRemover.removePunctuation(word);

            String wordNoPunctuation = result.getCleanedSentence();
            List<String> deletedPunctuationMarks = result.getDeletedPunctuationMarks();

            boolean is_exist = closestMatch.check_exist(wordNoPunctuation, dictionary);
            if (is_exist) {
                correctedSentence.append(word).append(" "); //split_strings[i] + deletedPunctuationMarks.get(0);
            } else {
                 correct_word = closestMatch.get_correct_word(wordNoPunctuation, dictionary);
                if (deletedPunctuationMarks.size() > 0) {
                    correctedSentence.append(correct_word).append(deletedPunctuationMarks.get(0)).append(" ");
                } else {
                    correctedSentence.append(correct_word).append(" ");
                }
            }
        }
        System.out.println(correctedSentence);



    }
}
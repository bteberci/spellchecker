package lamdaProject.Correction;

import lamdaProject.Distance.LevenshteinDistance;
import lamdaProject.Distance.CheckLetter;

import java.util.ArrayList;

public class ClosestMatch {
    public  String get_correct_word(String word, ArrayList<String> dictionary) {
        double max_similarity = -1;
        String correct_word = "";
        int count_max = 0;
        for (String s : dictionary) {
            double similarity = LevenshteinDistance.calculateLevenshteinSimilarity(s, word);
            if (CheckLetter.check_same_letter(s, word)) {
                similarity += CheckLetter.calculate_same_letter(s, word);
            }
            if (similarity > max_similarity) {
                max_similarity = similarity;
                correct_word = s;
                count_max = 1;
            } else if (similarity == max_similarity && similarity < 0.5) {
                count_max += 1;
            }
        }

        if (count_max > 1) {
            correct_word = "|" + word + "|";
        }

        return correct_word;
    }
    public  boolean check_exist(String word, ArrayList<String> dictionary) {
        boolean available = false;
        for (String s : dictionary) {
            if (s.equals(word)) {
                available = true;
                break;
            }
        }
        return available;
    }

}

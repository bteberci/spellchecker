package lamdaProject.Distance;

import java.util.Arrays;

public class CheckLetter {
    public static String[] sortStrings(String str1, String str2){
        StringBuilder sorted1 = new StringBuilder();
        StringBuilder sorted2 = new StringBuilder();

        char[] chars1 = str1.toLowerCase().toCharArray();
        char[] chars2 = str2.toLowerCase().toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        sorted1.append(chars1[0]);
        sorted2.append(chars2[0]);

        for (int i = 1; i < chars1.length; i++)
            if (chars1[i] != chars1[i-1])
            {
                sorted1.append(chars1[i]);
            }

        for (int j = 1; j < chars2.length; j++)
            if (chars2[j] != chars2[j-1])
            {
                sorted2.append(chars2[j]);
            }

        return new String[]{sorted1.toString(),sorted2.toString()};
    }
    public static boolean check_same_letter(String str1, String str2) {
        boolean sameChars = false;
        int sameCharCounter = 0;

        String[] sortedWords = sortStrings(str1,str2) ;

        int minLength = Math.min(sortedWords[0].length(), sortedWords[1].length());

        for (int k = 0; k < minLength; k++) {
            if (sortedWords[0].charAt(k) == sortedWords[1].charAt(k)) {
                sameCharCounter++;
            }
        }
        if (sameCharCounter == minLength) {
            sameChars = true;
        }
        return sameChars;
    }

    public static double calculate_same_letter(String str1,String str2){
        double similarity= 0.0;
        double reversedSimilarity = 0.0;

        int minLength = Math.min(str1.length(), str2.length());
        //int maxLength = Math.max(str1.length(), str2.length());

        double step = 1.0;

        String reversed_str1 = new StringBuilder(str1).reverse().toString();
        String reversed_str2 = new StringBuilder(str2).reverse().toString();


        for(int j = 0 ;j<minLength;j++){//calculates similarity between reversed words
            if (reversed_str1.charAt(j) == reversed_str2.charAt(j)){
                reversedSimilarity += step;
            }
        }
        for(int i=0;i<minLength;i++){//calculates similarity between words
            if (str1.charAt(i) == str2.charAt(i)){
                similarity += step;
            }
        }

        if (reversedSimilarity>similarity){
            return reversedSimilarity/str2.length();
        }else {
            return (0.11+similarity)/str2.length();
        }

    }
}
package lamdaProject.Punctuation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PunctuationRemover {

    public static PunctuationRemovalResult removePunctuation(String sentence) {
        // Regular expression pattern to match punctuation
        Pattern pattern = Pattern.compile("\\p{Punct}");

        // Remove punctuation using the pattern
        Matcher matcher = pattern.matcher(sentence);
        StringBuilder cleanedSentence = new StringBuilder();
        List<String> deletedPunctuationMarks = new ArrayList<>();

        int lastMatchEnd = 0;
        while (matcher.find()) {
            cleanedSentence.append(sentence, lastMatchEnd, matcher.start());
            deletedPunctuationMarks.add(matcher.group());
            lastMatchEnd = matcher.end();
        }

        cleanedSentence.append(sentence.substring(lastMatchEnd));

        return new PunctuationRemovalResult(cleanedSentence.toString(), deletedPunctuationMarks);
    }

    public static class PunctuationRemovalResult {
        private String cleanedSentence;
        private List<String> deletedPunctuationMarks;


        public PunctuationRemovalResult(String cleanedSentence, List<String> deletedPunctuationMarks) {
            this.cleanedSentence = cleanedSentence;
            this.deletedPunctuationMarks = deletedPunctuationMarks;
        }

        public String getCleanedSentence() {
            return cleanedSentence;
        }

        public List<String> getDeletedPunctuationMarks() {
            return deletedPunctuationMarks;
        }
    }
}

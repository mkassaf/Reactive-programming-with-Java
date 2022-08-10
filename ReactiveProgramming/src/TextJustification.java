import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int count = 0;

        int start = 0;

        for (int end = 0; end < words.length; end++) {

            count += words[end].length();
            int charCount = count + (end - start);

            boolean generateLine = charCount == maxWidth || end == words.length - 1 || (charCount + 1 + words[end + 1].length()) > maxWidth;

            if (generateLine) {
                String line = justify(start, end, charCount, maxWidth, words);
                result.add(line);
                start = end + 1;
                count = 0;
            }
        }
        return result;
    }

    private String justify(int start, int end, int charCount, int maxWidth, String[] words) {

        StringBuilder line = new StringBuilder();

        int gaps = end - start;
        int totalSpaceCount = maxWidth - charCount;

        // If line has single word, append all the required space to the end
        if (gaps == 0) return line.append(words[start]).append(getSpaces(totalSpaceCount)).toString();

        boolean isLastLine = end == words.length - 1;

        int spaceCountPerWord = isLastLine ? 1 : totalSpaceCount / gaps + 1;
        int totalExtraSpaceCount = isLastLine ? 0 : totalSpaceCount % gaps;

        String spaceString = getSpaces(isLastLine ? 1 : spaceCountPerWord);

        for (int i = start; i <= end; i++) {
            line.append(words[i])
                    .append(gaps > 0 ? spaceString : "")
                    .append(gaps > 0 && totalExtraSpaceCount > 0 ? " " : "");
            gaps -= 1;
            totalExtraSpaceCount -= 1;
        }
        if (isLastLine) line.append(getSpaces(totalSpaceCount));
        return line.toString();
    }

    private String getSpaces(int count) {
        return " ".repeat(count);
    }
}

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DictionaryOfWords {

    public static void main(String[] args) {

        String[]words = {"car","ca","rs"};

        System.out.println(wordBreak("cars", Arrays.stream(words).collect(Collectors.toList())) == true);

        String[]words2 = {"aaaa","aaa"};
        System.out.println(wordBreak("aaaaaaa", Arrays.stream(words2).collect(Collectors.toList())) == true);

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        wordDict = wordDict.stream().sorted().collect(Collectors.toList());
        for (String str : wordDict){
            if(s.contains(str)){
                s = s.replaceFirst(str, "");
            }
        }
        return s.trim().length() == 0;
    }
}


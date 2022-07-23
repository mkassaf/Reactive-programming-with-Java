import java.util.*;
import java.util.stream.Collectors;

public class CollectionInJava {

    public static void main(String[] args) {
        String[] wordArr = {"hello", "functional", "programing", "is","how","Apple", "not", "am", "cool"};
        List<String> words = new ArrayList<>(Arrays.asList(wordArr));

        //create groups based on word length and add the words for the map based on their lengths
        Map<Integer, List<String>> wordsMap = words
                .stream()
                .collect(Collectors.groupingBy(
                        word2 -> word2.length()
                ));

        System.out.println(wordsMap);

        //create two groups, short and long and add the words for the map based on their lengths
        Map<Boolean, List<String>> longWords = words
                .stream()
                .collect(Collectors.partitioningBy(
                        word -> word.length() > 5
                ));

        System.out.println(longWords);




    }
}

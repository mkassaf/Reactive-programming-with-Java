import java.util.Arrays;

public class CountingCharacters {

    public static void main(String[] args) {
        countVowel("HellO");
        countVowel("I am happy");
    }

    /**
     * Counting characters with string manipulation
     * @param input
     * @return
     */
    private static void countVowel(String input) {
        String vowel = "aeiouy";
        char[] chars = input.trim().toLowerCase().toCharArray();
        int countVowel = 0;
        int countNonVowel = 0;
        for (char ch : chars) {
            if(vowel.indexOf(ch) != -1){
                countVowel++;
            } else if (ch != ' '){
                countNonVowel++;
            }
        }
        System.out.println("count non vowel : " + countNonVowel);
        System.out.println("count Vowel : " + countVowel);
    }
}

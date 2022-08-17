import java.util.stream.IntStream;

public class PalindromeChecker {

    public static void main(String[] args) {
        System.out.println(checkPalindrome("car"));
        System.out.println(checkPalindrome("carac"));
        System.out.println(checkPalindrome("carrac"));
    }
    /**
     *
     * Developing a palindrome checker
     * @param string
     * @return
     */
    public static Boolean checkPalindrome(String string){
        int end = string.length();
        int start = 0;
        /*
        --end;
        while (end > start){
            if (string.charAt(start) != string.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
        //Or
        */
        return IntStream.range(0, end/2).allMatch( i->
            string.charAt(i) == string.charAt(end-i-1)
        );
    }
}

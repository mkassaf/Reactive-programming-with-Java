import java.util.*;

public class Problems {

    public static void main(String[] args) {
        System.out.println(solution(9) == 2);
        System.out.println(solution(529) == 4);
        System.out.println(solution(20) == 1);
        System.out.println(solution(15) == 0);
        System.out.println(solution(32) == 0);
        System.out.println(solution(1041) == 5);

        LinkedHashMap lhm = new LinkedHashMap();


    }

    public static Boolean isValid(String str){
        Stack<Character> strStack = new Stack<>();
        if(str.length() == 1){
            return false;
        }
        for (Character current : str.toCharArray()){
            if (current.equals('(') || current.equals('{')  || current.equals('[') ){
                strStack.push(current);
            } else if(!strStack.empty()){
                Character last = strStack.pop();
                if(last.equals('(') && !current.equals(')')){
                    return false;
                }
                if(last.equals('[') && !current.equals(']')){
                    return false;
                }
                if(last.equals('{') && !current.equals('}')){
                    return false;
                }
            } else {
                return false;
            }

        }
        return strStack.empty();
    }

    public static int solution(int N) {
        int longthsPath = 0;
        int currentCout = 0;
        int totalEdg = 0;
        while (N%2 != 1) {
            N = N/2;
        }
        while (N != 0 ) {
            if (N%2 == 1){
                if (longthsPath < currentCout){
                    longthsPath = currentCout;
                }
                totalEdg++;
                currentCout = 0;
            } else {
                currentCout ++;
            }
            N = N/2;

        }
        if(totalEdg < 2){
            return 0;
        }
        return longthsPath;
    }

    /**
     * Write a function solution that, given two integers A and B, returns a string containing exactly A letters 'a' and exactly B letters 'b' with no three consecutive letters being the same (in other words, neither "aaa" nor "bbb" may occur in the returned string).
     *
     * Examples:
     *
     * 1. Given A = 5 and B = 3, your function may return "aabaabab". Note that "abaabbaa" would also be a correct answer. Your function may return any correct answer.
     *
     * 2. Given A = 3 and B = 3, your function should return "ababab", "aababb", "abaabb" or any of several other strings.
     *
     * 3. Given A = 1 and B = 4, your function should return "bbabb", which is the only correct answer in this case.
     *
     * Assume that:
     *
     * A and B are integers within the range [0..100];
     * at least one solution exists for the given A and B.
     * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
     *
     * @param A
     * @param B
     * @return
     */
    public String solution(int A, int B) {
        String result = "";
        int totalA = 0;
        int totalB = 0;
        while(A !=0 || B!=0){
            if(A >= B && totalA < 2){
                A--;
                totalA++;
                totalB = 0;
                result +='a';
            } else if(B >= A && totalB < 2){
                B--;
                totalB++;
                totalA = 0;
                result +='b';
            } else if(totalB < 2){
                B--;
                totalB++;
                totalA = 0;
                result +='b';
            } else if(totalA < 2){
                A--;
                totalA++;
                totalB = 0;
                result +='a';
            }
        }
        return result;
    }


}

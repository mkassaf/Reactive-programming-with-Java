import java.util.*;
import java.util.stream.IntStream;

public class Challenges {


    public static void main(String[] args) {
        int[] array = {-2,-1,-3,4,8,0};
        System.out.println(getMaxProduct(array));//32
        int[] array2 = {-20,-10,3,9,-8};
        System.out.println(getMaxProduct(array2));//200

        printBinaryNumbers(8);

        System.out.println(isMatchParenthesesUsingMap("(<{[]}>)"));//true
        System.out.println(isMatchParenthesesUsingMap("(asdasd<[asdasd]asdasd>)"));//true
        System.out.println(isMatchParenthesesUsingMap("(asd{}d<[asd{sd]as}dasd>)"));//fasle
    }

    public static String getMostRepeatedWord(String text){
        Map<String, Integer> wordsCount = new HashMap<>();
        String[] words = text.split("[ .,-]+");

        for (int i=0; i < words.length; i++){
            wordsCount.putIfAbsent(words[i], 0);
            wordsCount.put(words[i], wordsCount.get(words[i]) + 1);
        }
        return null;

    }
    public static Boolean isMatchParenthesesUsingMap(String text){
        Stack<Character> characters = new Stack<>();
        Map<Character, Character> characterMap = Map.of(')', '(', '}','{',
                '>', '<', ']', '[');
        for (int i=0; i< text.length(); i++){
            if (characterMap.containsValue(text.charAt(i))){
                characters.push(text.charAt(i));
            } else if (characterMap.containsKey(text.charAt(i))){
                if (characters.isEmpty() || characterMap.get(text.charAt(i)) != characters.pop() ){
                    return false;
                }
            }
        }
        return characters.isEmpty();
    }

    public static Boolean isMatchParentheses(String text){
        Stack<Character> characters = new Stack<>();
        for (int i=0; i< text.length(); i++){
            if (isOpenParenthese(text.charAt(i))){
                characters.push(text.charAt(i));
            } else if (isCloseParenthese(text.charAt(i))){
                Character open = characters.pop();
                if (!isACloseForThisParan(open, text.charAt(i))){
                    return false;
                }
            }
        }


        return characters.isEmpty();
    }

    private static boolean isACloseForThisParan(Character open, char charAt) {
        if (charAt == ']' ){
            return open == '[';
        }
        if (charAt == '}' ){
            return open == '{';
        }
        if (charAt == '>' ){
            return open == '<';
        }
        return open == '(';
    }

    private static boolean isCloseParenthese(char charAt) {
        if (charAt == ']' || charAt == '}' || charAt == '>' || charAt== ')'){
            return true;
        }
        return false;
    }

    private static boolean isOpenParenthese(char charAt) {
        if (charAt == '(' || charAt == '{' || charAt == '<' || charAt== '['){
            return true;
        }
        return false;
    }

    public static void printBinaryNumbers(int number){
        if (number <=0) {
            System.out.println("Nothing to print!!");
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        for (int i=1; i< number; i++){
            Integer current = queue.poll();
            System.out.println(current);
            queue.add(current * 10);
            queue.add(current * 10 + 1);
        }

    }


    //Maximum product of two numbers
    public static int getMaxProduct(int [] number){
        if (number.length < 2){
            return Integer.MIN_VALUE;
        }
        int max = number[0];
        int secMax = Integer.MIN_VALUE;
        int min = number[0];
        int secMin = Integer.MAX_VALUE;
        for (int i=1; i<number.length; i++){
            if (number[i] > max){
                secMax =max;
                max =number[i];
            } else if (secMax < number[i]){
                secMax =number[i];
            }
            if(min > number[i]){
                secMin = min;
                min = number[i];
            } else if (secMin > number[i]){
                secMin = number[i];
            }
        }
        return Math.max((max * secMax), (min * secMin));
    }


    /**
     * Is the string capitalize correct
     * @param text
     * @return
     */
    public static boolean isCapitalCorrect(String text){

        if (Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(1))) {
            return text.chars().skip(2).mapToObj(ch -> (char) ch).allMatch(Character::isUpperCase);
        }
        return text.chars().skip(1).mapToObj(ch -> (char)ch).allMatch(Character::isLowerCase);
    }



}

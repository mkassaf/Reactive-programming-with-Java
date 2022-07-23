import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MapFunction {


    public static void main(String[] args) {
        Integer[] array = {-1,1,5,6,2,4};
        //Simply sort the array, then filter negative numbers and then print it.
        Arrays.stream(array).sorted().filter(x-> x >= 1).forEach(x -> System.out.println(x));

        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(array));
        List<Integer> listOfIntegersDouble = listOfIntegers.stream().filter(x-> x >= 1).map(x -> x*2).sorted().collect(Collectors.toList());
        listOfIntegersDouble.forEach(x -> System.out.println("X: " + x));

        Function<Integer, Predicate<String>> createLengthTest = min -> str-> str.length() > min;

        String[] wordArr = {"hello", "functional", "programing", "is", "cool"};
        System.out.println("################################");
        Arrays.stream(wordArr).filter(str -> str.length() > 5).forEach(x -> System.out.println(x));
        System.out.println("################################");
        Arrays.stream(wordArr).filter(createLengthTest.apply(5)).forEach(x -> System.out.println(x));
        System.out.println("################################");
        Arrays.stream(wordArr).filter(createLengthTest.apply(2)).forEach(x -> System.out.println(x));

    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceInJava {

    public static void main(String[] args) {

        Integer[] intArray = {6,5,12,1,2,3,4,5,6,7,8,9};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer result = acc + x;
            System.out.println("acc: " + acc + ", x: " + x + ", result: " + result);
            return result;
        };
        BinaryOperator<Integer> getSmallest= (acc, x) -> {
            if(acc > x){
                acc = x;
            }
            System.out.println("acc: " + acc);
            return acc;
        };
        System.out.println(getSum.apply(1,2));
        //acc: 1, x: 2, result: 3
        //3
        Integer sum = listOfIntegers.stream().reduce(0, getSum);
        System.out.println("sum: " + sum);
        Integer min = listOfIntegers.stream().reduce(Integer.MAX_VALUE, getSmallest);
        System.out.println("min: " + min);

    }
}

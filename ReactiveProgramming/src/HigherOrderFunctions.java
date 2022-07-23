import java.util.function.BiFunction;
import java.util.function.Function;

public class HigherOrderFunctions {



    public static void main(String[] args) {
        BiFunction<Float, Float, Float> divide1 = (x,y) -> {
            if (y == 0f ){
                System.out.println("Error: Can't divide by zero");
                return 0f;
            }
            return x/y;
        };
        System.out.println(divide1.apply(3f, 0f));
        /*
            The problem in divide1 function that it breaks the single responsibility principle.
            Because it validates the input in addition to the division
            See how can we solve this below:
        */

        //This a function that repos
        BiFunction<Float, Float, Float> divide = (x,y) -> x/y;
        //This function takes a BiFunction<Float, Float, Float> function as param and returns a BiFunction<Float, Float, Float>
        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> secondArgIsnotZeroCheck =
        (func) -> (x, y) -> {
            if (y == 0f ){
                System.out.println("Error: Can't divide by zero");
                return 0f;
            }
            return func.apply(x,y);
        };

        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> returnSameFun = func -> func;

        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> returnSameNewFun =
            func -> (x,y) -> func.apply(x,y);

        BiFunction<Float, Float, Float> divideSafe = secondArgIsnotZeroCheck.apply(divide);
        System.out.println(divideSafe.apply(3f, 0f));
        System.out.println(divideSafe.apply(3f, 2f));


        BiFunction<Float, Float, Float> divideUsingSame = returnSameFun.apply(divide);
        BiFunction<Float, Float, Float> divideUsingSame2 = returnSameNewFun.apply(divide);
        System.out.println(divideUsingSame.apply(3f, 2f));
        System.out.println(divideUsingSame2.apply(3f, 2f));

    }
}

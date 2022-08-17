import java.util.function.Consumer;
import java.util.function.Function;


public class LamdaFunctions {


    public static void main(String[] args) {
        call(t -> {
            System.out.println(t);
        });

        Function<Integer, Integer> fun = n -> n%2;
        System.out.println(fun.apply(5));
        System.out.println(fun.apply(8));
    }


    public static void call(Function<Integer, Function<Integer, Integer>> function){

    }

    public static void call(Consumer consumer){
        consumer.accept("Assaf");
    }


}

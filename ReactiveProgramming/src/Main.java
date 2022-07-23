import java.util.function.Function;

public class Main {
    public Function<Integer, Integer> myfun = null;

    private static Function<Integer, Integer> triple(Integer y){
        return x-> x*y;
    }


    public static void main(String[] args) {

        Function<Integer, Integer> myFun1 = x -> x *1;
        Function<Integer, Integer> myFun2 = x -> x *2;
        Function<Integer, Integer> myFun3 = x -> x *3;

        System.out.println(myFun1.apply(2));
        System.out.println(myFun2.apply(2));
        System.out.println(myFun3.apply(2));




    }

}

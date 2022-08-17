import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionAsData {


    public Consumer<Integer> function;

    public FunctionAsData(Boolean isDev) {
        if (isDev){
            function = Id -> System.out.println(Id + " We are in dev mode");
        } else {
            function = Id -> System.out.println(Id + " We are not in dev mode");
        }
    }

    public void printMode(Integer data){
        function.accept(data);
    }

    public static IntFunction<Integer> call(Integer n){
        return n1 -> n1 + n;
    }
    public static void main(String[] args) {
        FunctionAsData obj = new FunctionAsData(false);
        obj.function.accept(5);


        System.out.println(call(3).apply(2));


        List<String> list = List.of("A", "B", "C");
        List<String> list2 = list.stream().filter(s -> !s.equals(list.get(0))).collect(Collectors.toList());

        list.forEach( s-> System.out.print(s));

        System.out.println("\n-------: " +  list);
        list2.forEach( s-> System.out.print(s));

        List<String> colors = new ArrayList<>(Arrays.asList("RED", "BLUE", "BLACK"));

        Collections.reverse(colors);
        System.out.println(colors);

        int stage = 5;

        String season = switch(stage) {
            case 1 -> "Summer";
            case 2 -> "Spring";
            case 3 -> "Winter";
            case 4 -> "Fall";
            default -> {
                System.out.println("Invalid");
                yield "Invalid";
            }
        };

        System.out.println(season);

        String text = "This is a text, which is a sample. I want to tes it.";
        //spliting a string by space and dot and comma at the same time
        System.out.println(Arrays.asList(text.split("[ .,]+")));

    }

}

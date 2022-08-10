import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

public class BestSumForATarget {
    public static void main(String[] args) {
        ArrayList<Integer> arrays = new ArrayList<>();
        arrays.add(1);
        arrays.add(2);
        arrays.add(5);
        arrays.add(25);
        var result = bestSum(arrays, 100, new HashMap<>());

        for (int i: result ) {
            System.out.print(i + ", ");
        }

    }

    public static ArrayList<Integer> bestSum(ArrayList<Integer> numbers, int target, HashMap<Integer, ArrayList> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if (target == 0) return new ArrayList<>();
        if (target < 0 ) return null;
        ArrayList<Integer> shortest = null;
        for (Integer num: numbers  ) {
            Integer reminder = target - num;
            ArrayList<Integer> result = bestSum(numbers, reminder, memo);

            if (result != null){
                ArrayList<Integer> combind = new ArrayList<>();
                result.forEach(t -> combind.add(t));
                combind.add(num);
                if(shortest == null || combind.size() < shortest.size()){

                    shortest = combind;

                }
            }
        }
        memo.put(target, shortest);
        return shortest;
    };
}

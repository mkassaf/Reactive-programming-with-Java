import java.util.*;

public class CombinationSum {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        return combinationSum2(candidates, target, 0, new HashMap<>());
    }

    private List<List<Integer>> combinationSum2(int[] candidates, int target, int start, HashMap<Integer,List<List<Integer>>> memo) {
        if(memo.containsKey(target)) return memo.get(target);
        List<List<Integer>> result = new ArrayList<>();
        if(target == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        if(target < 0) return null;
        for (int i=start; i< candidates.length; i++) {
            Integer num = candidates[i];
            int reminder = target - num;
            List<List<Integer>> innerResult = combinationSum2(candidates, reminder,i+1, memo);
            if(innerResult != null){
                innerResult.forEach( list -> list.add(num));

                for (List<Integer> integers : innerResult) {
                    List<Integer> tmp = new ArrayList<>();
                    for (Integer integer : integers) {
                        tmp.add(integer);
                    }
                    tmp.add(num);
                    result.add(tmp);
                }

            }

        }
        memo.put(target , result);
        return result;

    }
}

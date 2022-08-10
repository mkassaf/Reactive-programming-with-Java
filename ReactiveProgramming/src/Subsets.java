import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Subsets {

    /**
     *
     *Given an integer array nums of unique elements, return all possible subsets (the power set).
     *
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * Example 2:
     *
     * Input: nums = [0]
     * Output: [[],[0]]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * All the numbers of nums are unique.
     * Accepted
     * 1,190,965
     * Submissions
     * 1,635,224
     *
     */

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3};
        System.out.println(test.toString());
        int[] test3 = new int[]{1,2,3};
        System.out.println(subsets(test));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        result.add(tmp);
        if (nums.length == 0){
            return result;
        }
        tmp = new ArrayList<>();
        tmp.add(nums[0]);
        result.add(tmp);
        for (int index = 1; index < nums.length; index++){
            List<List<Integer>> resultTmp = new ArrayList<>();

            for (List<Integer> list : result){
                tmp = new ArrayList<>();
                for(Integer n : list){
                    tmp.add(n);
                }
                tmp.add(nums[index]);
                resultTmp.add(tmp);
            }
            result.addAll((resultTmp));

        }


        return result;

    }
}

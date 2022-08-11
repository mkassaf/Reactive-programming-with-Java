import java.util.LinkedHashSet;
import java.util.Set;

public class SingleNumber {
    /*

Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99


Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.

     */

    public static void main(String[] args) {
        int[] nums = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        Set<Integer> numers = new LinkedHashSet<Integer>();
        Long toalall = Long.valueOf(0);
        double total = 0;
        for (Integer n : nums){
            if(!numers.contains(n)){
                numers.add(n);
                toalall += n;
            }
            total += n/3.0;
        };
        return (int) Math.round((3* ((toalall - total)/2)));
    }
}

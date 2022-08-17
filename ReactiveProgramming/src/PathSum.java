import java.util.ArrayList;
import java.util.List;

public class PathSum {

    /*
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.



Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000


     */

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        int remianing = targetSum - root.val;
        if (remianing == 0 && root.left == null && root.right ==null){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(root.val);
            result.add(tmp);
            return result;
        }
        List<List<Integer>> right = pathSum(root.right, remianing);
        List<List<Integer>> left = pathSum(root.left, remianing);

        for (List<Integer> list : left) {
            list.add(0, root.val);
        }
        for (List<Integer> list : right) {
            list.add(0, root.val);
        }

        result.addAll(left);
        result.addAll(right);


        return result;
    }
}

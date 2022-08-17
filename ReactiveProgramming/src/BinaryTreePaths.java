import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public List<String> binaryTreePaths(TreeNode root) {
            List<String> result =  new ArrayList();
            if(root == null){
                return result;
            }
            if(root.left == null && root.right == null){
                result.add(String.valueOf(root.val));
                return result;
            }

            if(root.left != null){
                List<String> left = binaryTreePaths(root.left);
                left.forEach(s -> result.add(root.val + "->" + s));
            }

            if(root.right != null){
                List<String> right = binaryTreePaths(root.right);
                right.forEach(s -> result.add(root.val + "->" + s));

            }
            return result;

        }
    }
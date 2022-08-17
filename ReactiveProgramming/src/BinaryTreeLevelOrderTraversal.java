import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    /*
    Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000

     */



    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            List<Integer> childNode = new ArrayList<>();
            List<TreeNode> innerNode = new ArrayList<>();
            while (!nodes.isEmpty()){
                TreeNode node = nodes.get(0);
                if(node.left != null)
                    innerNode.add(0, node.left);
                if(node.right != null)
                    innerNode.add(0, node.right);

                childNode.add(node.val);
            }
            nodes.clear();
            innerNode.forEach( node -> {
                nodes.add(node);
            });
            if(childNode.size() != 0)
                result.add(0, childNode);

        }


        return result;
    }
}

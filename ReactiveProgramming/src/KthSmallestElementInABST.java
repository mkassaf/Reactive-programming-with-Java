import java.util.*;

public class KthSmallestElementInABST {


    public int kthSmallest(TreeNode root, int k) {
        if (root == null)return -1;
        List<Integer> result = new ArrayList<>();
        kthSmallest(root, result);

        return result.get(result.size() - k);

    }
    public void kthSmallest(TreeNode root,  List<Integer> result) {
        if (root == null) return;

        kthSmallest(root.left, result);
        kthSmallest(root.right, result);
        result.add(root.val);
    }

}

package lc31;

public class Test1315 {
    public int sumEvenGrandparent(TreeNode root) {
        // 空节点
        if (root == null) {
            return 0;
        }
        int ans = 0;
        // 偶数节点
        if (root.val % 2 == 0) {
            ans += sum(root.left) + sum(root.right);
        }
        // 递归处理左右子树
        ans += sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
        return ans;

    }

    private int sum(TreeNode root) {
        // 空节点
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (root.left != null) {
            ans += root.left.val;
        }
        if (root.right != null) {
            ans += root.right.val;
        }
        return ans;
    }

}

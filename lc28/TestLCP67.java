public class TestLCP67 {
    public TreeNode expandBinaryTree(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                root.left = new TreeNode(-1, root.left, null);
                expandBinaryTree(root.left.left);
            }
            if (root.right != null) {
                root.right = new TreeNode(-1, null, root.right);
                expandBinaryTree(root.right.right);

            }
        }
        return root;
    }

}

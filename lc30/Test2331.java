package lc30;

public class Test2331 {
    public boolean evaluateTree(TreeNode root) {
        switch (root.val) {
            case 0:
                return false;
            case 1:
                return true;
            case 2: // OR
                return evaluateTree(root.left) || evaluateTree(root.right);
            case 3: // AND
                return evaluateTree(root.left) && evaluateTree(root.right);
        }
        return false;
    }
}

package lc30;

public class Test1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == target) {
            return cloned;
        }
        TreeNode res = null;
        if (original.left != null) {
            res = this.getTargetCopy(original.left, cloned.left, target);
        }
        if (res == null && original.right != null) {
            return this.getTargetCopy(original.right, cloned.right, target);
        }
        return res;
    }

}

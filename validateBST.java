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
class validateBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}

        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isValidBST(TreeNode root) {
        // while we might be able to do iteratively, nice recursive definiton
        // make an interval of acceptable values and check each child against the interval
        // then recurse onto the child
        return isValid(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValid(TreeNode root, long left, long right){
        // check if current node is within the interval
        // check each subtree and return
        if(root == null){
            return true;
        }
        if (root.val <= left || root.val >= right){
            return false;
        }
        if(root.right == null && root.left == null){
            return true;
        }
        return (isValid(root.left,left,root.val) && isValid(root.right,root.val,right));
    }
}
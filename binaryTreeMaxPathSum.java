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
class binaryTreeMaxPathSum {
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
    public int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // we make a recursive function
        maxPath(root);
        return this.maxSum;
    }
    // recursive function returns maxPathSum for root without splitting
    // we also update the maxSum at each level to account for a split
    private int maxPath(TreeNode root){
        if (root == null){
            return 0;
        }
        // we calculate maxPath on left and right
        int left = Math.max(maxPath(root.left),0);
        int right = Math.max(maxPath(root.right),0);
        this.maxSum = Math.max(this.maxSum, (root.val+left+right));

        // now we return max of left and right (which are each already floored at 0)
        return (root.val + Math.max(left,right));
    }
}
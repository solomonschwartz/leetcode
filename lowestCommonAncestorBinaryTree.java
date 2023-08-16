/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class lowestCommonAncestorBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // lets explain - since its a BST, we know at a given root, all nodes to left are less than and
        // all nodes to right are greater than
        // so we can exploit this. If at any point we reach a case wehre root is between values
        // it is guaranteed to be the LCA. If two numbers are greater or less, we can recurse down a level
        // if our root is one of the values, also know for sure that the root is LCA and cant go lower
        while(root != null){
            if(p.val > root.val && q.val > root.val){
                // move into right tree since both greater
                root = root.right;
            } else if (p.val < root.val && q.val < root.val){
                // move into left tree since both less
                root = root.left;
            } else{
                // either our root == p||q or we have a split. Either way, our root is LCA so return
                return root;
            }
        }
        // we should never reach this but if root is null from get-go, we need to return it
        return root;
    }
}
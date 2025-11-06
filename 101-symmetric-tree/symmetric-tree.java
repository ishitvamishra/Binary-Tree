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
class Solution {
    public boolean isMirror(TreeNode nodeLeft, TreeNode nodeRight){
        if(nodeLeft == null && nodeRight == null){
            return true;
        }
        else if(nodeLeft == null || nodeRight == null || nodeLeft.val != nodeRight.val){
            return false;
        }
        return isMirror(nodeLeft.left, nodeRight.right) && isMirror(nodeLeft.right, nodeRight.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left,root.right);
    }
}
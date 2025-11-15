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
    int totalTilt = 0;

    public int transform(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSum = transform(root.left);
        int rightSum = transform(root.right);

        int tilt = Math.abs(leftSum - rightSum);
        totalTilt+= tilt;

        return root.val+leftSum+rightSum;
    }
    public int findTilt(TreeNode root) {
        transform(root);
        return totalTilt;
    }
}
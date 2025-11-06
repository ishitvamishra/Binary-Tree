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
    int i = 0;
    public TreeNode recoverFromPreorder(String s) {
        return helper(s, 0);
    }

    private TreeNode helper(String s, int depth) {
        int n = s.length();
        int d = 0, val = 0, start = i;
        while (i < n && s.charAt(i) == '-') {
            d++;
            i++;
        }
        if (d != depth) {
            i = start;
            return null;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            val = val * 10 + (s.charAt(i) - '0');
            i++;
        }
        TreeNode node = new TreeNode(val);
        node.left = helper(s, depth + 1);
        node.right = helper(s, depth + 1);
        return node;
    }
}
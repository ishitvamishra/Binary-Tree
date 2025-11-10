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
    int preIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build map to get index of root in inorder in O(1)
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        
        // Root is always current element in preorder
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        
        // Get inorder index of root
        int inorderIndex = inorderMap.get(rootVal);
        
        // Build left and right subtrees
        root.left = build(preorder, inStart, inorderIndex - 1);
        root.right = build(preorder, inorderIndex + 1, inEnd);
        
        return root;
    }
}
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap <Integer, Integer> inMap = new HashMap<>();

        for(int i = 0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }

        return build(postorder,0,postorder.length-1,inorder,0,inorder.length-1,inMap);
    }

    public TreeNode build(int[] post, int ps, int pe, int[] in, int is, int ie, HashMap<Integer, Integer>inMap){

        if(ps > pe || is > ie) return null;

        TreeNode root = new TreeNode(post[pe]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot- is;

        root.left = build(post, ps, ps+numsLeft-1, in, is, inRoot-1, inMap);
        root.right = build(post, ps+numsLeft, pe-1, in, inRoot+1, ie, inMap);

        return root;
    }
}
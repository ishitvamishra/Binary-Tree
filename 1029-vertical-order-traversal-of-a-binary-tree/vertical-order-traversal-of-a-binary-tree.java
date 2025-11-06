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
    static class NodeInfo {
        int row, col, val;
        NodeInfo(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> list = new ArrayList<>();

        
        dfs(root, 0, 0, list);

        
        Collections.sort(list, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            else if (a.row != b.row) return a.row - b.row;
            else return a.val - b.val;
        });

        
        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        List<Integer> currList = new ArrayList<>();

        for (NodeInfo n : list) {
            if (n.col != prevCol) {
                if (!currList.isEmpty()) result.add(currList);
                currList = new ArrayList<>();
                prevCol = n.col;
            }
            currList.add(n.val);
        }

        result.add(currList);
        return result;
    }

    private void dfs(TreeNode node, int row, int col, List<NodeInfo> list) {
        if (node == null) return;
        list.add(new NodeInfo(row, col, node.val));
        dfs(node.left, row + 1, col - 1, list);
        dfs(node.right, row + 1, col + 1, list);
    }
}
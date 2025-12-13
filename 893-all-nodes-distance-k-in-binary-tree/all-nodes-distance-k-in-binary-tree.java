/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParent(TreeNode root, Map<TreeNode, TreeNode> parentTrack){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left != null){
                queue.offer(current.left);
                parentTrack.put(current.left, current);
            }

            if(current.right != null){
                queue.offer(current.right);
                parentTrack.put(current.right, current);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        markParent(root, parentTrack);
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(curr_level == k) break;
            curr_level++;
            for(int i = 0;i<size;i++){
                TreeNode current = queue.poll();
                if(current.left != null && visited.get(current.left) == null){
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }

                if(current.right != null && visited.get(current.right) == null){
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }

                if(parentTrack.get(current) != null && visited.get(parentTrack.get(current)) == null){
                    queue.offer(parentTrack.get(current));
                    visited.put(parentTrack.get(current), true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode current= queue.poll();
            result.add(current.val);
        }
        return result;
    }
}
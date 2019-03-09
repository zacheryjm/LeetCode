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
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int longestVal = 0;
        
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            int numEdges = (dfs(node.left, node.val, map)+1) + (dfs(node.right, node.val, map)+1);
            longestVal = Math.max(longestVal, numEdges);
            
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
            
        }
        
        return longestVal;
        
    }
    
    public int dfs(TreeNode root, int value, Map<TreeNode, Integer> map) {
        
        if(root == null || root.val != value ) {
            return -1;
        }
        
        if(map.containsKey(root)) {
            return map.get(root);
        }
        
        int numEdgesLeft = dfs(root.left, value, map)+1;
        int numEdgesRight = dfs(root.right, value, map)+1;
        
        int numEdges = Math.max(numEdgesLeft, numEdgesRight);
        
        map.put(root, numEdges);
        
        return numEdges;
        
        
    }
}
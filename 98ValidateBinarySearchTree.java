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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            
            TreeNode node = queue.poll();
            if(node != null) {
                boolean searchLeft = dfs(node.left, node.val, true);
                boolean searchRight = dfs(node.right, node.val, false);
                
                if(searchLeft == false || searchRight == false) {
                    return false;
                }
                
                queue.add(node.left);
                queue.add(node.right);
            }            
        }     
        return true;
    }
    
    public boolean dfs(TreeNode root, int parentVal, boolean isLeftBranch) {
        if(root == null) return true;
        
        if((isLeftBranch && root.val >= parentVal) || (!isLeftBranch && root.val <= parentVal)) {
            return false;
        }
      
        boolean leftSubtree = dfs(root.left, parentVal, isLeftBranch);  
        boolean rightSubtree = dfs(root.right, parentVal, isLeftBranch);
        
        if(leftSubtree && rightSubtree) {
            return true;
        }
        else {
            return false;
        }
        
    }
}
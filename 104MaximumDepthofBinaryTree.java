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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        return maxDepth(root, 0);
        
    }
    
    public int maxDepth(TreeNode root, int depth) {
        if(root.left == null && root.right == null) return depth+1;
        
        depth = depth + 1;
        int leftChildDepth = depth;
        int rightChildDepth = depth;
        
        if(root.left != null) {
            leftChildDepth = maxDepth(root.left, depth);
        }
        
        if(root.right != null) {
            rightChildDepth = maxDepth(root.right, depth);
        }

        
        return Math.max(leftChildDepth,rightChildDepth);
    }
}
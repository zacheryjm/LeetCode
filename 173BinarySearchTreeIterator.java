/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    Queue<TreeNode> queue;

    public BSTIterator(TreeNode root) {
        this.queue = new LinkedList<TreeNode>();
        if(root != null) traverseTree(root, this.queue);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = queue.poll();
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(queue.isEmpty()) return false;
        else return true;
    }
    
    private void traverseTree(TreeNode root, Queue<TreeNode> queue) {
        if(root.left != null) traverseTree(root.left, queue);
        queue.add(root);
        if(root.right != null) traverseTree(root.right, queue);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
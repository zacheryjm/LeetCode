/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serializedTree = new StringBuilder();
        buildString(root, serializedTree);
        return serializedTree.toString();
        
    }

    private void buildString(TreeNode root, StringBuilder str) {

        if(root == null) {
            str.append("null,");
        }
        else {
            String val = root.val + ",";
            str.append(val);
            buildString(root.left, str);
            buildString(root.right, str);

        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String reg = ",";
        String[] treeNodeValues = data.split(reg);
                
        Queue<String> nodes = new LinkedList<String>();
        
        nodes.addAll(Arrays.asList(treeNodeValues));
                
        return buildTree(nodes);
        
    }
    
    private TreeNode buildTree(Queue<String> nodes) {
        
        String val = nodes.poll();
        
        if(val.equals("null")) {
            return null;
        }
        else {
            
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
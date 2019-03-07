/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Map<Node, Node> map = new HashMap<Node,Node>();
        
        Node headCopy = new Node(head.val, head.next, head.random);
        map.put(head, headCopy);
        
        Node runner = head.next;
        Node copyRunner = headCopy;
        
        while(runner != null) { 
            Node newNode = new Node(runner.val, runner.next, runner.random);
            map.put(runner, newNode);
            
            copyRunner.next = newNode;
            
            copyRunner = copyRunner.next;
            runner = runner.next;
        }
        
        Node randRunner = headCopy;
        runner = head;
                
        while(randRunner != null && runner != null) {
            randRunner.random = map.get(runner.random);
            
            randRunner = randRunner.next;
            runner = runner.next;
        }
        
        
        return headCopy;
    }
}
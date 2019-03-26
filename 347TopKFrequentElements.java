class Solution {
    public class Node {
        int val;
        int freq;
        Node(int val) {
            this.val = val;
            this.freq = 1;
        }
    }
    
    public class NodeComparable implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            if (n1.freq < n2.freq) {
                return -1;
            }
            else if(n1.freq == n2.freq) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();
        
        Map<Integer, Node> map = new HashMap<Integer, Node>();
        NodeComparable comparable = new NodeComparable();
        PriorityQueue<Node> heap = new PriorityQueue(comparable);
        
        for(int i = 0; i < nums.length; ++i) {
            
            if(map.containsKey(nums[i])) {
                Node n = map.get(nums[i]);
                n.freq += 1;
                //map.put(nums[i], n);
            }
            else {
                Node newNode = new Node(nums[i]);
                map.put(nums[i], newNode);
            }
            
        }
        
        for(Map.Entry<Integer, Node> entry : map.entrySet()) {
            
            Node n = entry.getValue();
            heap.add(n);
            
            if(heap.size() > k) {
                heap.poll();
            } 
        }
        
        while(k > 0) {
            Node n = heap.poll();
            list.add(n.val);
            k--;
        }
        return list;
    }
    
    
}
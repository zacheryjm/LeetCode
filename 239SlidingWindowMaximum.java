class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return nums;
        
        Comparator<Integer> intComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        };
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, intComparator);

        int [] maximums = new int [nums.length-(k-1)];
        int val = 0;
        int pos = 0;
        
        
        for(int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        
        maximums[pos] = queue.peek();
        pos++;
        
        for(int i = k; i < nums.length; i++) {
            queue.remove(nums[i-k]);
            queue.add(nums[i]);
            maximums[pos] = queue.peek();
            pos++; 
        }
        return maximums;
    }
}
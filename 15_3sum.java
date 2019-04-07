class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> sums = new ArrayList<List<Integer>>();
        Set<List<Integer>> found = new HashSet<List<Integer>>();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            
            int start = i+1; 
            int end = nums.length-1;
            
            while(start < end) {
                
                if(nums[i]+nums[start]+nums[end] == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]); 
                    
                    if(!found.contains(list)) {
                        sums.add(list);
                        found.add(list);
                    }

                }
                if(nums[i]+nums[start]+nums[end] > 0) {
                    end--;
                }
                else {
                    start++;
                }
            }         
        }
        
        return sums;
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            
            int neededValue = target - nums[i];
            
            if (sums.containsKey(neededValue) && sums.get(neededValue) != i) {
                int[] twoSum = {sums.get(neededValue), i};
                return twoSum;
            }
            else {
                sums.put(nums[i], i);
            }        
        }
        int[] noVal = {-1, -1};
        return noVal; 
    }
}
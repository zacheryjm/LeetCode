class Solution {
    public int maxSubArray(int[] nums) {
        int maxSubArray = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < nums.length; ++i) {
            maxSubArray = Math.max(maxSubArray + nums[i], nums[i]);
            max = Math.max(max, maxSubArray);
            
        }
        return max;
    }
}
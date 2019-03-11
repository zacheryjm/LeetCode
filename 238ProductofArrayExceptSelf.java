class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] forward = new int [nums.length];
        int [] backward = new int [nums.length];
        
        for (int i = 0; i < nums.length; ++i) {
            if(i == 0) {
                forward[i] = 1;
            }
            else {
                forward[i] = forward[i-1] * nums[i-1];
            }
        }
        
        for(int j = nums.length-1; j >= 0; --j) {
            if(j == nums.length-1) {
                backward[j] = 1;
            }
            else {
                backward[j] = backward[j+1] * nums[j+1];
            }
        }
        
        for(int k = 0; k < nums.length-1; ++k) {
            forward[k] = forward[k] * backward[k];
        }
        
        return forward;
    }
}
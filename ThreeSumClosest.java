class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int closestSum = nums[0] + nums[1] + nums[nums.length-1];
        
        for (int i = 0; i < nums.length-2; i++) {
            int startPos = i+1;
            int endPos = nums.length-1;
            
            while(startPos != endPos) {
                int sum = nums[i] + nums[startPos] + nums[endPos];
                
                if(Math.abs(target-sum) < Math.abs(target-closestSum)) {
                    closestSum = sum;
                }
                
                if(closestSum == target) {
                    return closestSum;
                }
                
                if (sum < target) {
                    startPos++;
                }
                else {
                    endPos--;
                }
                
            }
        }
        
        return closestSum;
    }
}
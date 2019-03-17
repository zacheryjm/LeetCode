class Solution {
    public int search(int[] nums, int target) {
        int end = nums.length-1;
        int start = 0;
        
        while (start < end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > nums[end]) start = mid+1;
            else end = mid;
        }
        
        int pivot = start;
        
        start = 0; 
        end = nums.length - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            int pivotMid = (mid + pivot) % (nums.length); 
            
            if(nums[pivotMid] == target) return pivotMid;
            
            if(nums[pivotMid] < target) start = mid+1;
            else end = mid-1;
  
        }
        
        return -1;
    }
    
}
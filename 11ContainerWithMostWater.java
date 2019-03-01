cclass Solution {
    public int maxArea(int[] height) {
        
        int maxArea = 0, start = 0, end = height.length -1;        

        while (start != end) {
            int area = Math.min(height[start], height[end]) * (end-start);
            maxArea = Math.max(maxArea, area);
                    
            if(height[start] < height[end]) {
                start++;
            }
            else {
                end--;
            }
        }
        return maxArea;
    }
}
}
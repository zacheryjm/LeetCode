class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        
        int forwardVal = x;
        int reversedVal = 0;   
        int placeCount = 0;
        
        while(x != 0) {
            x = x / 10;
            placeCount++;
        }
                
        x = forwardVal;
        
        while(placeCount > 0) {
            reversedVal += (x % 10)* (int)(Math.pow(10, placeCount-1));
            x = x / 10;
            placeCount--;
        }

        return (forwardVal == reversedVal);
    }
}
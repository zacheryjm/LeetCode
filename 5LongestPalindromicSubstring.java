class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0; 
        int end = 0;
        
        for(int i = 0; i < s.length(); i++) {
            
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i+1);
            
            int len = Math.max(len1, len2);
            
            if(len > end-start) {
                start = i - ((len-1) / 2);
                end = i + (len/2);
            }
        } 
        return s.substring(start, end+1);
    }
    
    public int expandFromCenter(String s, int pos1, int pos2) {
        
        while(pos1 >= 0 && pos2 < s.length() && s.charAt(pos1) == s.charAt(pos2)) {
            pos1--;
            pos2++;
        }
        
        return pos2-pos1-1;
        
        
    }
}
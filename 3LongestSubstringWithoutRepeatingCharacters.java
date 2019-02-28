class Solution {
    public int lengthOfLongestSubstring(String s) {
        int largestSubstring = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int posFirstSeen = 0;
        
        for(int index = 0; index < s.length(); ++index) {
            if(map.containsKey(s.charAt(index))) {
                posFirstSeen = Math.max(posFirstSeen, map.get(s.charAt(index))+1);
            }
            map.put(s.charAt(index), index);
            largestSubstring = Math.max(largestSubstring, (index+1)-posFirstSeen);
        }  
        return largestSubstring;
    }
}
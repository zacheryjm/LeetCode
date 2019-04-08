class Solution {
    public int numDecodings(String s) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        return numDecodings(s, 0, map);
    }
    
    public int numDecodings(String s, int pos, Map<Integer, Integer> map) {
        if(pos >= s.length()) return 1;
        else if(s.charAt(pos) == '0') return 0;
        
        if(map.containsKey(pos)) {
            return map.get(pos);
        }
        
        int numWays = numDecodings(s, pos+1, map);
        
        if(pos+1 < s.length()) {
            int val = (Integer.valueOf(s.substring(pos,pos+1)) * 10) + 
                (Integer.valueOf(s.substring(pos+1,pos+2)));
            if(val <= 26) { 
                numWays += numDecodings(s, pos+2, map);
            }
        }
        
        map.put(pos, numWays); 
        return numWays;
        
    }
}
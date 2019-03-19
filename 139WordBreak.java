class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {  
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        return wordBreak(s, wordDict, 0, map);
    }
    
    public boolean wordBreak(String s, List<String> wordDict, int currentPos, Map<Integer, Boolean> map) {
        if(currentPos >= s.length()) return true;
        
        if(map.containsKey(currentPos)) return map.get(currentPos);
        
        for(int i = 0; i < wordDict.size(); ++i) {
            int finalPos = currentPos + wordDict.get(i).length();
            
            if(finalPos <= s.length()) {
                String wordToCompare = s.substring(currentPos, finalPos);
            
                if (wordToCompare.compareTo(wordDict.get(i)) == 0) {
                    boolean works = wordBreak(s, wordDict, finalPos, map);
                    if(works) {
                        map.put(currentPos, true);
                        return true;
                    }
                } 
            }  
        }
        
        map.put(currentPos, false);
        return false; 
    }
}
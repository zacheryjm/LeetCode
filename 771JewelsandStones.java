class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<Character> jewels = new HashSet<Character>();
        
        for(int i = 0; i < J.length(); ++i) {
            jewels.add(J.charAt(i));
        }
        
        for(int j = 0; j < S.length(); ++j) {
            if(jewels.contains(S.charAt(j))) count++;
        }
        
        return count;
    }
}
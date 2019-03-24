class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() > 0 && p.charAt(0) == '*') return false;
        
        s = " ".concat(s);
        p = " ".concat(p);
        
        boolean [][] memo = new boolean [s.length()][p.length()];
        
        memo [0][0] = true;

        for(int i = 1; i < memo[0].length; ++i) {
            if(p.charAt(i) == '*') {
                memo[0][i] = memo[0][i-2];
            }
            else {
                memo[0][i] = false;  
            }
        }
        
        for(int i = 1; i < memo.length; ++i) {
            for(int j = 1; j < memo[0].length; ++j) {
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    memo[i][j] = memo[i-1][j-1];
                }
                else if(p.charAt(j) == '*') {
                    memo[i][j] = memo[i][j-2];
                    if(p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i)) {
                        memo[i][j] = memo[i][j] | memo[i-1][j];
                    }    
                }
                else {
                    memo[i][j] = false;
                }
            }   
        }
        
        return memo[s.length()-1][p.length()-1];
        
    }
}
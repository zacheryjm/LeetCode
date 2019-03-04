class Solution {
    public int repeatedStringMatch(String A, String B) {
    
        int numRepeated = 1;
        StringBuilder str = new StringBuilder(A);
        
        while(str.length() < B.length()) {
            str.append(A);
            numRepeated++;
        }
        
        if(str.indexOf(B) >= 0) {
            return numRepeated;
        }
        else if(str.append(A).indexOf(B) >= 0) {
            return ++numRepeated;
        }
        else {
            return -1;
        }
            
    }
}
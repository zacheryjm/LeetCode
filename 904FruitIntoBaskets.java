class Solution {
    public int totalFruit(int[] tree) {
        
        if(tree.length == 0) {return 0;}
        
        int maxFruit = 0, previousFruit = -1;
        
        for(int i = 0; i < tree.length; ++i) {
            if((tree.length-i) < maxFruit) {return maxFruit;}
            if(tree[i] != previousFruit) {
                
                int firstFruit = tree[i];
                previousFruit = firstFruit;
                
                maxFruit = Math.max(maxFruit, findFruit(tree, firstFruit, i));
            }
        }
        
        return maxFruit;
    }
    
    public int findFruit(int[] tree, int first, int currentPos) {
        int second = -1;
        int fruitFound = 0;
        
        while(currentPos < tree.length && (tree[currentPos] == first 
                                           || tree[currentPos] == second || second == -1)) {
            
            if(tree[currentPos] != first && second == -1) {second = tree[currentPos];}
            fruitFound++;
            currentPos++;
        }
        
        return fruitFound;
    }
}

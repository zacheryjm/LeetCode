class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || amount < 0) return -1;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        return coinChange(coins, amount, map);
        
    }
    
    public int coinChange(int[] coins, int amount, Map<Integer, Integer> map) {
        
        if(amount == 0) return 0;
        
        int min = Integer.MAX_VALUE;
        
        for(int coin : coins) {
            int change = 0;
            if(amount - coin >= 0) {
                if(map.containsKey(amount-coin)) {
                    change += map.get(amount-coin)+1;
                }
                else {
                    change += coinChange(coins, amount-coin, map)+1;
                    
                }
                if(change > 0) {
                    min = Math.min(min, change);
                }  
            } 
        }
        map.put(amount, min);
        if(min == Integer.MAX_VALUE) return -1;
        return min;

    }
}
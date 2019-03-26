class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> sums = new ArrayList<List<Integer>>();
        
        Arrays.sort(candidates);
        
        combinationSum(candidates, sums, new ArrayList(), target, candidates.length-1);

        return sums;
    }
    
    public void combinationSum(int[] candidates, List<List<Integer>> sums, List<Integer> curr,
                                        int target, int pos) {
        
        if(target == 0) {
            sums.add(curr);
            return;
        }
        if(pos < 0) return;
        
        int numVal = 1;
        combinationSum(candidates, sums, new ArrayList<Integer>(curr), target, pos-1);
        
        while(target - numVal*(candidates[pos]) >= 0) {
                curr.add(candidates[pos]);
                combinationSum(candidates, sums, new ArrayList<Integer>(curr), 
                               target-numVal*(candidates[pos]), pos-1);
                numVal++;
        }
    } 
}
class Solution {
    public List<String> letterCombinations(String digits) {
                
        if (digits.isEmpty()) {
            return new ArrayList<String>();
        }
        
        List<String> combinations = new ArrayList<String>();
        Map <Character, String[]> map = buildMapping();
        String [] letters = map.get(digits.charAt(0));
        
        letterCombinations(digits, "", map, combinations);

        return combinations;
    }
    
    public void letterCombinations(String digits, String str, 
                                   Map <Character, String[]> map, List<String> combinations) {
        if(digits.isEmpty()) {
            combinations.add(str);
            return;
        }
        
        String [] letters = map.get(digits.charAt(0));
        
        for(int i = 0; i < letters.length; i++) {
            StringBuilder strBuilder = new StringBuilder(str);
            strBuilder.append(letters[i]);
            letterCombinations(digits.substring(1), strBuilder.toString(), map, combinations);
        }
    }
    
    public Map<Character, String[]> buildMapping() {
        String [] two = {"a","b","c"};
        String [] three = {"d","e","f"};
        String [] four = {"g","h","i"};
        String [] five = {"j","k","l"};
        String [] six = {"m","n","o"};
        String [] seven = {"p","q","r","s"};
        String [] eight = {"t","u","v"};
        String [] nine = {"w","x","y","z"};
        
        Map <Character, String[]> mapping = new HashMap<Character, String[]>();
        
        mapping.put('2', two);
        mapping.put('3', three);
        mapping.put('4', four);
        mapping.put('5', five);
        mapping.put('6', six);
        mapping.put('7', seven);
        mapping.put('8', eight);
        mapping.put('9', nine);
        
        return mapping;
    }
}
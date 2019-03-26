class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> doms = new ArrayList<String>();
        if(cpdomains.length == 0) return doms;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < cpdomains.length; i++) {
            String [] cpdomain = cpdomains[i].split(" ");
            String domain = cpdomain[1];
            int count = Integer.valueOf(cpdomain[0]);
                
            addDomainToList(domain, count, map);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            StringBuilder str = new StringBuilder();
            str.append(entry.getValue());
            str.append(" ");
            str.append(entry.getKey());
            
            doms.add(str.toString());
        }
        
        return doms;
    }
    
    public void addDomainToList(String domain, int count, Map<String, Integer> map) { 
        boolean endOfDomain = false;
        
        while(!endOfDomain) {
            if(map.containsKey(domain)) {
                map.put(domain, map.get(domain)+count);
            }
            else {
                map.put(domain, count);
            }
        
            int p = domain.indexOf('.');
            if(p != -1) {
                domain = domain.substring(p+1, domain.length());
            }
            else {
                endOfDomain = true;
            }
        }
        
        
        
        
    }
}
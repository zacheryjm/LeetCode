class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> uniqueEmails = new HashSet<String>();
        
        for (int i = 0; i < emails.length; ++i) {
            int index = emails[i].indexOf("@");
            
            String localName = emails[i].substring(0,index);
            String domainName = emails[i].substring(index+1);
                    
            int indexOfPlus = localName.indexOf('+');
            
            if(indexOfPlus != -1) {
                localName = localName.substring(0,indexOfPlus);
            }  
            
            localName = localName.replace(".","");
            String email = localName + "@" + domainName;
                
            uniqueEmails.add(email);
        }
        
        
        return uniqueEmails.size();
       
    }
}
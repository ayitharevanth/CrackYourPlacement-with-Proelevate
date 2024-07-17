
class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        
        HashMap <String, List<String>> mp = new HashMap<>();
        List<List<String>> ans = new ArrayList <List<String>>();
        
        for(String i: string_list)
        {
            char ch[] = i.toCharArray();
            Arrays.sort(ch);
            String s = String.valueOf(ch);
            
            if(mp.containsKey(s))
            {
    
                mp.get(s).add(i);
            }
            
            else
            {
                List<String> li = new ArrayList<>();
                // Add the original string
                li.add(i);
                ans.add(li);
                mp.put(s,li);
            }
        }
        
        return ans;
        
    }
}



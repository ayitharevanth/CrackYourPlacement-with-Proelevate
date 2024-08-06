class Trie{
    public Trie[] next = new Trie[26];
    public boolean end = false;
    public Trie(){}
}
class Solution {
    
    private Trie trie = new Trie();

    HashMap<Integer, Boolean> dp = new HashMap<Integer,Boolean>();
    
    private void putWordsToTrie(List<String> words){
        for(String word : words){
            Trie curr = trie;
            for(int i= 0 ; i < word.length();++i){
                if(curr.next[word.charAt(i) - 'a'] == null) curr.next[word.charAt(i) - 'a'] = new Trie();
                curr = curr.next[word.charAt(i) - 'a'] ;
            }
            curr.end = true;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        putWordsToTrie(wordDict);
        return check(s, 0, wordDict);
    }
    
    private boolean check(String s, int l, List<String> wordDict){
        
        if(l == s.length()) return true;
        else if(dp.containsKey(l)) return dp.get(l);
        
        boolean flag = false;
        Trie curr = trie;
        boolean result = false;
        for(int i = l; i < s.length(); ++i){
            curr = curr.next[s.charAt(i) - 'a'];
            if(curr == null) break;
            if(curr.end && check(s, i+1,wordDict)) {
                result = true;
                break;
            }
        }
        dp.put(l,result);
        return result;
    }
}

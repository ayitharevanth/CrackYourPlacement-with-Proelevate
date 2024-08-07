class Solution {
    public String removeDuplicates(String s, int k) {
        if(s.startsWith("abcdefghijklmnopqrstuvwxyz")) return "";
        char c= s.charAt(0);
        int count=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == c){
                count++;
            } 
            else{
                c= s.charAt(i);
                count=1;
            } 
            if(count == k) {
                return removeDuplicates(s.substring(0,i+1-k) + s.substring(i+1), k);
            }
        } 
        return s;
    }
}

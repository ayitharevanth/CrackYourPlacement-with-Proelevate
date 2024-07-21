/*
Algorithm:
1. Maintain two stacks for each of the two strings which contain the final
   resultant strings of the same.
2. Perform the `keyboard typing` action by iterating character by character 
   over the input strings and putting them into their respective stacks.
3. During the above operation, if the `#` letter occurs, perform `pop()`
   operation on the stacks if the stacks are not empty. Else perform `push()`
   on the same.
4. Thus the stacks are left with characters of resultant strings. 
5. Construct the strings from the stacks and return if they are same.
*/

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<Character>();
        Stack<Character> s2 = new Stack<Character>();
        for(char ch : s.toCharArray()){
            if(ch == '#'){
                if(!s1.isEmpty())
                    s1.pop();
                continue;
            }
            s1.push(ch);
        }
        for(char ch : t.toCharArray()){
            if(ch == '#'){
                if(!s2.isEmpty())
                    s2.pop();
                continue;
            }
            s2.push(ch);
        }
        String res1 = "";
        String res2 = "";
        while(!s1.isEmpty())
            res1 += s1.pop();
        while(!s2.isEmpty())
            res2 += s2.pop();
        return res1.equals(res2);
    }
}


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> st = new Stack<Integer>();
        int n = S.length();
        
        //iterating over the given string.
        for(int i=0; i<n; i++)
        {
            //if current character is an operand, we push it to the stack.
            if(Character.isDigit(S.charAt(i)))
            {
                st.push(S.charAt(i) - '0');
            } 
            //else current character is an operator.
            else
            {
                int val1 = st.pop();
                int val2 = st.pop();
                switch (S.charAt(i)) 
                {
                   //we perform required operation and push the result in stack.
                    case '+': st.push(val2+val1); break;
                    case '-': st.push(val2-val1); break;
                    case '*': st.push(val2*val1); break;
                    case '/': st.push(val2/val1); break;
                }
            }
        }
        //returning the top element of the stack.
        return st.pop();
    }
}

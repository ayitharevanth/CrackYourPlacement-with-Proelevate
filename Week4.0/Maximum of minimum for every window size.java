class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        //stack used to find previous and next smaller numbers.
        Stack<Integer> s = new Stack<>();

        //using arrays to store previous and next smaller numbers.
        int left[] = new int[n + 1];
        int right[] = new int[n + 1];

        //initializing elements of left[] and right[].
        for (int i = 0; i < n; i++) {
            left[i] = -1;
            right[i] = n;
        }

        //filling elements of left[] using logic discussed in 
        //next greater element problem.
        for (int i = 0; i < n; i++) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) s.pop();
            if (!s.empty()) left[i] = s.peek();
            s.push(i);
        }

        //emptying the stack as stack is going to be used for right[].
        while (!s.empty()) 
        s.pop();

        //filling elements of right[] using same logic.
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) s.pop();
            if (!s.empty()) right[i] = s.peek();
            s.push(i);
        }

        //creating and initializing answer list.
        int ans[] = new int[n + 1];
        for (int i = 0; i <= n; i++) 
        ans[i] = 0;

        //filling answer list by comparing minimums of all
        //lengths computed using left[] and right[].
        for (int i = 0; i < n; i++)
        {
            //length of the interval.
            int len = right[i] - left[i] - 1;

            //arr[i] is a possible answer for this length 'len' interval,
            //check if arr[i] is more than max for 'len'.
            ans[len] = Math.max(ans[len], arr[i]);
        }

        //some entries in ans[] may not be filled yet. Filling
        //them by taking values from right side of ans[].
        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        StringBuffer str = new StringBuffer();

        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            res[i-1] = ans[i];
        }
        //returning the answer list.
        return res;
    }
}

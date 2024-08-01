
import java.util.*;

class Solution
{
// Check whether any permutation 
// exists which satisfy the condition.
static boolean isPossible(Integer a[], int b[],
                                  int n, int k) 
{
    // Sort the array a[] in decreasing order.
    Arrays.sort(a, Collections.reverseOrder());

    // Sort the array b[] in increasing order.
    Arrays.sort(b);

    // Checking condition on each index.
    for (int i = 0; i < n; i++)
    if (a[i] + b[i] < k)
        return false;

    return true;
}
}


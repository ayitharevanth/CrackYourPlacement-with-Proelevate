class Solution
{
    
    int maxProfit, count;

    static int comparison(Job first, Job second) {
        if (first.deadline != second.deadline) {
            return first.deadline - second.deadline;
        }
        return second.profit - first.profit;
    }

    void find(Job[] arr, int curr, int n, int t, int profit, int cnt) {
        if (curr >= n) {
            if (profit > maxProfit) {
                maxProfit = profit;
                count = cnt;
            }
            return;
        }
        if (arr[curr].deadline > t)
            find(arr, curr + 1, n, t + 1, profit + arr[curr].profit, cnt + 1);
        find(arr, curr + 1, n, t, profit, cnt);
    }

    

    //Function to find the maximum profit and the number of jobs done.
     int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
       Arrays.sort(arr, Solution::comparison);
        maxProfit = Integer.MIN_VALUE;
        count = 0;
        find(arr, 0, n, 0, 0, 0);
        return new int[]{count, maxProfit};
    }
}

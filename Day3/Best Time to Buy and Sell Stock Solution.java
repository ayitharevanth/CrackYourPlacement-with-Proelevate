class Solution
{
    public static int maxProfit(int [] prices)
    {
        int min=Integer.MAX_VALUE;
        int max=0;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<min){min=prices[i];}
            else
            {
                int profit=Math.abs(prices[i]-min);
                max=Math.max(max,profit);
            }
        }
        return max;
    }
}

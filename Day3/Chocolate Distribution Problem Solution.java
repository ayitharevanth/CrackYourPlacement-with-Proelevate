class Solution
{
    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
      Collections.sort(a);
    
      if (m > n) {
        return -1;
      }
    
      long minDiff = a.get(n - 1) - a.get(0);
    
      for (int i = 0; i < n - m + 1; i++) {
          
        long diff = a.get(i + m - 1) - a.get(i);
        minDiff = Math.min(minDiff, diff);
      }
    
      return minDiff;
    }
}

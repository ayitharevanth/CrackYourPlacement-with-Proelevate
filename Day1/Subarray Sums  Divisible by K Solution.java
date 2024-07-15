class Solution {
        public int subarraysDivByK(int[] A, int K) {
        int result = 0;
        int[] sum = new int[A.length+1];
        sum[0] = A[0];
        
        //prefix sum
        for (int i = 1;i<A.length;i++)
            sum[i] = sum[i-1] + A[i];
        
        int[] count = new int[K];
        for (int i : sum)
            count[(i % K + K) % K]++;
        
        for (int i : count)
            result += i * (i -1) / 2;
        return result;
    }
}

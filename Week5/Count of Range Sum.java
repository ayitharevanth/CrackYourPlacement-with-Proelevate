class Solution {
    private int mergeSort(long[] res, int start, int end, int lower, int upper){
        //Edge or Cornor Case...
        if(end-start <= 1) return 0;

        int mid = start + (end-start)/2;
        int count = mergeSort(res, start, mid, lower, upper) + 
                    mergeSort(res, mid, end, lower, upper);

        int j=mid, k=mid, t=mid;
        long[] l = new long[end-start];
        for(int i=start, r=0; i<mid; i++,r++){
            while(k<end && res[k]-res[i]<lower) k++;
            while(j<end && res[j]-res[i]<=upper) j++;
            while(t<end && res[t]<res[i]) l[r++] = res[t++];

            l[r] = res[i];
            count += (j-k);
        }
        System.arraycopy(l, 0, res, start, t-start);
        return count;
    }


    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] res = new long[nums.length + 1];
        for(int i=0; i<nums.length; i++){
            res[i+1] = res[i] +nums[i];
        }

        return mergeSort(res, 0, nums.length+1, lower, upper);
    }
}

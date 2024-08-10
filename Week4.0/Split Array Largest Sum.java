class Solution {
    public int splitArray(int[] nums, int m) {
        int lo = 0, hi = 0;
        for(int num: nums){
            if(num > lo){
                lo = num;
            }
            hi += num;
        }
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(mIsValid(nums, m, mid)){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    private boolean mIsValid(int[] nums, int m, int val){
        int groupNeed = 0, curSum = 0;
        for(int num: nums){
            curSum += num;
            if(curSum > val){
                ++groupNeed;
                curSum = num;
            }
        }
        if(curSum > 0){
            ++groupNeed;
        }
        return groupNeed <= m;
    }
}

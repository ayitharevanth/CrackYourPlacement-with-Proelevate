class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        int temp;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]<0) {
                temp = max;
                max = min;
                min = temp;
            }
            max = Integer.max(nums[i],nums[i]*max);
            min = Integer.min(nums[i],nums[i]*min);
            ans = Integer.max(ans,max);
        }
        return ans;
    }
}

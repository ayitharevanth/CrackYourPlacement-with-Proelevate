class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freqCount = new HashMap();
        for(int num: nums) {
            freqCount.put(num, freqCount.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: freqCount.entrySet()) {
            if(entry.getValue() > n/2) return entry.getKey();
        }
        return -1;
    }
}

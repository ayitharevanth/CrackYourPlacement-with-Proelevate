class Solution {
   public int[] mostCompetitive(int[] nums, int k) {
        int N = nums.length;
        int len = N - k;
        int[] res = new int[k];
        int cnt = 0;
        PriorityQueue<Pair<Integer, Integer>> pq=
                    new PriorityQueue<Pair<Integer, Integer>>(N,(a,b) -> (a.getKey() == b.getKey()) ? (a.getValue() - b.getValue()) : (a.getKey() - b.getKey()));
        for (int i = 0; i <= len; i++) {
            pq.add(new Pair<>(nums[i], i));
        }
        Pair<Integer, Integer> t = pq.poll();
        res[cnt++] = t.getKey();
        int minIdx = t.getValue();
        for (int i = len+1; i < N; i++) {
            pq.add(new Pair<>(nums[i], i));
            t = pq.poll();
            while (t.getValue() < minIdx) {
                t = pq.poll();
            }
            res[cnt++] = t.getKey();
            minIdx = t.getValue();
        }
        return res;
    }
	```
}

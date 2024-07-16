class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(n, k, 1, ds, ans); // start from 1 instead of 0
        return ans;
    }

    public void helper(int n, int k, int start, ArrayList<Integer> ds, List<List<Integer>> ans) {
        if (ds.size() == k) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = start; i <= n; i++) {
            ds.add(i); // add the actual value i to the list instead of the index
            helper(n, k, i + 1, ds, ans); // increment start to i + 1 to avoid duplicates
            ds.remove(ds.size() - 1); // remove the last element to backtrack
        }
    }
}

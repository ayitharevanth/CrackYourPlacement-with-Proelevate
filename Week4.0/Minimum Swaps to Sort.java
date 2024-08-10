
class Solution
{
    public int minSwaps(int nums[])
    {
        int n = nums.length;
        ArrayList<ArrayList<Integer>> cur = new ArrayList<>();
        
        for(int i=0; i<n; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            temp.add(i);
            cur.add(temp);
        }
        
        cur.sort(new Comparator<ArrayList<Integer>> ()
        {
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2)
            {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);
        
        int ans = 0;
        
        for (int i = 0; i < n; i++)
        {
            if (vis[i] || cur.get(i).get(1) == i)
                continue;
            else
            {
                int cycle_size = 0;
                int j = i;
                
                while (!vis[j])
                {
                    vis[j] = true;
                    j = cur.get(j).get(1);
                    cycle_size++;
                }
                ans += Math.max(0,cycle_size - 1);
            }
        }
        return ans;
    }
}

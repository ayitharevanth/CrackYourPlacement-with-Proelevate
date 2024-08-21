class Solution {
    int min = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        for(int f[] : flights){
            map.computeIfAbsent(f[0],m->new HashMap<>()).put(f[1],f[2]);
        }
        boolean[] visited = new boolean[n];
        visited[src] = true;
        dfs(map,visited,0,src,dst,K+1);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private void dfs(Map<Integer,Map<Integer,Integer>> map,boolean[] visited,int val,int cur,int dst,int k){
        if(k<0) return;
        if(cur==dst){
            min = Math.min(min,val);
        }
        Map<Integer,Integer> next = map.getOrDefault(cur,null);
        if(next==null) return;
        for(Map.Entry<Integer,Integer> entry : next.entrySet()){
            if(visited[entry.getKey()]) continue;
            if(val+entry.getValue()>=min) continue;
            visited[entry.getKey()] = true;
            dfs(map,visited,val+entry.getValue(),entry.getKey(),dst,k-1);
            visited[entry.getKey()] = false;
        }
    }
}
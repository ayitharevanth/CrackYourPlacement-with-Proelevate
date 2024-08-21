class UnionFind{
    Map<String, String> root;
    Map<String, Integer> rank;
    int groups;
    UnionFind(int[][] stones) {
        root = new HashMap<>();
        rank = new HashMap<>();
        for(int a[]: stones) {
            groups++;
            String val = a[0]+" "+a[1];
            root.put(val, val);
            rank.put(val, 0);
        }
    }
    
    String find(String key) {
        if(root.get(key).equals(key)) {
            return key;
        }
        root.put(key, find(root.get(key)));
        return root.get(key);
    }
    
    void union(int[] a, int[] b) {
        String aKey = a[0] + " " + a[1];
        String bKey = b[0] + " " + b[1];
        String aRoot = find(aKey);
        String bRoot = find(bKey);
        if(!aRoot.equals(bRoot)) {
            int aRank = rank.get(aRoot);
            int bRank = rank.get(bRoot);
            if(aRank < bRank) {
                //make a's root to b's root
                root.put(aRoot, bRoot);   
            }
            else if(aRank > bRank) {
                root.put(bRoot, aRoot);      
            }
            else {
                root.put(bRoot, aRoot);
                rank.put(aRoot, aRank+1);
            }
            groups--;
        }
    }
    
    int getGroups() {
        return groups;
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer, List<int[]>> xAdj = new HashMap<>();
        Map<Integer, List<int[]>> yAdj = new HashMap<>();
        UnionFind uf = new UnionFind(stones);
        for(int i=0; i<stones.length; ++i) {
            int x = stones[i][0];
            int y = stones[i][1];
            List<int[]> xList = xAdj.getOrDefault(x, new ArrayList<int[]>());
            List<int[]> yList = yAdj.getOrDefault(y, new ArrayList<int[]>());
            xList.add(stones[i]);
            yList.add(stones[i]);
            xAdj.put(x, xList);
            yAdj.put(y, yList);
        }
        for(Map.Entry<Integer, List<int[]>> entry: xAdj.entrySet()) {
            List<int[]> list = entry.getValue();
            for(int i=1; i<list.size(); ++i) {
                uf.union(list.get(i-1), list.get(i));
            }
        }        
        for(Map.Entry<Integer, List<int[]>> entry: yAdj.entrySet()) {
            List<int[]> list = entry.getValue();
            for(int i=1; i<list.size(); ++i) {
                uf.union(list.get(i-1), list.get(i));
            }
        }
        
        return stones.length - uf.getGroups();
    
    }
}
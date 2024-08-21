class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // now with floyd soluiton, we basically find
        // dist[i][j], where dist[i][k] + distpk][j] < dist[i][j]
        //
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (int i = 0; i < edges.length; ++i) {
            dist[edges[i][1]][edges[i][0]] = dist[edges[i][0]][edges[i][1]] = edges[i][2];
        }

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    //if (dist[i][j] > (dist[i][k] + dist[k][j])
                    //    && (dist[k][j] != INF
                    //        && dist[i][k] != INF))
                    //    dist[i][j] = dist[i][k] + dist[k][j];

                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && (dist[i][j] > (dist[i][k] + dist[k][j])) ) {
                        dist[j][i] = dist[i][j] = (dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int max = Integer.MAX_VALUE;
        int node = -1;
        for (int i = 0; i < n; ++i) {
            int k = 0;
            for (int j = 0; j < n; ++j) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    ++k;
                }
            }
            if (k <= max) {
                node = i;
                max = k;
            }
        }
        return node;
    }
}
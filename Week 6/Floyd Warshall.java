// Back-end complete function template for JAVA

class Solution {
    public void shortest_distance(int[][] matrix) {
        // Initializing maximum integer value
        int INF = Integer.MAX_VALUE;
        // Getting the size of the matrix
        int n = matrix.length;

        // Replacing -1 with maximum integer value in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = INF;
            }
        }

        // Applying Floyd Warshall algorithm to find the shortest distances
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][k] < INF && matrix[k][j] < INF && matrix[i][k] + matrix[k][j] < INF)
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        // Replacing maximum integer value with -1 in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] >= INF)
                    matrix[i][j] = -1;
            }
        }
    }
}

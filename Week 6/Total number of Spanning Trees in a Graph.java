
class Solution {
    public static int determinantOfMatrix(ArrayList<ArrayList<Integer>> matrix) {
        int det = 0;
        if (matrix.size() == 1) return matrix.get(0).get(0);
        else if (matrix.size() == 2)
            return matrix.get(0).get(0) * matrix.get(1).get(1) - matrix.get(1).get(0) * matrix.get(0).get(1);
        else {
            for (int p = 0; p < matrix.get(0).size(); p++) {
                ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
                for (int i = 1; i < matrix.size(); i++) {
                    ArrayList<Integer> row = new ArrayList<>();
                    for (int j = 0; j < matrix.get(0).size(); j++) {
                        if (p != j) row.add(matrix.get(i).get(j));
                    }
                    if (row.size() > 0) temp.add(row);
                }
            det = det + (int) (matrix.get(0).get(p) * Math.pow(-1, p) * determinantOfMatrix(temp));
            }
            return det;
        }
    }

    public static int countSpanningTrees(int[][] matrix, int n, int m) {
        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            adjMatrix.add(row);
        }

        for (int[] edge : matrix) {
            adjMatrix.get(edge[0]).set(edge[1], 1);
            adjMatrix.get(edge[1]).set(edge[0], 1);
        }

        ArrayList<Integer> degree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (adjMatrix.get(i).get(j) == 1) {
                    count++;
                }
            }
            degree.add(count);
        }

        for (int i = 0; i < n; i++) {
            adjMatrix.get(i).set(i, degree.get(i));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && adjMatrix.get(i).get(j) == 1) {
                    adjMatrix.get(i).set(j, -1);
                }
            }
        }

        ArrayList<ArrayList<Integer>> submatrix = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 1; j < n; j++) {
                row.add(adjMatrix.get(i).get(j));
            }
            submatrix.add(row);
        }

        return determinantOfMatrix(submatrix);
    }
}

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int n = mat.length;
        // initializing two pointers for two corners.
        int a = 0;
        int b = n - 1;

        // we keep moving till the a<b.
        while (a < b) {
            if (mat[a][b] == 1)
                a++;
            else
                b--;
        }

        // checking if a is actually a celebrity or not.
        for (int i = 0; i < n; i++) {
            // if any person doesn't know a or a knows any person, we return -1.
            if ((i != a) && (mat[a][i] == 1 || mat[i][a] == 0)) return -1;
        }
        // if we reach here a is celebrity so we return a.
        return a;
    }
}

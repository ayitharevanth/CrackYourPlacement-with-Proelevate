class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        if(target == newColor){
            return image;
        }
        dfs(sr,sc,target,newColor,image);
        return image;
    }
    private void dfs(int row,int col,int target,int newColor,int[][] image){
        if(row < image.length && row >= 0 && col < image[0].length && col >= 0 && image[row][col] == target) {
            image[row][col] = newColor;
            dfs(row - 1, col, target, newColor, image);
            dfs(row, col - 1, target, newColor, image);
            dfs(row + 1, col, target, newColor, image);
            dfs(row, col + 1, target, newColor, image);
        }
    }
}

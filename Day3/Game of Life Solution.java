class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int prev [][] = new int [n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                prev[i][j]=board[i][j];
            }
        }
        int population_count [][] = new int [n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                int count = 0;
                if(i-1>=0&&j-1>=0&&i-1<n&&j-1<m)count+=board[i-1][j-1];
                if(i-1>=0&&j>=0&&i-1<n&&j<m)count+=board[i-1][j];
                if(i-1>=0&&j+1>=0&&i-1<n&&j+1<m)count+=board[i-1][j+1];
                if(i>=0&&j-1>=0&&i<n&&j-1<m)count+=board[i][j-1];
                if(i>=0&&j+1>=0&&i<n&&j+1<m)count+=board[i][j+1];
                if(i+1>=0&&j-1>=0&&i+1<n&&j-1<m)count+=board[i+1][j-1];
                if(i+1>=0&&j>=0&&i+1<n&&j<m)count+=board[i+1][j];
                if(i+1>=0&&j+1>=0&&i+1<n&&j+1<m)count+=board[i+1][j+1];
                population_count[i][j]=count;
            }
        }
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(prev[i][j]==1){
                    if(population_count[i][j]<2){
                        board[i][j]=0;
                    }
                    else if(population_count[i][j]>3){
                        board[i][j]=0;
                    }
                }
                else{
                   if(population_count[i][j]==3){
                        board[i][j]=1;
                    } 
                }
            }
        }
    }
}

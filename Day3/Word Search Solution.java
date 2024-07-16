class Solution {
    public boolean find(char[][] board, String word, int i,int j,int id){
        if(id==word.length()){
            return true;
        }
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || word.charAt(id)!= board[i][j] || board[i][j]== '$'){
            return false;
        }
        char temp=board[i][j];
        
        board[i][j]='$';
        if(find(board, word, i-1,j, id+1)
        ||find(board, word, i+1,j, id+1)
        ||find(board, word, i,j-1, id+1) 
        ||find(board, word, i,j+1, id+1))
        {return true; }

        board[i][j]=temp;

    return false;
}
    
    public boolean exist(char[][] board, String word) {
       int m=board.length;
        int n=board[0].length;
        
        for(int i=0 ; i<m ;i++){
            for(int j=0 ; j<n ;j++){
                if(board[i][j]== word.charAt(0) && find(board,word,i,j,0))
                return true;
            }
        }
        return false;
    }
}

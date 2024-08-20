class Solution {
    static int t[][]= new int [101][10001];
    public int superEggDrop(int e, int f) {
        for(int row[]: t)
            Arrays.fill(row, -1);
        return solve(e,f);
    }
    public int solve(int e, int f){
        if(f==1 || f==0)
            return f;
        if(e==1)
            return f;
        
        if(t[e][f] != -1)
            return t[e][f];
        int l=1, r= f;
        int min= Integer.MAX_VALUE;
        
        while(l<=r)
        {
            int k = (l+r)/2; //here k is the middle floor
            
                int down = solve(e-1, k-1); 
         
                int up = solve(e, f-k);
            
            int temp=1+Math.max(down,up);
           
            
            if(down < up)
                l= k+1;
            else
                r= k-1;
        
             min = Math.min(temp, min); //min because we have to find the min no. of moves   
            }
        
        return t[e][f]=min;  
    }
}

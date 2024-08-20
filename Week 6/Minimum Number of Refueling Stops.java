class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        //initial start fuel
        int max_reach=startFuel;
        //pq to store max fuel in descending order
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b) -> b[1]-a[1]);
        int count=0;
        int index=0;
        
        while(max_reach<target){
            //1st condition to avoid index out of bound exception
            //stations[index][0] is the location, while location is < max_reach dist
            while(index<stations.length && stations[index][0]<=max_reach){
                
                //store fuel in pq
                pq.add(stations[index]);
                index++;
            }
            
            if(pq.isEmpty())  
                return -1;
            
            max_reach +=pq.remove()[1];  //add top fuel value & remove if from pq
            count++;
            
        }
        return count;
    }
}

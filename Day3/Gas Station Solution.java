class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, n = gas.length;
        int gasInTank = 0, start = 0;
        for(int i=0;i<n;i++) {
            gasInTank += gas[i]-cost[i];
            sum += gas[i]-cost[i];
            if(gasInTank < 0) {
                start = i+1;
                gasInTank = 0;
            }
        }
        
        return sum >= 0 ? start : -1;
    }
}

//brute force
// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         for(int i=0;i<n;i++) {
//             int tank = 0;
//             boolean roundTrip = true;
//                 for(int j=i;j<n+i+1;j++) { 
//                     tank += gas[j%n]-cost[j%n];
//                     if(tank < 0) {
//                         roundTrip = false;
//                         break;
//                     }
//                 }
//             if(roundTrip)return i;
//         }
//         return -1;
//     }
// }


class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
    	int sum = 0, n = petrol.length;
            int petrolInTank = 0, start = 0;
            for(int i=0;i<n;i++) {
                petrolInTank += petrol[i]-distance[i];
                sum += petrol[i]-distance[i];
                // if we are not able to reach next station from i, 
                if(petrolInTank < 0) {
                    start = i+1;
                    petrolInTank = 0;
                }
            }
            
        return sum >= 0 ? start : -1;
    }
}

class Solution
{
    static int segregateArr (int arr[], int n) 
    { 
    	int j = 0, i; 
    	for(i = 0; i < n; i++) 
    	{ 
    	    if(arr[i] <= 0) 
    	    { 
    	        //changing the position of negative numbers and 0.
    	        int temp=arr[i];
    	        arr[i]=arr[j];
    	        arr[j]=temp;
    	        //incrementing count of non-positive integers.
    	        j++; 
    		} 
    	}
    	return j; 
    } 
    static int findMissingPositive(int arr[],int st, int end)
    {
        for(int i=st; i<end; i++) 
        {
    	    if(Math.abs(arr[i])+st - 1 < end && arr[ Math.abs(arr[i])+st - 1] > 0) 
    	    arr[ Math.abs(arr[i])+st - 1] = -1*arr[ Math.abs(arr[i])+st - 1]; 
        } 
        
        for(int i=st; i<end; i++)
        {
            if (arr[i] > 0)
            {
    	        return i-st+1; 
            }
        }
        return end-st+1; 
    } 
    static int missingNumber(int arr[], int size) 
    { 
        int shift = segregateArr(arr, size); 
        
        return findMissingPositive(arr,shift, size); 
    }
    
    
}

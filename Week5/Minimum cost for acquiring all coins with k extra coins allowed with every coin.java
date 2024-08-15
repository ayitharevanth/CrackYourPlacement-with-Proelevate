import java .io.*; 
import java.util.Arrays; 
class Solution { 
	static void preprocess(int []coin, int n) 
	{ 
		
		// sort the coins value 
		Arrays.sort(coin); 
	
		// Maintain prefix sum array 
		for (int i = 1; i <= n - 1; i++) 
			coin[i] += coin[i - 1]; 
	} 
	static int minCost(int []coin, int n, int k) 
	{ 
		
		// calculate no. of coins needed 
		int coins_needed =(int) Math.ceil(1.0
								* n / (k + 1)); 
	
		// return sum of from prefix array 
		return coin[coins_needed - 1]; 
	} 
	
	// Driver Code 
	static public void main (String[] args) 
	{ 
		int []coin = {8, 5, 3, 10, 2, 1, 15, 25}; 
		int n = coin.length; 
		
		preprocess(coin, n); 
		
		int k = 3; 
		System.out.println(minCost(coin, n, k)); 
		
		k = 7; 
		System.out.println( minCost(coin, n, k)); 
	} 
} 

// This code is contributed by anuj_67. 

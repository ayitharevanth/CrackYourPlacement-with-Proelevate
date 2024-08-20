

import java.util.*;

public class Main {
	static final int MAX = 1000;
	static int cost[][] = new int[MAX][MAX];

	// Helper function to calculate the sum of frequencies
	// from index i to j
	static int Sum(int freq[], int i, int j)
	{
		int s = 0;
		for (int k = i; k <= j; k++)
			s += freq[k];
		return s;
	}

	// Recursive function to find the optimal cost of a BST
	// using memoization
	static int optCost_memoized(int freq[], int i, int j)
	{
		if (i < 0 || j < 0)
			return 0;
		// Reuse cost already calculated for the
		// subproblems. Since we initialize cost matrix with
		// 0 and frequency for a tree of one node, it can be
		// used as a stop condition
		if (cost[i][j] != 0)
			return cost[i][j];

		// Get sum of freq[i], freq[i+1], ... freq[j]
		int fsum = Sum(freq, i, j);

		// Initialize minimum value
		int Min = Integer.MAX_VALUE;

		// One by one consider all elements as
		// root and recursively find cost of
		// the BST, compare the cost with min
		// and update min if needed
		for (int r = i; r <= j; r++) {
			int c = optCost_memoized(freq, i, r - 1)
					+ optCost_memoized(freq, r + 1, j)
					+ fsum;
			if (c < Min) {
				Min = c;
				// replace cost with new optimal calc
				cost[i][j] = c;
			}
		}

		// Return minimum value
		return cost[i][j];
	}

	// Main function to calculate the minimum cost of a BST
	static int optimalSearchTree(int keys[], int freq[],
								int n)
	{
		// Here array keys[] is assumed to be
		// sorted in increasing order. If keys[]
		// is not sorted, then add code to sort
		// keys, and rearrange freq[] accordingly.
		return optCost_memoized(freq, 0, n - 1);
	}
}

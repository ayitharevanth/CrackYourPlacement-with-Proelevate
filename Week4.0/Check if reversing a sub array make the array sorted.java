class Solution { 

// Return true, if reversing the subarray will 
// sort the array, else return false. 
	static boolean checkReverse(int arr[], int n) { 
		// Copying the array. 
		int temp[] = new int[n]; 
		for (int i = 0; i < n; i++) { 
			temp[i] = arr[i]; 
		} 

		// Sort the copied array. 
		Arrays.sort(temp); 

		// Finding the first mismatch. 
		int front; 
		for (front = 0; front < n; front++) { 
			if (temp[front] != arr[front]) { 
				break; 
			} 
		} 

		// Finding the last mismatch. 
		int back; 
		for (back = n - 1; back >= 0; back--) { 
			if (temp[back] != arr[back]) { 
				break; 
			} 
		} 

		// If whole array is sorted 
		if (front >= back) { 
			return true; 
		} 

		// Checking subarray is decreasing or not. 
		do { 
			front++; 
			if (arr[front - 1] < arr[front]) { 
				return false; 
			} 
		} while (front != back); 

		return true; 
	} 

// Driver Program 
	public static void main(String[] args) { 

		int arr[] = {1, 2, 5, 4, 3}; 
		int n = arr.length; 

		if (checkReverse(arr, n)) { 
			System.out.print("Yes"); 
		} else { 
			System.out.print("No"); 
		} 
	} 

} 

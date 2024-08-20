
import java.io.*;
import java.util.*;

class Solution {
	public static boolean subArrWithSumZero(int arr[], int start, int end, int n)
	{
		// to store cumulative sum
		int sum[] = new int[n];

		// map to store the indexes of sum
		HashMap<Integer, Integer> um
			= new HashMap<Integer, Integer>();

		// build up the cumulative sum[] array
		sum[0] = arr[0];
		for (int i = 1; i < n; i++)
			sum[i] = sum[i - 1] + arr[i];

		// to store the maximum length subarray
		// with sum equal to 0
		int maxLen = 0;

		// traverse to the sum[] array
		for (int i = 0; i < n; i++) {
			// if true, then there is a subarray
			// with sum equal to 0 from the
			// beginning up to index 'i'
			if (sum[i] == 0) {
				// update the required variables
				start = 0;
				end = i;
				maxLen = (i + 1);
			}

			// else if true, then sum[i] has not
			// seen before in 'um'
			else if (um.get(sum[i]) == null)
				um.put(sum[i], i);

			// sum[i] has been seen before in the
			// unordered_map 'um'
			else {
				// if previous subarray length is smaller
				// than the current subarray length, then
				// update the required variables
				if (maxLen < (i - um.get(sum[i]))) {
					maxLen = i - um.get(sum[i]);
					start = i - um.get(sum[i]) + 1;
					end = i;
				}
			}
		}

		// if true, then there is no
		// subarray with sum equal to 0
		if (maxLen == 0)
			return false;

		// else return true
		return true;
	}

	// function to find largest area rectangular
	// submatrix with equal number of 1's and 0's
	public static void
	maxAreaRectWithSumZero(int mat[][], int row, int col)
	{
		// to store intermediate values
		int temp[] = new int[row];
		int startRow = 0, endRow = 0;

		// to store the final outputs
		int finalLeft = -1, finalRight = -1, finalTop = -1,
			finalBottom = -1;
		int maxArea = 0;

		// Set the left column
		for (int left = 0; left < col; left++) {
			// Set the right column for the left column
			// set by outer loop
			for (int right = left; right < col; right++) {
				// Calculate sum between current left
				// and right for every row 'i'
				// consider value '1' as '1' and
				// value '0' as '-1'
				for (int i = 0; i < row; i++)
					temp[i]
						+= (mat[i][right] != 0) ? 1 : -1;

			
				if (subArrWithSumZero(temp, startRow,
									endRow, row)) {
					int area = (right - left + 1)
							* (endRow - startRow + 1);

					// Compare current 'area' with previous
					// area and accordingly update final
					// values
					if (maxArea < area) {
						finalTop = startRow;
						finalBottom = endRow;
						finalLeft = left;
						finalRight = right;
						maxArea = area;
					}
				}
			}
		}

		// if true then there is no rectangular submatrix
		// with equal number of 1's and 0's
		if (maxArea == 0)
			System.out.print(
				"No such rectangular submatrix exists:");

		// displaying the top left and bottom right
		// boundaries with the area of the rectangular
		// submatrix
		else {
			System.out.println("(Top, Left): "
							+ "(" + finalTop + ", "
							+ finalLeft + ")");

			System.out.println("(Bottom, Right): "
							+ "(" + finalBottom + ", "
							+ finalRight + ")");

			System.out.println("Area: " + maxArea
							+ " sq.units");
		}
	}

}

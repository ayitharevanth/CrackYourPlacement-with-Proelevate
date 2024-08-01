import java.util.Arrays;
 
class Solution{
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 8, 10, 10, 12, 19 };
        int n = arr.length;
        int x = 8;
 
        // Use binary search to find the index of the
        // ceiling element
        int idx = Arrays.binarySearch(arr, x);
        if (idx < 0) {
            idx = Math.abs(idx) - 1;
        }
 
        // Checking if idx is valid
        if (idx == n) {
            System.out.println(
                "Ceiling Element does not exist");
        }
        else {
            System.out.println("Ceiling Element of " + x
                               + " is " + arr[idx]);
        }
    }
}
 

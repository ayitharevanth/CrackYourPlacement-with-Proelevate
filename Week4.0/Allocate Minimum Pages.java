class Solution {
    public static long findPages(int n, int[] arr, int m) {
        if (m > n) {
            return -1; // Not possible
        }

        int maxPage = Integer.MIN_VALUE;
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            maxPage = Math.max(maxPage, arr[i]);
            totalSum += arr[i];
        }

        long low = maxPage, high = totalSum;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isFeasible(arr, mid, m)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean isFeasible(int[] arr, long maxPages, int m) {
        int students = 1, currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (currSum + arr[i] > maxPages) {
                students++;
                currSum = arr[i];
                if (students > m) {
                    return false;
                }
            } else {
                currSum += arr[i];
            }
        }
        return true;
    }
}

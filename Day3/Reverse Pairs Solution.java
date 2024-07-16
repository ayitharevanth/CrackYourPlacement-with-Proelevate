class Solution {
    static int merge(int nums[], int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;

        while (left <= mid && right <= high) {
            long numLeft = nums[left];
            long numRight = nums[right];
            numRight += nums[right];
            if (numLeft > numRight) {
                System.out.println(numLeft + " " + nums[right]);
                count += (mid - left + 1);
                right++;
            } else {
                left++;
            }
        }

        left = low;
        right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right])
                list.add(nums[left++]);
            else
                list.add(nums[right++]);
        }

        while (left <= mid)
            list.add(nums[left++]);

        while (right <= high)
            list.add(nums[right++]);

        for (int i = low; i <= high; i++)
            nums[i] = list.get(i - low);

        return count;
    }

    static int mergeSort(int nums[], int low, int high) {
        int count = 0;

        if (low < high) {
            int mid = (low + high) / 2;
            count += mergeSort(nums, low, mid);
            count += mergeSort(nums, mid + 1, high);
            count += merge(nums, low, mid, high);
        }

        return count;
    }

    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }
}

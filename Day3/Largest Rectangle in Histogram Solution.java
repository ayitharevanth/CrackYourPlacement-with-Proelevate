class Solution {
        public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } 
            else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
// public static int largestRectangleArea(int[] height) {
//     if (height == null || height.length == 0) {
//         return 0;
//     }
//     int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
//     int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
//     lessFromRight[height.length - 1] = height.length;
//     lessFromLeft[0] = -1;

//     for (int i = 1; i < height.length; i++) {
//         int p = i - 1;

//         while (p >= 0 && height[p] >= height[i]) {
//             p = lessFromLeft[p];
//         }
//         lessFromLeft[i] = p;
//     }

//     for (int i = height.length - 2; i >= 0; i--) {
//         int p = i + 1;

//         while (p < height.length && height[p] >= height[i]) {
//             p = lessFromRight[p];
//         }
//         lessFromRight[i] = p;
//     }

//     int maxArea = 0;
//     for (int i = 0; i < height.length; i++) {
//         maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
//     }

//     return maxArea;
// }

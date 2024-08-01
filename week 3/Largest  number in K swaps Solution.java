
class Solution {
    static String max_str = "";

    public static String findMaximumNum(String str, int k) {
        max_str = str;
        findMaximumNumUtil(str.toCharArray(), k, 0);
        return max_str;
    }

    static void findMaximumNumUtil(char[] str, int k, int index) {
        if (k == 0)
            return;

        for (int i = index; i < str.length - 1; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[j] > str[i]) {
                    swap(str, i, j);
                    if (String.valueOf(str).compareTo(max_str) > 0)
                        max_str = String.valueOf(str);
                    findMaximumNumUtil(str, k - 1, i + 1);
                    swap(str, i, j); // Backtrack
                }
            }
        }
    }

    static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}

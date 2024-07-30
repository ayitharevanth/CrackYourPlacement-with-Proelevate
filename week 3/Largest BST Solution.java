class Solution {

    static class Info {
        int size;
        int max, min;
        boolean isBST;

        Info(int size, int max, int min, boolean isBST) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    static int largestBst(Node root) {
        return largestBstUtil(root).size;
    }

    static Info largestBstUtil(Node root) {
        if (root == null) {
            return new Info(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }

        Info left = largestBstUtil(root.left);
        Info right = largestBstUtil(root.right);

        Info curr = new Info(0, 0, 0, false);

        if (left.isBST && right.isBST && left.max < root.data && right.min > root.data) {
            curr.size = 1 + left.size + right.size;
            curr.max = Math.max(root.data, right.max);
            curr.min = Math.min(root.data, left.min);
            curr.isBST = true;
        } else {
            curr.size = Math.max(left.size, right.size);
            curr.max = Math.max(root.data, Math.max(left.max, right.max));
            curr.min = Math.min(root.data, Math.min(left.min, right.min));
        }

        return curr;
    }
}

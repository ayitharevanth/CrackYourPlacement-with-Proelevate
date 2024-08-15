class NumArray {
    private SegmentTree root; // Root of the segment tree

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            root = buildSegmentTree(nums, 0, nums.length - 1); // Build the segment tree
        }
    }

    // Class representing a segment tree node
    class SegmentTree {
        SegmentTree left, right;
        int start, end, sum;

        SegmentTree(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // Function to build the segment tree
    private SegmentTree buildSegmentTree(int[] nums, int start, int end) {
        SegmentTree node = new SegmentTree(start, end);
        if (start == end) {
            node.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            node.left = buildSegmentTree(nums, start, mid);
            node.right = buildSegmentTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    // Function to update an element in the segment tree
    public void update(int index, int val) {
        update(root, index, val);
    }

    private void update(SegmentTree node, int index, int val) {
        if (node.start == node.end) {
            node.sum = val;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            if (index <= mid) {
                update(node.left, index, val);
            } else {
                update(node.right, index, val);
            }
            node.sum = node.left.sum + node.right.sum;
        }
    }

    // Function to get the sum of elements in the given range
    public int sumRange(int left, int right) {
        return sumRange(root, left, right);
    }

    private int sumRange(SegmentTree node, int start, int end) {
        if (node.start == start && node.end == end) {
            return node.sum;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if (end <= mid) {
            return sumRange(node.left, start, end);
        } else if (start > mid) {
            return sumRange(node.right, start, end);
        } else {
            return sumRange(node.left, start, mid) + sumRange(node.right, mid + 1, end);
        }
    }
}

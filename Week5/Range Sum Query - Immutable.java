class NumArray {
    Node root;
    static class Node{
        int start;
        int end;
        int sum;
        Node left;
        Node right;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public NumArray(int[] nums) {
        this.root = helper(nums,0,nums.length-1);
    }
    private Node helper(int[] nums, int start, int end){
        if(start == end){
            Node tem = new Node(start,end);
            tem.sum = nums[start];
            return tem;
        }
        Node tem = new Node(start,end);
        int mid = start + (end-start)/2;
        tem.left = helper(nums,start,mid);
        tem.right = helper(nums,mid+1,end);
        tem.sum = tem.left.sum + tem.right.sum;
        return tem;
    }
    
    public int sumRange(int left, int right) {
        return this.sumhelper(this.root, left, right);
    }
    private int sumhelper(Node root, int left, int right){
        if(root.start>= left && root.end <= right) return root.sum;
        else if(root.end < left || root.start > right) return 0;
        else{
            return this.sumhelper(root.left, left, right) + this.sumhelper(root.right, left, right);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

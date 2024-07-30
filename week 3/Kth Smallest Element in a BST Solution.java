class Solution {
//region precoditions
    class TreeNodeWithSize {
        int val;
        int size;
        TreeNodeWithSize left;
        TreeNodeWithSize right;
        TreeNodeWithSize(int val) { this.val = val; }
    }

    class OrderStatisticsTree {
        TreeNodeWithSize root;

       public int size(TreeNodeWithSize node){
            if(node == null){
                return 0;
            }
            return node.size;
        }

        public void put(TreeNodeWithSize node){
            root = put(root, node);
        }

        private TreeNodeWithSize put(TreeNodeWithSize x, TreeNodeWithSize node){
            if(x == null) {
                node.size = 1;
                return node;
            }

            if(node.val < x.val){
                x.left = put(x.left, node);
            }else if(node.val > x.val){
                x.right = put(x.right, node);
            }else{
                x.val = node.val; //redundant, but leaving it here for display purposes
            }
            x.size = 1 + size(x.left) + size(x.right);
            return x;
        }

        public int findByRank(int rank){
            return findByRank(root, rank);
        }

        private int findByRank(TreeNodeWithSize root, int rank){
            if(root == null) throw new IllegalArgumentException("empty tree");

            int leftSize = 0;
            if(root.left != null){
                leftSize = root.left.size;
            }

            if(rank <= leftSize){
                return findByRank(root.left, rank);
            }else if(rank > leftSize + 1){
                return findByRank(root.right, rank - leftSize - 1);
            }
            return root.val;
        }
    }
//endregion	

//region problem solving
    OrderStatisticsTree bst = new OrderStatisticsTree();
    public int kthSmallest(TreeNode root, int k) {
        buildOrderStatisticsTree(root);
        return bst.findByRank(k);
    }
//endregion	

    public void buildOrderStatisticsTree(TreeNode node) {
        if (node == null){
            return;
        }

        bst.put(new TreeNodeWithSize(node.val));
        buildOrderStatisticsTree(node.left);
        buildOrderStatisticsTree(node.right);
    }
}

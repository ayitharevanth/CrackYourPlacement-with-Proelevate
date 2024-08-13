class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        if (root == null) return;

        // If key is present at root
        if (root.data == key) {
            // the maximum value in left subtree is predecessor
            if (root.left != null) {
                Node tmp = root.left;
                while (tmp.right != null) tmp = tmp.right;
                pre[0] = tmp;
            }

            // the minimum value in right subtree is successor
            if (root.right != null) {
                Node tmp = root.right;
                while (tmp.left != null) tmp = tmp.left;
                suc[0] = tmp;
            }
            return;
        }

        // If key is smaller than root's key, go to left subtree
        if (root.data > key) {
            suc[0] = root;
            findPreSuc(root.left, pre, suc, key);
        } else // go to right subtree
        {
            pre[0] = root;
            findPreSuc(root.right, pre, suc, key);
        }
    }
}

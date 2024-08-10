class Solution {
    // Function to merge two linked lists in sorted order
    Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;
        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        return result;
    }

    // Function to flatten a linked list
    Node flatten(Node root) {
        if (root == null || root.next == null) return root;
        return merge(root, flatten(root.next));
    }
}

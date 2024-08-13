/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private TreeNode first;   // The first node that violates the BST property
    private TreeNode middle;  // The middle node that violates the BST property
    private TreeNode last;    // The last node that violates the BST property
    private TreeNode prev;    // The previous node during the inorder traversal

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }

        // Traverse the left subtree
        inorder(root.left);

        // Check if the current node violates the BST property
        if(prev != null && (root.val < prev.val)){
            // If this is the first time we've found a violation,
            // set first and middle to the nodes that violate the BST property
            if(first == null){
                first = prev;
                middle = root;
            }
            // If we've already found a violation, set last to the node that violates the BST property
            else{
                last = root;
            }
        }
        // Set prev to the current node, so that we can compare it to the next node
        prev = root;

        // Traverse the right subtree
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        // Initialize the variables
        first = middle = last = null;
        // Initialize prev to a node with the minimum possible value, so that it will not violate the BST property
        prev = new TreeNode(Integer.MIN_VALUE);

        // Perform an inorder traversal of the tree
        inorder(root);

        // Swap the values of the nodes that violate the BST property, if any
        if(first != null && last != null){
            // If there are two nodes that violate the BST property,
            // and they are not adjacent to each other, swap the values of the first and last nodes
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if(first != null && middle != null){
            // If there are two nodes that violate the BST property,
            // and they are adjacent to each other, swap the values of the first and middle nodes
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
}

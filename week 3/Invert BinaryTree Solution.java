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
class Solution 
{
    public TreeNode invertTree(TreeNode root)
    {
       
        if(root == null)
            return null;
        TreeNode left= invertTree(root.left);//LEFT subtree
        TreeNode right= invertTree(root.right);//right child subtree
        
        //ROOT
        //just swapping the pointers, to just alternate the node 
        root.left= right;
        root.right= left;
        
        return root;
    }
}

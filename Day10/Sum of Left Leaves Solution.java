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
    int count = 0 ;
    public int sumOfLeftLeaves(TreeNode root) {
        sum(root) ;
        return count ;
    
    }
    private void sum(TreeNode node){
        if(node != null){
            if(node.left != null){
                TreeNode temp = node.left ;
                if(temp.left == null && temp.right == null){
                    count += node.left.val ;
                }
            }
            sum(node.left) ;
            sum(node.right) ;
        }

    }
}

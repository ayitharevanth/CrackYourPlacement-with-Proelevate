
class Solution
{
    public boolean hasPathSum(TreeNode root, int targetSum)//we always try to approach the zero ----0++++ from any half left or right, like taking limit//if zero found at leaf then true else false
    {
        if(root == null)
            return false;//base case when the selected path is not the desired path //we return false and check in next half of the subtree//base case for terminnation of the recursion 
        else if(root.left == null && root.right == null && targetSum - root.val == 0)//we have faith in tree that it can find the node if present where the value nutralizes each other at 0
            return true;//only the case when we are returning true 
        else
            return hasPathSum(root.left,targetSum - root.val)||hasPathSum(root.right,targetSum - root.val);//if present in left is good otherwiswe we are searching in right subtree recursively //all permutation in ways are done by recursion and not our tension 
    }
}//Please do Upvote, It helps a lot

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
     int postpreindex=0;
 public  TreeNode constructFromPrePost(int[] pre, int[] post) {
			 
			 HashMap<Integer,Integer> map=new HashMap<>();
		        for(int i=0;i<post.length;i++) {
		        	map.put(post[i], i);
		        }
		       return helper(pre,post,map,0,post.length-1);
		    }


	private  TreeNode helper(int[] preorder, int[] postorder,HashMap<Integer, Integer> map, int start, int end) {
			if(start>end) {
				return null;
			}
			TreeNode root=new TreeNode(preorder[postpreindex++]);
			
			if(start==end) {
				return root;
			}
			
			int index=map.get(preorder[postpreindex]);
			
			root.left=helper(preorder,postorder,map,start,index);
			root.right=helper(preorder,postorder,map,index+1,end-1);
			return root;
		}
}

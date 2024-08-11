class Solution 
{
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node node, int low, int high) 
    {  
        if(node == null) 
            return 0; 
            
        //if data at currentnode is equal to lower and upper range, we return 1.
    	if (node.data == high && node.data == low)
    		return 1;
  
        //if data at current node is within range then we include it in count 
	    //and call function recursively for its left and right children.
        if(node.data >= low && node.data <= high) 
            return 1 + this.getCount(node.left, low, high)+ 
                this.getCount(node.right, low, high); 
                  
        //else if data at current node is smaller than lower range then
	    //we call function recursively only for right child.
        else if(node.data < low) 
            return this.getCount(node.right, low, high); 
          
        //else we call function recursively only for left child.
        else
            return this.getCount(node.left, low, high);      
    } 
}

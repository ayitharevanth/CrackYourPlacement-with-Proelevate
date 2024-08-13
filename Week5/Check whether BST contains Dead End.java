class Solution
{
     public static boolean isDeadEnd(Node root) {

        int minimum = 1;
        int maximum = Integer.MAX_VALUE;
        return isDeadEndUtil(root, minimum, maximum);

    }
    // Method to check if there is a dead end in the binary tree
     public static boolean isDeadEndUtil(Node root, int minimum, int maximum) {
    
        // If the root is null, return false
          if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {

            if (minimum == maximum) {
                return true;
            }
            return false;
        }

        return isDeadEndUtil(root.left, minimum, Math.min(root.data - 1, maximum))
                || isDeadEndUtil(root.right, Math.max(root.data + 1, minimum), maximum);
    }

}

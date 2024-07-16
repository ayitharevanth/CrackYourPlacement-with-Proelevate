
//User function Template for Java

//Back-end complete function Template for Java

class Solution {
    
    // Helper function to generate unique permutations
    public static void generate(ArrayList<Integer> num, int start, ArrayList<ArrayList<Integer> > result, HashSet<ArrayList<Integer>> h) {
        
        // Base case: when start reaches the last index of the array
        if (start == num.size() - 1) {
            // Check if the permutation is already generated
            if(h.contains(num))
                return;
            
            // Create a new list with the current permutation
            ArrayList<Integer> perm = new ArrayList<>(num);
            
            // Add the permutation to the set and result list
            h.add(perm);
            result.add(perm);
            return;
        } 
        
        Integer a, b;
        
        // Generate permutations by swapping elements starting from the given start index
        for (int i = start; i < num.size(); i++) {
            // Swap the elements at start and i positions
            a = num.get(start);
            b = num.get(i);
            num.set(start, b);
            num.set(i, a);
            
            // Recursive call to generate permutations for the next index
            generate(num, start + 1, result, h);
            
            // Undo the swap to restore the original order for the next iteration
            num.set(start, a);
            num.set(i, b);
        }
    }
    
    // Main function to generate unique permutations
    public static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr ,int n) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        
        // If the input array is empty, return an empty list
        if (arr.size() == 0)
            return result;
        
        // Generate unique permutations and store them in the result list
        generate(arr, 0, result, new HashSet<>());
        
        // Sort the result list based on element values and length
        Collections.sort(result, (ArrayList<Integer> a, ArrayList<Integer> b) -> {
            int i = 0, l = Math.min(a.size(), b.size());
            
            while(i < l) {
                // Compare each element in the lists
                if(a.get(i).compareTo(b.get(i)) != 0)
                    return a.get(i).compareTo(b.get(i));
                i++;
            }
            
            // If the elements are equal, compare the lengths
            return a.size() - b.size();
        });
        
        // Return the sorted list of unique permutations
        return result;
    }
}

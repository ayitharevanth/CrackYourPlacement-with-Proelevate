
class Solution {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        // Create an array to store the color of each vertex
        int[] color = new int[V];
        // Initialize all colors to -1
        Arrays.fill(color, -1);

        // Create a queue for BFS traversal
        Queue<Integer> q = new LinkedList<>();

        // Initialize a flag to track if the graph is bipartite
        boolean isBipartite = true;

        // Traverse through all vertices
        for (int i = 0; i < V; i++) {
            // If the current vertex is not visited yet
            if (color[i] == -1) {
                // Add the vertex to the queue
                q.add(i);
                // Set its color to 0 (assuming it is part of set A)
                color[i] = 0;
                // Perform BFS traversal
                while (!q.isEmpty()) {
                    int u = q.poll();
                    // Traverse through all adjacent vertices
                    for (Integer v : adj.get(u)) {
                        // If the current vertex v is not visited yet
                        if (color[v] == -1) {
                            // Set its color to the opposite color of its parent vertex
                            color[v] = color[u] ^ 1;
                            // Add the vertex to the queue for further traversal
                            q.add(v);
                        } else {
                            isBipartite = isBipartite & (color[u] != color[v]);
                        }
                    }
                }
            }
        }
        // Return the result whether the graph is bipartite or not
        return isBipartite;
    }
}
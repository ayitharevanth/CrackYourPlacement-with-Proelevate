//Back-end complete function Template for Java

class Solution
{
    //Function that creates transpose of the adjacency list.
    public ArrayList<ArrayList<Integer>> getTranspose(ArrayList<ArrayList<Integer>> graph, int N)
    {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < N; i++)
            g.add(i, new ArrayList<Integer>());
        for (int v = 0; v < N; v++)
            for (int i = 0; i < graph.get(v).size(); i++)
                g.get(graph.get(v).get(i)).add(v);
        return g;
    }
    
    public void DFS(ArrayList<ArrayList<Integer>> graph, int v, boolean[] visited, List<Integer> comp) 
    {
        //marking the current node as visited.
        visited[v] = true;
        
        //iterating over adjacent vertices and calling function 
        //recursively if any adjacent vertex is not visited.
        for (int i = 0; i < graph.get(v).size(); i++)
            if (!visited[graph.get(v).get(i)])
                DFS(graph, graph.get(v).get(i), visited, comp);
        
        //pushing vertex into the list.
        comp.add(v);
    }
    public List<Integer> fillOrder(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int N) 
    {  
        List<Integer> order = new ArrayList<Integer>();
        for (int i = 0; i < N; i++)
            if (!visited[i])
                DFS(graph, i, visited, order);
        return order;
    }
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //using boolean list to mark visited nodes and currently 
        //marking all the nodes as false.
        boolean[] visited = new boolean[V];
        
        //filling vertices in stack according to their finishing times.
        List<Integer> order = fillOrder(adj, visited, V);
        
        //creating transpose of adjacency list.
        ArrayList<ArrayList<Integer>> reverseGraph = getTranspose(adj, V);        
        visited = new boolean[V];
        Collections.reverse(order);
        
        List<List<Integer>> SCC = new ArrayList<>();
        for (int i = 0; i < order.size(); i++)
        {
            int v = order.get(i);
            //if vertex is not visited, we call dfs function and add 
            //the strongly connected component in list.
            if (!visited[v]) 
            {
                List<Integer> comp = new ArrayList<>();
                DFS(reverseGraph, v, visited, comp);
                SCC.add(comp);
            }
        }
        //returning the number of strongly connected components.
        return SCC.size();
    }
}

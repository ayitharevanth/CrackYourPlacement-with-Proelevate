class Solution {
    class Node {
		private int row;
		private int col;
		private int height;

		Node(int row, int col, int height) {
			this.row = row;
			this.col = col;
			this.height = height;
		}
	}

	public int dijkstra(int graph[][]) {
		boolean[][] visited = new boolean[graph.length][graph[0].length];
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>((v1, v2) -> v1.height - v2.height);
		priorityQueue.add(new Node(0, 0, graph[0][0]));
		visited[0][0] = true;
		int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		int minHeight = 0;
		while (!priorityQueue.isEmpty()) {
			Node node = priorityQueue.poll();
			if (node.row == graph.length - 1 && node.col == graph[0].length - 1) {
				minHeight = node.height;
				break;
			}
			for (int[] next : direction) {
				int nextRow = node.row + next[0];
				int nextCol = node.col + next[1];
				if (nextRow < 0 || nextRow == graph.length || nextCol < 0 || nextCol == graph.length
						|| visited[nextRow][nextCol]) {
					continue;
				}
				visited[nextRow][nextCol] = true;
				priorityQueue.add(new Node(nextRow, nextCol, Math.max(node.height, graph[nextRow][nextCol])));
			}
		}
		return minHeight;
	}
    public int swimInWater(int[][] grid) {
        return dijkstra(grid);
    }
}

package graph;

import java.util.ArrayList;

public class DFS {

	private static void recDFS(ArrayList<Integer> res, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s) {

		visited[s] = true;
		res.add(s);

		for (int b : adj.get(s)) {
			if (!visited[b]) {
				recDFS(res, adj, visited, b);
			}
		}
	}

	private static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> res = new ArrayList<>();
		int s = 0;
		boolean[] visited = new boolean[adj.size()];
		recDFS(res, adj, visited, 0);
		return res;
	}

	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int s, int t) {
		adj.get(s).add(t);
		adj.get(t).add(s);
	}

	public static void main(String[] args) {
		int V = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		// Initialize adjacency list
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		// Add edges
		int[][] edges = { { 1, 2 }, { 1, 0 }, { 2, 0 }, { 2, 3 }, { 2, 4 } };
		for (int[] e : edges) {
			addEdge(adj, e[0], e[1]);
		}

		// Perform DFS starting from vertex 0
		ArrayList<Integer> res = dfs(adj);

		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}
	}
}
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	private static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList();
        int s = 0; 
        boolean[] visited = new boolean[adj.size()];
        q.add(s);
        visited[s] = true;
        
        while(!q.isEmpty()) {
        	int a = q.poll();
        	res.add(a);
        	
        	for(int b : adj.get(a)) {
        		if(!visited[b]) {
        			q.add(b);
        			visited[b] = true;
        		}
        	}
        }
		return res;

	}
	public static void main(String[] args) {
		 ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
	        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));       
	        adj.add(new ArrayList<>(Arrays.asList(0, 4)));       
	        adj.add(new ArrayList<>(Arrays.asList(1,4)));          
	        adj.add(new ArrayList<>(Arrays.asList(2,3)));          
	        
	        
	        ArrayList<Integer> ans = bfs(adj);
	        for (int i : ans) {
	            System.out.print(i + " ");
	        }

	}

}

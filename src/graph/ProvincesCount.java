package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ProvincesCount {

	public int findCircleNum(int[][] isConnected) {
		int n = isConnected.length;
		int[] visited = new int[n];
		int provinces = 0;
		for(int i =0;i<n;i++) {
			if(visited[i] == 0) {
				provinces++;
				dfs(i, visited, isConnected);
			}
		}
		return provinces;
	}

	private void dfs(int i, int[] visited, int[][] isConnected){ 
		visited[i] =1;
		for(int j =0; j<isConnected.length;j++) {
			if(isConnected[i][j] == 1 && visited[j] == 0) 
				dfs(j, visited, isConnected);
			
		}
	}

	public static void main(String[] args) {
		ProvincesCount p = new ProvincesCount();
		int res = p.findCircleNum(
				new int[][] { { 1, 1, 1, 1, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0, 0, 0, 0 },
						{ 1, 0, 1, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 1, 1, 0 }, { 0, 0, 0, 0, 1, 1,  0, 0 },
						{ 0, 0, 0, 0, 1, 0, 1, 0 },  { 0, 0, 0, 0, 0, 0, 0, 1, 0 } });
		System.out.println(res);

	}

}

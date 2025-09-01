package graph;

public class IslandCount {
	public int numIslands(char[][] grid) {
        int l = grid.length;
        int h = grid[0].length;
        boolean[][] visited = new boolean[l][h];
        int islands = 0;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < h; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islands++;
                    dfs(i, j, visited, grid);
                }
            }
        }
        return islands;
    }

    private void dfs(int i, int j, boolean[][] visited, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if (grid[i][j] == '0' || visited[i][j]) return;

        visited[i][j] = true;

        dfs(i + 1, j, visited, grid); 
        dfs(i - 1, j, visited, grid); 
        dfs(i, j + 1, visited, grid); 
        dfs(i, j - 1, visited, grid); 
    }

	public static void main(String[] args) {
		IslandCount p = new IslandCount();
		int res = p.numIslands(new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } });
		System.out.println(res);

	}
}

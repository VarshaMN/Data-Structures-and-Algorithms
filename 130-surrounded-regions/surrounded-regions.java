class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];
        int[] rdir = {-1, 0, 1, 0};
        int[] cdir = {0, 1, 0, -1};

        // Traverse first and last column
        for (int i = 0; i < n; i++) {
            if (vis[i][0] == 0 && board[i][0] == 'O')
                dfs(i, 0, vis, rdir, cdir, board);
            if (vis[i][m-1] == 0 && board[i][m-1] == 'O') // Fixed: m-1 instead of n-1
                dfs(i, m-1, vis, rdir, cdir, board);
        }

        // Traverse first and last row
        for (int j = 0; j < m; j++) {
            if (vis[0][j] == 0 && board[0][j] == 'O')
                dfs(0, j, vis, rdir, cdir, board);
            if (vis[n-1][j] == 0 && board[n-1][j] == 'O') // Fixed: n-1 instead of m-1
                dfs(n-1, j, vis, rdir, cdir, board);
        }

        // Convert unvisited 'O' to 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col, int[][] vis, int[] rdir, int[] cdir, char[][] board) {
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + rdir[i];
            int ncol = col + cdir[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O')
                dfs(nrow, ncol, vis, rdir, cdir, board);
        }
    }
}

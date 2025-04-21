class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
       
        return bottomUp(m,n,grid);
    }
    int rec(int i,int j,int[][] arr){
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(i==0 && j==0) return arr[i][j];
        
      
     
        return arr[i][j]+Math.min(rec(i-1,j,arr),rec(i,j-1,arr));
    }
    int topDown(int i,int j,int[][] arr,int[][] dp){
          if(i<0 || j<0) return 80000000;
        if(i==0 && j==0) return arr[i][j];

        if(dp[i][j]!=-1)
         return dp[i][j];
        int left=topDown(i,j-1,arr,dp);
        int up=topDown(i-1,j,arr,dp);
        return dp[i][j]=arr[i][j]+Math.min(left,up);
    }

    int bottomUp(int m,int n,int[][] grid){
   

    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (i == 0 && j == 0)
                dp[i][j] = grid[i][j];
            else {
                int up = (i > 0) ? dp[i - 1][j] : Integer.MAX_VALUE;
                int left = (j > 0) ? dp[i][j - 1] : Integer.MAX_VALUE;
                dp[i][j] = grid[i][j] + Math.min(up, left);
            }
        }
    }

    return dp[m - 1][n - 1];

    }

}
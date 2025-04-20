class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }

        }
        return topDown(m-1,n-1,grid,dp);
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

}
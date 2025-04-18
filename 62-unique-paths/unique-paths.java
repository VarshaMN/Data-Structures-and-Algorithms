class Solution {
    public int uniquePaths(int m, int n) {
       
        return bottomUp(m,n);
    }

    public int rec(int i,int j){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        int up=rec(i-1,j);
        int left=rec(i,j-1);
        return up+left;
    }

    public int topDown(int i,int j,int[][] dp){
       if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=topDown(i-1,j,dp);
        int left=topDown(i,j-1,dp);
        
        return dp[i][j]=up+left;

    }
    int bottomUp(int m, int n){
        int[][] dp=new int[m][n];
       
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0) continue;
                 int up=0,left=0;

                 if(i>0) up=dp[i-1][j];
                 if(j>0) left=dp[i][j-1];
                 dp[i][j]=up+left;

            }
        }
        return dp[m-1][n-1];
    }
}
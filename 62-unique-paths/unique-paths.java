class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return topDown(m-1,n-1,dp);
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
}
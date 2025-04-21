class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        
        int[][] dp=new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++)
                dp[i][j]=-1;
        }
        return topDown(n,triangle,0,0,dp);
    }
    int rec(int n,List<List<Integer>> arr,int i,int j){
        if(i==n-1){
            return arr.get(n-1).get(j);
        }
        int down=arr.get(i).get(j)+rec(n,arr,i+1,j);
        int adj=arr.get(i).get(j)+rec(n,arr,i+1,j+1);
        return Math.min(down,adj);
        
    }

    int topDown(int n,List<List<Integer>> arr,int i,int j,int[][] dp){
       if(i==n-1){
            return arr.get(n-1).get(j);
        }
        if(dp[i][j]!=-1)
        return dp[i][j];

        int down=arr.get(i).get(j)+topDown(n,arr,i+1,j,dp);
        int adj=arr.get(i).get(j)+topDown(n,arr,i+1,j+1,dp);
        return dp[i][j]=Math.min(down,adj);

        

    }
}
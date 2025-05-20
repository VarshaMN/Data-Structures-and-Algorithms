class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
              if(text1.charAt(i-1)==text2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
        
        //not matching
       
             else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
    int rec(String s1,String s2,int i,int j){
        if(i<0 || j<0){
            return 0;
        }
        //matching
        if(s1.charAt(i)==s2.charAt(j)){
            return 1+rec(s1,s2,i-1,j-1);
        }
        //not matching
       
            return Math.max(rec(s1,s2,i-1,j),rec(s1,s2,i,j-1));
        

    }
    int topDown(String s1,String s2,int i,int j,int[][] dp){
        if(i<0 || j<0){
            return 0;
        }

        if(dp[i][j]!=-1) return dp[i][j];

         if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+topDown(s1,s2,i-1,j-1,dp);
        }
        //not matching
       
            return dp[i][j]=Math.max(topDown(s1,s2,i-1,j,dp),topDown(s1,s2,i,j-1,dp));
        
        //tc:o(nxm)+o(n+m)stack space sc:o(nxm)

    }
  
}
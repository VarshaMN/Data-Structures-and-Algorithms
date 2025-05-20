class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int s1=text1.length();
        int s2=text2.length();
        int[][] dp=new int[s1][s2];
        for(int i=0;i<s1;i++){
            for(int j=0;j<s2;j++){
                dp[i][j]=-1;
            }
        }
        return topDown(text1,text2,s1-1,s2-1,dp);
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
        


    }
}
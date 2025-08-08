class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        int totalcount=n*m,count=1;
        int startingrow=0,endingrow=n-1;
        int startingcol=0,endingcol=m-1;
        while( count<=totalcount){
          for(int i=startingcol;i<=endingcol;i++){
            ans.add(matrix[startingrow][i]);count++;
          }
          startingrow++;
          for(int i=startingrow;i<=endingrow;i++){
            ans.add(matrix[i][endingcol]);count++;
          }
          endingcol--;
          if(startingrow<=endingrow){
            for(int i=endingcol;i>=startingcol;i--){
            ans.add(matrix[endingrow][i]);count++;

          }
          }
          endingrow--;
          if(startingcol<=endingcol){
            for(int i=endingrow;i>=startingrow;i--){
            ans.add(matrix[i][startingcol]);count++;
          }
          }
          startingcol++;
          
          
        }
        return ans;
        
    }
}
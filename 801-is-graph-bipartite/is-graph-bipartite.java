class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;

        int[] colour=new int[graph.length];
        for(int i=0;i<colour.length;i++){
            colour[i]=-1;
        }
        for(int i=0;i<colour.length;i++){
            if(colour[i]==-1){
                if(dfs(graph,i,colour,0)==false) return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph,int start,int[] colour,int col){
        colour[start]=col;
        for(Integer it:graph[start]){
            if(colour[it]==-1){
              if(dfs(graph,it,colour,1-col)==false) return false;
            }else if(colour[it]==col){
                return false;
            }
        }
        return true;
    }
}
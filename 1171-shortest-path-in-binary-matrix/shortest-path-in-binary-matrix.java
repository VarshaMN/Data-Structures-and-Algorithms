class Tuple{
    int first;
    int second;
    int third;
    Tuple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(n==1 && grid[0][0]==0) return 1;
        if(grid[0][0]==1) return -1;
        int dist[][]=new int[n][m];
        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(1,0,0));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[0][0]=0;
        while(!q.isEmpty()){
            int dis=q.peek().first;
            int i=q.peek().second;
            int j=q.peek().third;
            q.poll();
            if(i+1<n && j<n && grid[i+1][j]==0 && dis+1<dist[i+1][j]){
                dist[i+1][j]=dis+1;
                if(i+1==n-1 && j==m-1) return dis+1;
                q.add(new Tuple(dis+1,i+1,j));
            }
            if(i<n && j<n && i-1>=0 && j>=0 && grid[i-1][j]==0 && dis+1<dist[i-1][j]){
                dist[i-1][j]=dis+1;
                if(i-1==n-1 && j==m-1) return dis+1;
                q.add(new Tuple(dis+1,i-1,j));
            }
            if(i<n && j+1<n && grid[i][j+1]==0 && dis+1<dist[i][j+1]){
                dist[i][j+1]=dis+1;
                if(i==n-1 && j+1==m-1) return dis+1;
                q.add(new Tuple(dis+1,i,j+1));
            }
            if(i<n && j<n && j-1>=0 && i>=0 && grid[i][j-1]==0 && dis+1<dist[i][j-1]){
                dist[i][j-1]=dis+1;
                if(i==n-1 && j-1==m-1) return dis+1;
                q.add(new Tuple(dis+1,i,j-1));
            }
            if(i+1<n && j+1<n && j>=0 && i>=0 && grid[i+1][j+1]==0 && dis+1<dist[i+1][j+1]){
                dist[i+1][j+1]=dis+1;
                if(i+1==n-1 && j+1==n-1) return dis+1;
                q.add(new Tuple(dis+1,i+1,j+1));
            }
            if(i<n && j<n && j-1>=0 && i-1>=0 && grid[i-1][j-1]==0 && dis+1<dist[i-1][j-1]){
                dist[i-1][j-1]=dis+1;
                if(i-1==n-1 && j-1==n-1) return dis+1;
                q.add(new Tuple(dis+1,i-1,j-1));
            }
            if(i+1<n && j<n && j-1>=0 && i>=0 && grid[i+1][j-1]==0 && dis+1<dist[i+1][j-1]){
                dist[i+1][j-1]=dis+1;
                if(i+1==n-1 && j-1==n-1) return dis+1;
                q.add(new Tuple(dis+1,i+1,j-1));
            }
            if(i<n && j+1<n && j>=0 && i-1>=0 && grid[i-1][j+1]==0 && dis+1<dist[i-1][j+1]){
                dist[i-1][j+1]=dis+1;
                if(i-1==n-1 && j+1==n-1) return dis+1;
                q.add(new Tuple(dis+1,i-1,j+1));
            }
        }
    return -1;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
    int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    public void dfs(int i, int j, char[][] grid) {
        grid[i][j] = '-';
        for(int[] d : dir){
            int new_i = i + d[0];
            int new_j = j + d[1];
            if(isSafe(new_i,new_j,grid)){
                dfs(new_i,new_j,grid);
            }
        }
    }
    public boolean isSafe(int x,int y,char[][] grid){
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length) return false;
        if(grid[x][y]=='-') return false;
        if(grid[x][y]=='0') return false;
        return true;
    }
}
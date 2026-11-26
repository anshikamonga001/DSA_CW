class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            boolean[] visited = new boolean[n+1];
            if(dfs(u, v, adj, visited)){
                return edges[i];
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[]{};
    }
    public boolean dfs(int curr, int target, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        if(curr == target) return true;

        visited[curr] = true;

        for(int i = 0; i < adj.get(curr).size(); i++){
            int nbr = adj.get(curr).get(i);

            if(!visited[nbr]){
                if(dfs(nbr, target, adj, visited)) return true;
            }
        }
        return false;
    }
}
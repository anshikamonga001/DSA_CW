class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int ans[] = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[idx] = curr;
            idx++;
            for(int i=0;i<adj.get(curr).size();i++){
                int nbr = adj.get(curr).get(i);
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.add(nbr);
                }
            }
        }
        if(idx!=numCourses) return new int[0];
        return ans;
    }
}
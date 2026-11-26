
class Solution {

    public int[] findRedundantDirectedConnection(int[][] edges) {

        int n = edges.length;

        int[] parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        int[] first = null;
        int[] second = null;
        int skip = -1;

        // Step 1: Find node having two parents

        for (int i = 0; i < n; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            if (parent[v] != v) {

                first = new int[]{parent[v], v};
                second = edges[i];

                skip = i;

            } else {
                parent[v] = u;
            }
        }

        // Step 2: Reset DSU

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        // Step 3: Detect cycle

        for (int i = 0; i < n; i++) {

            if (i == skip) {
                continue;
            }

            int u = edges[i][0];
            int v = edges[i][1];

            int p1 = find(parent, u);
            int p2 = find(parent, v);

            if (p1 == p2) {

                if (first == null) {
                    return edges[i];
                }

                return first;
            }

            parent[p2] = p1;
        }

        return second;
    }

    public int find(int[] parent, int x) {

        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }
}

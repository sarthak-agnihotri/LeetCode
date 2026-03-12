import java.util.*;

class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        int left = 0, right = 200000, ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (can(n, edges, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean can(int n, int[][] edges, int k, int x) {

        DSU dsu = new DSU(n);
        int count = 0;
        int upgrades = 0;

        List<int[]> normal = new ArrayList<>();
        List<int[]> upgrade = new ArrayList<>();

        for (int[] e : edges) {
            if (e[3] == 1) {  // mandatory
                if (e[2] < x) return false;
                if (!dsu.union(e[0], e[1])) return false;
                count++;
            } else {
                if (e[2] >= x) normal.add(e);
                else if (e[2] * 2 >= x) upgrade.add(e);
            }
        }

        for (int[] e : normal) {
            if (dsu.union(e[0], e[1])) {
                count++;
            }
        }

        for (int[] e : upgrade) {
            if (dsu.union(e[0], e[1])) {
                upgrades++;
                count++;
                if (upgrades > k) return false;
            }
        }

        return count == n - 1;
    }
}
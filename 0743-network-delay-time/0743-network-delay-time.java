import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        dist[k] = 0;
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int time = current[0];
            int node = current[1];

            if (time > dist[node]) {
                continue;
            }

            for (int[] neighbor : adj.get(node)) {

                int nextNode = neighbor[0];
                int weight = neighbor[1];

                int newTime = time + weight;

                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;
                    pq.offer(new int[]{newTime, nextNode});
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}
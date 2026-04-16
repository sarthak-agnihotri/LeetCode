import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        
        // Map value -> indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        
        // Process each value group
        for (List<Integer> list : map.values()) {
            int size = list.size();
            if (size == 1) continue;
            
            for (int i = 0; i < size; i++) {
                int curr = list.get(i);
                int prev = list.get((i - 1 + size) % size);
                int next = list.get((i + 1) % size);
                
                int d1 = Math.abs(curr - prev);
                int d2 = Math.abs(curr - next);
                
                d1 = Math.min(d1, n - d1);
                d2 = Math.min(d2, n - d2);
                
                dist[curr] = Math.min(d1, d2);
            }
        }
        
        // Build result list
        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            result.add(dist[q]);
        }
        
        return result;
    }
}
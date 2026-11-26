import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] f : flights) {
            graph.get(f[0]).add(new int[]{f[1], f[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );
        pq.add(new int[]{0, src, 0});
        int[] bestStops = new int[n];
        Arrays.fill(bestStops, Integer.MAX_VALUE);
        bestStops[src] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int city = curr[1];
            int stops = curr[2];
            if (city == dst) {
                return cost;
            }
            if (stops > k) {
                continue;
            }
            if (stops > bestStops[city]) {
                continue;
            }

            bestStops[city] = stops;
            for (int[] edge : graph.get(city)) {
                int nextCity = edge[0];
                int price = edge[1];
                pq.add(new int[]{cost + price, nextCity, stops + 1});
            }
        }
        return -1;  
    }
}

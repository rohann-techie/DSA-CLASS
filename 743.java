class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int edge[]:times){
            adj.get(edge[0]-1).add(new int[]{edge[1]-1,edge[2]});
        }
        int arr[] = new int[n];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[k-1]=0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        q.add(new int[]{k-1,0});
        while(!q.isEmpty()){
            int node[] = q.poll();
            int curr = node[0];
            for(int edge[]:adj.get(curr)){
                int next = edge[0]; int wt = edge[1];
                if(arr[curr]+wt<arr[next]){
                    arr[next] = arr[curr]+wt;
                    q.add(new int[]{next,arr[next]});
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(arr[i]==Integer.MAX_VALUE) return -1;
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}

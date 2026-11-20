class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int v = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());
        int deg[] = new int[v];
        for(int edge[]: prerequisites){
            adj.get(edge[1]).add(edge[0]);
            deg[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(deg[i]==0) q.add(i);
        }
        int arr[] = new int[v];
        int index=0;
        while(!q.isEmpty()){
            int node = q.poll();
            arr[index++] = node; 
            for(int edge:adj.get(node)){
                deg[edge]--;
                if(deg[edge]==0){
                    q.add(edge);
                }
            }
        }
        if(index!=v) return new int[]{};
        return arr;
    }
}

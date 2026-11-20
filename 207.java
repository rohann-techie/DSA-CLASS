class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int edge[]: prerequisites){
            adj.get(edge[0]).add(edge[1]);
        }
        boolean vis[] = new boolean[numCourses];
        boolean check[] = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(i,vis,check,adj)) return false;
            }
        }
        return true;
    }
    private boolean dfs(int node,boolean vis[],boolean check[],List<List<Integer>> adj){
        vis[node]=true;
        check[node]=true;
        for(int edge:adj.get(node)){
            if(!vis[edge]){
                if(dfs(edge,vis,check,adj)) return true;
            }
            else if(check[edge]) return true;
        }
        check[node]=false;
        return false;
    }
}

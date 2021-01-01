package courseraGraphs.week3;

import java.util.*;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        int res=0;
        res=dfs(adj);

        return res;

    }
    private static int dfs(ArrayList<Integer>[] adj){
        boolean[] marked= new boolean[adj.length];
        int[] dist= new int[adj.length];
        for(int i=0;i<marked.length; i++){
            marked[i]=false;
            dist[i]=-1;
        }
        int res=1;
        for(int i=0; i<adj.length; i++){
            if(!marked[i]){
                res=bfs(adj,marked, i,dist);
            }
            if(res==0){
                break;
            }
        }
        return res;
    }
    private static int bfs( ArrayList<Integer>[] adj, boolean[] marked, int s, int[] dist){
        int res=1;
        ArrayList<Integer> queue= new ArrayList<Integer>();
        dist[s]=0;

        queue.add(s);
        while(!queue.isEmpty() && res==1){
            int u=queue.remove(0);

            marked[u]=true;
            for(int i=0; i<adj[u].size(); i++){

                int vex= adj[u].get(i);
                if(dist[vex]==-1){
                    queue.add(vex);

                    dist[vex]=dist[u]+1;
                }else{
                    if(dist[vex]==dist[u]){
                        res=0;
                    }
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(bipartite(adj));
    }
}


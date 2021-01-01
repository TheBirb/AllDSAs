package courseraGraphs.week4;

import java.util.*;

public class Dijkstra {
    private static long distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        int[] dist=  new int[adj.length];
        int[] prev= new int[adj.length];
        for(int i=0; i<adj.length; i++){
            dist[i]=Integer.MAX_VALUE;
            prev[i]=Integer.MAX_VALUE;
        }
        dist[s]=0;
        PriorityQueue<Node> priorityQueue= new PriorityQueue<Node>();
        priorityQueue.add(new Node(s, 0));
        while(!priorityQueue.isEmpty()){
            int u= priorityQueue.remove().vertex;
            for(int i=0; i<adj[u].size(); i++){
                int vex= adj[u].get(i);
                if(dist[vex]>dist[u]+cost[u].get(i)){
                    dist[vex]=dist[u]+cost[u].get(i);
                    prev[vex]=u;

                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
    static class Node implements Comparator<Node>{
        int vertex;
        int cost;
        Node(int vertex, int cost){
            this.cost=cost;
            this.vertex=vertex;
        }
        @Override
        public int compare(Node n1,Node n2){
            if(n1.cost<n2.cost){
                return -1;
            }else if(n1.cost>n2.cost){
                return 1;
            }else{
                return 0;
            }
        }
    }
}


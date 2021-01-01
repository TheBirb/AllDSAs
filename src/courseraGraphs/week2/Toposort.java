package courseraGraphs.week2;
import java.util.ArrayList;
import java.util.Scanner;

public class Toposort {
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj){
        boolean[] used= new boolean[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();
        for(int i=0; i<adj.length; i++){
            if(!used[i]){
                dfs(adj, used, order, i);
            }
        }
        return order;
    }

    private static void dfs (ArrayList<Integer>[] adj, boolean[] used, ArrayList<Integer> order, int s){
        used[s]=true;
        for(int i=0; i<adj[s].size(); i++){
            int vex=adj[s].get(i);
            if(!used[vex]){
                dfs(adj, used, order, vex);
            }
        }
        order.add(0,s);

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
        }
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}


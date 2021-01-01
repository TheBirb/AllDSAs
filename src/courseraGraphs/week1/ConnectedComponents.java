package courseraGraphs.week1;

import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    private static boolean[] marked;
     private static int numberOfComponents(ArrayList<Integer>[] adj) {

        int result = 0;
         marked= new boolean[adj.length];
         for(int i=0;i<marked.length;i++){
             marked[i]=false;
         }
        for(int i=0; i<adj.length; i++){
            if(marked[i]==false){
                marked[i]=true;
                explore(adj,i);
                result++;
            }
        }


        return result;
    }
    public static void explore(ArrayList<Integer>[] adj, int x){
         for (int i=0; i<adj[x].size(); i++){
             int vex=adj[x].get(i);
             if(marked[vex]==false){
                 marked[vex]=true;
                 explore(adj, vex);
             }
         }
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
        System.out.println(numberOfComponents(adj));
    }
}


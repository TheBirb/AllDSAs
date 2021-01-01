package courseraGraphs.week1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Reachability {

    public static boolean[] marked;
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        marked= new boolean[adj.length];
        for(int i=0; i<adj.length; i++){
            marked[i]=false;

        }
        int res=0;
        res=explore(adj, x, y);

        return res;
    }

    public static int explore(ArrayList<Integer>[] adj, int v, int y){
        int res=0;
        for(int i=0; i<adj[v].size(); i++){
            int vex=adj[v].get(i);
            if(marked[vex]==false){
                marked[vex]=true;
                if(vex==y){
                    res=1;
                    break;
                }else{
                    res=explore(adj, vex, y);
                    if(res==1){
                        break;
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}


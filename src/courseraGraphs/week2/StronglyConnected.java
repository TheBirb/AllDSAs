package courseraGraphs.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class StronglyConnected {
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj, ArrayList<Integer>[] adjR) {
        boolean[] marked= new boolean[adj.length];
        ArrayList<Integer> order=  new ArrayList<Integer>();
        //Create a list with reverse postorder
        for(int i=0;i<adjR.length; i++){
            if(!marked[i]){
                dfs(adjR,order, marked, i);
            }
        }
        //Number of scc
        int number=0;
        //We restart the visited edges list
        marked= new boolean[adj.length];
        //Travere de reverse postorder list
        for(int i=0; i<order.size(); i++){
            int vex=order.get(i);
            //if not visited
            if(!marked[vex]){
                //explore and mark vertices
                explore(adj,vex, marked);
                //once finished mark visited vertices as new SCC
                number++;
            }
        }
        return number;
    }

    /**
     * Method used to explore adjacent edges and mark them as visited
     * @param adj
     * @param s
     * @param marked
     */
    private static void explore(ArrayList<Integer>[] adj, int s, boolean[] marked){
        marked[s]=true;
        for(int i=0; i<adj[s].size(); i++){
            int vex= adj[s].get(i);
            if(!marked[vex]){
                explore(adj, vex, marked);
            }
        }

    }
    /**
     * Method used to dfs the graph and create a reverse post-order list
     * @param adjR
     * @param order
     * @param marked
     * @param s
     */
    private static void dfs(ArrayList<Integer>[] adjR,ArrayList<Integer> order,boolean[] marked, int s){
        //mark as visited
        marked[s]=true;
        //explore
        for(int i=0; i<adjR[s].size(); i++){
            //adjacent edge
            int vex=adjR[s].get(i);
            //if not visited
            if(!marked[vex]){
                //recursive call
                dfs(adjR,order, marked,vex);
            }
        }
        //if sink add to list
        order.add(0,s);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] adjR = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjR[i]=new ArrayList<Integer>();
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adjR[y-1].add(x-1);
        }
        System.out.println(numberOfStronglyConnectedComponents(adj, adjR));
    }
}


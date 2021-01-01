package graphs;

import queues.Queue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class colorGraph {
     static  boolean[] visited;
     static int[] prev;
     static String[] colored;
    public static void graphColoring(int[][] graph){
        prev= new int[graph.length];
        visited = new boolean[graph.length];
        colored= new String[graph.length];
        for(int i=0; i<graph.length; i++){
            colored[i]="";
            prev[i]=-1;
        }
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                prev[i]=i;
                colored[i]="Black";
                bfs(graph, i);
            }
        }
    }

    private static void bfs(int[][] graph, int s){
        ArrayList<Integer> queue= new ArrayList<Integer>();
        queue.add(s);
        while(!queue.isEmpty()){
            int u=queue.remove(0);
                visited[u]=true;
                for(int i=0; i<graph[u].length; i++){
                    int vex=graph[u][i];
                    if(vex!=-1){
                        if(!visited[i]){
                            queue.add(i);
                            prev[i]=u;
                            coloring(i);
                        }
                    }
                }
        }
    }


    public static void coloring(int s){
        if(colored[prev[s]].equals("White")){
            colored[s]="Black";
        }else{
            colored[s]="White";
        }
    }


    public static void main(String[] args) {

        Scanner s= new Scanner(System.in);
        int v=s.nextInt();
        int e= s.nextInt();
        int[][] graph=new int[v][v];
        for(int i=0; i< graph.length; i++){
            for(int j=0; j<graph.length; j++){
                graph[i][j]=-1;
            }
        }
        for(int i=0; i<e; i++){
            int x=s.nextInt();
            int y=s.nextInt();
            graph[x-1][y-1]=1;
            graph[y-1][x-1]=1;
        }

        graphColoring(graph);
        for(int i=0; i<colored.length; i++){
            System.out.println(colored[i]);
        }
    }
}

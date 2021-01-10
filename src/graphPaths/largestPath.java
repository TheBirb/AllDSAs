package graphPaths;

import javax.naming.PartialResultException;
import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class largestPath {
static Stack<Integer> largestPath=new Stack<Integer>();


    private static void backtracking(int[][] graph,LinkedList<Integer> a, int k, int init, int target, int steps){
        if(done(init+1,target)){
            if(a.size()> largestPath.size() && a.size()==steps){
                largestPath=copyPath(a);
            }
        }else{
            k++;
            int[] c = new int[500];
            int ncandidates=makeCandidates(graph,a,c,init);
            for(int i=0; i<ncandidates; i++){
                a.add(c[i]);
                backtracking(graph,a,k,c[i]-1,target,steps);
                while(a.peekLast()!=init+1){
                    a.removeLast();
                }
            }
        }

    }
    private static Stack<Integer> copyPath(LinkedList<Integer> a){
        Stack<Integer> temp= new Stack<Integer>();
        temp.addAll(a);
        return temp;
    }
    private static int makeCandidates(int[][] graph,LinkedList<Integer> a, int[] c,int actual){
        int ret=0;
        int vex=actual;
        boolean valid=true;
        for(int i=0; i<graph[vex].length; i++){
            if(graph[vex][i]==1){
                if(a.contains(i+1)){
                    valid=false;
                }
                if(valid){
                    c[ret]=i+1;
                    ret++;
                }
                valid=true;
            }

        }
        return ret;

    }
    private static boolean done(int actual, int target){
        return actual==target;
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
        int start=s.nextInt();
        int target=s.nextInt();
        LinkedList<Integer>a = new LinkedList<>();
        a.add(start);
        backtracking(graph,a,0,start-1,7,13);
        System.out.println(largestPath);



    }
}

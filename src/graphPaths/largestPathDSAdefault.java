package graphPaths;

import DSAdefault.graphs.Bag;
import DSAdefault.graphs.Graph;


import javax.imageio.ImageTranscoder;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class largestPathDSAdefault {
static Stack<Integer> largestPath= new Stack<Integer>();
static int maxCandidates=-1;

    private static void backtrackLargestPath(Graph graph, LinkedList<Integer> a, int init, int target){
        if(done(init, target)){
            if(largestPath.size()<a.size()){
                largestPath=copyPath(a);
            }
        }else{
            int[] c= new int[maxCandidates];
            int ncandidates= candidateMaker(graph, a, c, init);
            for(int i=0; i<ncandidates; i++){
                a.add(c[i]);
                backtrackLargestPath(graph, a, c[i], target);
                while(a.peekLast()!=init){
                    a.removeLast();
                }
            }

        }
    }
    private static int candidateMaker(Graph graph, LinkedList<Integer> a, int[] c, int actual){
        int ret=0;
        boolean valid=true;
        Iterator<Integer> list= graph.adj(actual).iterator();
        while(list.hasNext()){
            int i= list.next();
            if(a.contains(i)){

                valid=false;
            }
            if(valid){
                c[ret]=i;
                ret++;
            }
            valid=true;
        }
        return ret;
    }
    private static boolean done(int actual, int target){
        return actual==target;
    }
    private static Stack<Integer> copyPath(LinkedList<Integer> a){
        Stack<Integer> temp= new Stack<Integer>();
        temp.addAll(a);
        return temp;
    }


    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int v= s.nextInt();
        int e=s.nextInt();
        Graph graph= new Graph(v);
        for(int i=0; i<e; i++){
            int x=s.nextInt();
            int y=s.nextInt();
            graph.addEdge(x-1,y-1);
        }
        int init=s.nextInt();
        int target=s.nextInt();
        maxCandidates= graph.V()*10;
        LinkedList<Integer> a= new LinkedList<Integer>();
        a.add(0);
        backtrackLargestPath(graph, a, 0, 6);
        System.out.println(largestPath);

    }
}

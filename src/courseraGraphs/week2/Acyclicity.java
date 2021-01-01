package courseraGraphs.week2;

import java.util.ArrayList;

import java.util.Scanner;
import java.util.Stack;

public class Acyclicity {
    private static Stack<Integer> stack= new Stack<>();
    private static int acyclic(ArrayList<Integer>[] adj) {
        int res=0;
        for(int i=0; i<adj.length; i++){
            stack.push(i);
            res=explore(adj,i);
            if(res==1){
                break;
            }
            stack=new Stack<>();
        }
        return res;
    }
    private static int explore(ArrayList<Integer>[] adj, int x){
        int res=0;
        for(int i=0; i<adj[x].size(); i++){
            int vex=adj[x].get(i);
            if(!stack.contains(vex)){
                stack.push(vex);
                res=explore(adj, vex);
                if(res==1){
                    break;
                }
                stack.pop();
            }else{
                res=1;
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
        }
        System.out.println(acyclic(adj));
    }
}


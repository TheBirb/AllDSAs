package Graph;

import java.util.Scanner;
import java.util.Stack;

public class selfLoops {
    private static boolean[] marked;
    private static Stack<Integer> stack;
    public static int numberOfSelfLoops(int[][] adj){
        int count=0;
        marked= new boolean[adj.length];
        for(int i=0; i<marked.length; i++){
            marked[i]=false;
        }
        return dfs(adj);
    }

    public static int dfs(int[][] adj){
        int count=0;
        for(int i=0; i<adj.length; i++){
            if(!marked[i]){
                stack= new Stack<Integer>();
                stack.push(i);
                count+=explore(adj,i,i);
            }
        }
        return count;
    }
    public static int explore(int[][] adj, int s, int prev){
        int count=0;
        marked[s]=true;
        for(int i=0; i<adj[s].length; i++){
            int vex= adj[s][i];
            if(vex!=-1){
                if(!marked[vex]){
                    stack.push(vex);
                    count+=explore(adj, vex, s);
                    stack.pop();
                }else{
                    if(prev!=vex){
                        if(stack.contains(vex)){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] adj= new int[n][m];
        for (int i = 0; i < n; i++) {
            for(int j=0; j<m; j++){
                adj[i][j]=-1;
            }
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1][i]=y-1;
            adj[y - 1][i]=x-1;
        }
        System.out.println(numberOfSelfLoops(adj));

    }
}

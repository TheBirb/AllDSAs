package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class deg {
    public static int degree(int[][] adj, int v){
        int res=-1;
       res= dfs(adj, v);
        return res;
    }

    private static  int dfs(int[][] adj, int s){
        int res=-1;
        for(int i=0; i<adj.length; i++){
            if(i==s){
                res=explore(adj, i);
                break;
            }
        }
        return res;
    }

    private static int explore(int[][] adj, int x){
        int count=0;
        for(int i=0; i<adj[x].length;i++){
            if(adj[x][i]==1){
                count++;
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
                adj[i][j]=0;
            }
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1][y-1]=1;
            adj[y - 1][x - 1]=1;
        }
        int x = scanner.nextInt() - 1;
        if(x>=n){
            System.out.println("Node is not on the graph");
        }else{
            System.out.println(degree(adj, x));
        }

    }
}



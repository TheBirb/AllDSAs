package Graph;

import java.util.Scanner;

public class maxDeg {

    public static int maxDegree(int[][] adj){
        int res=dfs(adj);
        return res;
    }

    public static int dfs(int[][] adj){
        int count=0;
        int max=0;
        for(int i=0; i<adj.length; i++){
            count=explore(adj[i]);
            if(max<count){
                max=count;
            }
        }
        return max;
    }
    public static int explore(int[] adj){
        int count=0;
        for(int i=0; i<adj.length; i++){
            if(adj[i]!=-1){
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
                adj[i][j]=-1;
            }
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1][i]=y-1;
            adj[y - 1][i]=y-1;
        }
        System.out.println(maxDegree(adj));

    }
}


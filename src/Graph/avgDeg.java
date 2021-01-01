package Graph;

import java.util.Scanner;

public class avgDeg {

    public static int avgDegree(int[][] adj){
        int res=0;
        res=dfs(adj);
        res=res/adj.length;
        return res;
    }

    public static int dfs(int[][] adj){
        int count=0;
        for(int i=0; i<adj.length; i++){
           count+=explore(adj[i]);
        }
        return count;
    }

    public static int explore(int[] adj){
        int count=0;
        for(int i=0; i<adj.length; i++){
            int vex= adj[i];
            if(vex!=-1){
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
        System.out.println(avgDegree(adj));

    }
}

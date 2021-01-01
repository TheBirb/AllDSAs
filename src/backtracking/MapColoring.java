package backtracking;

public class MapColoring {
    static String[] color={"Orange","Pink","Yellow","Red"};
    static boolean done=false;
    static int[][] adj={
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,1,1,1,0,0,0,0,0},
            {0,1,0,1,0,1,1,0,0,0},
            {0,1,1,0,1,0,1,0,0,0},
            {0,1,0,1,0,0,1,1,0,0},
            {0,0,1,0,0,0,1,0,1,0},
            {0,0,1,1,1,1,0,1,1,1},
            {0,0,0,0,1,0,1,0,0,1},
            {0,0,0,0,0,1,1,0,0,1},//Italy
            {0,0,0,0,0,0,1,1,1,0},//Slovenia 9

    };
    public static void mapColoring(int[][] adj,String[] a, int k) {
        if(solution(adj.length, k)){
            done=true;
            System.out.println("Map colored");
            printSol(a);
            return;
        }else{
            k++;
            int i;
            for( i=0; i<color.length; i++){
                a[k]=color[i];
                if(validate(adj, a,k)){
                    mapColoring(adj, a,k);
                    if(done){return;}
                }
            }
        }
    }
    private static boolean validate(int[][] adj, String[] a, int k){
        boolean res=true;
        for(int i=1; i<adj.length; i++){
            if(k!=i && a[i]!=null){
                if(a[i].equals(a[k])){
                    if(adj[i][k]==1){
                        res=false;
                        break;
                    }
                }
            }
        }
        return res;
    }
    private static boolean solution(int v, int k){
        return k==(v-1);
    }
    private static void printSol(String[] a){
        String s="[";
        for(int i=1; i<a.length; i++){
            s+=a[i]+",";
        }
        s+="]";
        System.out.println(s);
    }
    public static void main(String[] args) {
        String[] a= new String[adj.length];
        mapColoring(adj,a,0);
    }
}

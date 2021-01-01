package backtracking;

public class MinimumCoinChange {
    private static boolean finished=false;
    private static final int MAX_CANDIDATES=100;
    private static int[] coins={-1,10,5,1};

    public static void backtracking(int[] a , int k, int input){
        if(done(input,a, k)){
            finished=true;
            printSol(a, k);
        }else{
            k++;
            int c[]= new int[MAX_CANDIDATES];
            int ncandidates=candidateMaker(c,a,input,k);
            for(int i=0; i<ncandidates; i++){
                a[k]=c[i];
                backtracking(a, k, input);
            }
        }
    }
    private static int candidateMaker(int[] c, int[] a , int input,int k ){
        int ret=0;
        boolean valid=true;
        int sum=0;
        for(int i=1; i<=k; i++){
            sum+=a[i];
        }
        for(int i=1; i<coins.length; i++){
            int change=coins[i];
            if(input<change+sum){
                valid=false;
            }
            if(valid){
                c[ret]=change;
                ret++;
            }
            valid=true;

        }
        return ret;
    }

    private static boolean done(int input, int a[], int k){
        int sum=0;
        for(int i=1; i<=k; i++){
            sum+=a[i];
        }
        return sum==input;
    }

    private static void printSol(int[] a, int k){
        String print="[";
        for(int i=1; i<=k; i++){
            print+=a[i]+", ";
        }
        print+="]";
        System.out.println(print);
    }

    public static void main(String[] args) {
        int[] a= new int[MAX_CANDIDATES];
        int input=12;
        backtracking(a,0,input);
    }
}

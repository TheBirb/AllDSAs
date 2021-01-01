package backtracking;

public class permutationGivenVector {
    static String [] data={"","a","b","c","d"};
    static boolean finished=true;

    private static void backtracing(String[] a, int k, int input){
        if(done(k,input)){
            finished=true;
            print(a);
        }else{
            k++;
            String[] c= new String[10000];
            int ncandidates=candidateMaker(a,c,k, input);
            for(int i=0; i<ncandidates; i++){
                a[k]=c[i];
                backtracing(a, k, input);
                //if(finished){return;}
            }
        }

    }
    private static boolean done(int k, int n){
        return k==n-1;

    }

    /**
     * No validos
     * 1.si el dato esta en la misma posicion
     * 2.si el dato ya esta en a
     * @param a
     * @param c
     * @param k
     * @param n
     * @return
     */
    private static int candidateMaker(String a[],String[] c, int k, int n){
        int ret=0;
        boolean valid=true;
        for(int i=1; i<n; i++){
            if(data[i]==data[k]){
                valid=false;
            }
            for(int j=1;j<k; j++){
                if(a[j]!=null){
                    if(data[i]==a[j]){
                        valid=false;
                        break;
                    }
                }
            }
           if(valid){
               c[ret]=data[i];
               ret++;
           }
           valid=true;
        }

        return ret;
    }
    private static void print(String[] a){
        String s="[";
        for(int i=1; i<a.length; i++){
            s+=a[i]+",";
        }
        s+="]";
        System.out.println(s);
    }


    public static void main(String[] args) {
        String[] a= new String[data.length];
        backtracing(a,0, 5);
    }

}

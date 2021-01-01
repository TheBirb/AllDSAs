package backtracking;

public class permutation {

    private static String[] chars={"a","b","c","d"};
    private static int number_of_char=0;
    private static boolean done=false;
    private static void backtrack(String[] a , int k){
        if(finished(k)){
            done=true;
            printPerm(a);
        }else{
            k++;
            for(int i=0;i<chars.length;i++){
                a[k]=chars[i];
                if(validate(a, k)){
                    backtrack(a, k);
                    if(done){
                        return;
                    }
                }
            }
        }

    }
    private static boolean finished(int k){
        return k==number_of_char;
    }
    private static boolean validate(String[] a, int k){
        boolean res=true;
        for(int i=1; i<k;i++ ){
            if(k!=i && a[i]!=null){
                if(a[k].equals(a[i])){
                    res=false;
                    break;
                }
            }
        }
        return res;
    }
    private static void printPerm(String[] a){
        String s="[";
        for(int i=1; i<a.length; i++){
            s+=a[i]+",";
        }
        s+="]";
        System.out.println(s);
    }

    public static void main(String[] args) {
        number_of_char=chars.length;
        String[] a=new String[number_of_char+1];
        backtrack(a, 0);
    }
}

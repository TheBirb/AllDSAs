package backtracking;

import javax.management.MBeanAttributeInfo;
import java.nio.file.WatchEvent;

public class KnapsackProblem {
    private static int[] weight={0,3,5,9,5};
    private static int[] value={0,45,30,45,10};
    private static boolean finished=false;
    private static int[] valw;
    private static final int MAX_CANDIDATES= weight.length+1;

    private static void backtrack(int[] a, int k, int maxweight){
        if (done(a,k,maxweight)) {
            finished=true;
            printBag(a,k);
        }else{
            k++;
            int c[]= new int[MAX_CANDIDATES];
            int ncandidates= candidateMaker(c,a,k,maxweight);
            for(int i=0; i<ncandidates; i++){
                a[k]=c[i];
                backtrack(a,k,maxweight);
                if(finished){ return; }
            }
        }

    }
    private static int candidateMaker(int[] c, int[] a, int k , int max){
        int actualWeight=0;
        boolean[] already= new boolean[a.length];
        for(int i=1; i<k; i++){
            actualWeight+=weight[a[i]];
            if(i==a[i]){
                already[i]=true;
            }else{
                already[i]=false;
            }

        }
        int ret=0;
        boolean valid=true;
        //1.que sea el max valor
        //2.que no este en el vector ya
        for(int i=1; i<weight.length;i++){
            if(already[i]){
                valid=false;
            }else{
                if(!checkMax(i,c, ret, already,actualWeight,max)){
                    valid=false;

                }
            }
            if(valid){

                c[ret]=i;
                ret++;
            }
            valid=true;
        }
        return ret;
    }
    private static boolean checkMax(int index,int[] c, int ret, boolean[] processed, int actualWeight, int maxW){
        int max=valw[index];
        boolean valid=true;
        for(int j=1; j<valw.length; j++){
            if(!processed[j] && index!=j){
                if(!check(j, c, ret)){
                    if(max<valw[j] && actualWeight+weight[j]<=maxW){
                       valid=false;
                       break;
                    }
                }
            }
        }
        if(actualWeight+weight[index]>maxW){
            valid=false;
        }
        return valid;
    }
    private static boolean check( int index, int[] c , int ret){
        boolean valid=false;
       for(int i=0; i<ret; i++){
           if(c[i]==index){
               valid=true;
               break;
           }
       }
       return valid;
    }

    private static boolean done(int[] a, int k, int max){
        int w=0; //total weight
        boolean[] inback= new boolean[weight.length];
        for(int i=1; i<=k; i++){
            w+=weight[a[i]];
            inback[a[i]]=true;
        }
        boolean end=true;
        for(int i=1;i<weight.length; i++){
            if(!inback[i]){
                if(weight[i]+w<=max){
                    end=false;
                    break;
                }
            }
        }
        return end;
    }
    private static void printBag(int[] a, int k){
        String ret="[";
        for(int i=1; i<=k; i++){
            ret+="| Weight: "+weight[a[i]]+" Value: "+value[a[i]];
        }
        System.out.println(ret);
    }
    private static void init(){
         valw= new int[weight.length];
        for(int i=1; i<weight.length; i++){
            valw[i]=value[i]/weight[i];
        }
        int[] a = new int[weight.length];
        backtrack(a,0, 16);

    }

    public static void main(String[] args) {
        init();
    }
}

package graphs;

public class test {

    public static void main(String[] args) {
        test n= new test();
        String a="a";
        String b="b";
        System.out.println(n.compare(a,b));

    }

    public int compare(String a, String b){
        int cmp= a.compareTo(b);
        if(cmp>0){
            return 1;
        }else if(cmp<0){
            return -1;
        }else{
            return cmp;
        }
    }
}

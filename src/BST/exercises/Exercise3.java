package BST.exercises;
import BST.*;

import java.util.Scanner;

public class Exercise3 {

    public int largestPath(BST tree){
        return largestPath(tree.root);
    }
    private int largestPath(BSTNode x){
        int depth=-1;
        if(x==null){
            depth=0;
        }else{
            depth=Math.max(largestPath(x.getRight()),largestPath(x.getLeft()))+1;
        }
        return depth;
    }
    //Test client
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        BST tree1= new BST();
        int n= s.nextInt();
        for (int i = 0; i < n; i++) {
            int insert= s.nextInt();
            tree1.add(insert);
        }
        Exercise3 ex= new Exercise3();
        System.out.println(ex.largestPath(tree1));
    }


}

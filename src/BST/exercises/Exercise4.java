package BST.exercises;
import BST.*;

import java.util.Scanner;

public class Exercise4 {
    public int nAtLevel(int level, BST tree){
        return nAtLevel(level,0,tree.root);
    }
    private int nAtLevel(int target, int actual, BSTNode x){
        int res=-1;
        if(x==null){
            res=0;
        }else if(actual==target){
            res=1;
        }else{
            actual++;
            res=nAtLevel(target,actual, x.getRight())+nAtLevel(target, actual, x.getLeft());
        }
        return res;
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
        int target=s.nextInt();
        Exercise4 ex= new Exercise4();
        System.out.println(ex.nAtLevel(target,tree1));
    }
}

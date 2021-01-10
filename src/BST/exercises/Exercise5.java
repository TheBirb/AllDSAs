package BST.exercises;
import BST.*;
import DSAdefault.graphs.StdOut;

import java.net.StandardSocketOptions;
import java.util.Scanner;

public class Exercise5 {

    public void nAtLevels(BST tree){
        int actualLevel=0;
        while(true){
            int res=traverser(actualLevel, 0, tree.root);
            if(res==0){
                break;
            }
            System.out.println("["+actualLevel+"]"+" Number of elements: "+ res);
            actualLevel++;
        }
    }
    private int traverser(int target, int level, BSTNode x){
        int res=-1;
        if(x==null){
            res=0;
        }else{
            if(target==level){
                res=1;
            }else{
                level++;
                res=traverser(target, level, x.getLeft())+traverser(target, level, x.getRight());
            }
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
        Exercise5 ex= new Exercise5();
        ex.nAtLevels(tree1);
    }
}

package BST.exercises;

import BST.*;

import java.util.Scanner;

public class Exercise7 {

    public void maxAtLevels(BST tree){
        int level=0;
        while(true){
            int ret=traverse(tree.root,0,level);
            if(ret==0){
                break;
            }
            System.out.println("["+level+"]"+" "+"Max: "+ret);
            level++;
        }
    }
    public int traverse(BSTNode x, int actual, int target){
        int ret=0;
        if(x==null){
            ret=0;
        }else{
            if(actual==target){
                ret=x.getElement();
            }else{
                actual++;
                ret=Math.max(traverse(x.getLeft(), actual, target), traverse(x.getRight(),actual,target));
            }
        }
        return ret;
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
        Exercise7 ex= new Exercise7();
        ex.maxAtLevels(tree1);
    }
}

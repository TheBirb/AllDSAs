package BST.exercises;


import BST.*;

import java.util.Scanner;


public class Exercise1 {

    public boolean areEqual(BST tree1, BST tree2){
        return areEqual(tree1.root, tree2.root);
    }
    private boolean areEqual(BSTNode x1, BSTNode x2){
        boolean res=true;
        if(x1==null){
            if(x2!=null){
                res= false;
            }else{
                res= true;
            }
        }else if(x2==null){
            if(x1!=null){
                res= false;
            }else{
                res= true;
            }
        }else if(x1.getElement()==x2.getElement()){
            res=areEqual(x1.getLeft(), x2.getLeft()) && areEqual(x1.getRight(),x2.getRight());
        }else{
            res= false;
        }
        return res;
    }
    //Test client
    public static void main(String[] args) {
        BST tree1= new BST();
        BST tree2= new BST();
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        for (int i = 0; i < n; i++) {
            int insert= s.nextInt();
            tree1.add(insert);
            tree2.add(insert);
        }
        Exercise1 ex= new Exercise1();
        System.out.println(ex.areEqual(tree1,tree2));
    }
}

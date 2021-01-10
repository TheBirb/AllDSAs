package BST.exercises;

import BST.BST;
import BST.BSTNode;

import java.util.LinkedList;
import java.util.Scanner;

public class Exercise2 {

    public LinkedList<Integer> leafList(BST tree){
        LinkedList<Integer> leaflist= new LinkedList<Integer>();
        return leafList(leaflist, tree.root);
    }
    private LinkedList<Integer> leafList(LinkedList<Integer> list, BSTNode x){

            if(x.getLeft()==null && x.getRight()==null){
                list.add(x.getElement());
            }else {
                if (x.getRight() == null) {
                    list = leafList(list, x.getLeft());
                } else if (x.getLeft() == null) {
                    list = leafList(list, x.getRight());
                } else {
                    list = leafList(list, x.getLeft());
                    list = leafList(list, x.getRight());
                }
            }
        return list;
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
        Exercise2 ex= new Exercise2();
        System.out.println(ex.leafList(tree1));
    }
}

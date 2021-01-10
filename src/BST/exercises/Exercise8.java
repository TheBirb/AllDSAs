package BST.exercises;

import BST.BST;
import DSAdefault.graphs.StdOut;

public class Exercise8 {

    public void expressionMaker(BinarySearchTree<String> tree){
        System.out.println(traverse(tree.root));
    }
    private String traverse(BinaryTreeNode<String> x){
        String ret="";
        if(x==null){
            ret="";
        }else{
            if(x.right==null && x.left==null){
                ret=x.element;
            }else{
                ret="("+traverse(x.left)+x.element+traverse(x.right)+")";
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        BinarySearchTree<String> tree= new BinarySearchTree<String>();
        tree.add("+",20);
        tree.add("/",10);
        tree.add("+",5);
        tree.add("2",11);
        tree.add("5",1);
        tree.add("3",6);
        tree.add("*",30);
        tree.add("-", 25);
        tree.add("1",24);
        tree.add("5", 26);
        tree.add("2", 31);
        Exercise8 ex= new Exercise8();
        ex.expressionMaker(tree);

    }
}

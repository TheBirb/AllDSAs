package BST.exercises;

import BST.BST;

import java.util.Scanner;

public class Exercise6 {



    //Test client
    public static void main(String[] args) {
        BinarySearchTree<String> tree1= new BinarySearchTree<String>();
        tree1.add("tree", 20);
        tree1.add("Solarium",10);
        tree1.add("tree",17);
        tree1.add("Google",18);
        tree1.add("tree",12);
        tree1.add("tree",16);
        tree1.add("tree",11);
        tree1.add("Penta",8);
        tree1.add("Google",6);
        tree1.add("Solo",9);
        tree1.add("Penta",23);
        tree1.add("tree",30);
        tree1.add("tree",25);
        tree1.add("Quadra",24);
        tree1.add("tree",32);
        tree1.add("Penta",31);

        Exercise6 ex= new Exercise6();
        System.out.println(tree1.appears("tree", 8));
    }
}

package BST.exercises;

import BST.*;
import queues.Queue;

import java.util.Scanner;

public class Exercise9 {

    public Queue<Integer> find2Min(BST tree){
        Queue<Integer> queue= new Queue<Integer>();
        queue=traverse(queue,tree.root);
        return queue;
    }
    public Queue<Integer> traverse(Queue<Integer> queue,BSTNode x){
        if(x.getLeft()==null){
            queue.enqueue(x.getElement());
        }else{
            queue=traverse(queue,x.getLeft());
            if(queue.size()==1){
                queue.enqueue(x.getElement());
            }
        }
        return queue;
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
        Exercise9 ex= new Exercise9();
        System.out.println(ex.find2Min(tree1));
    }
}

package BST;

import linkedlists.IntegerLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class BST implements Iterable{
    //Param
    BSTNode root;

    /**
     * Constructor
     */
    public BST(){
        root=null;
    }

    /**
     * Method used to add an element to the tree
     * @param element
     */
    public void add(int element){
        root=add(root, element);
    }
    private BSTNode add(BSTNode x, int element){
        if(x==null){
            return new BSTNode(element);
        }else{
            int cmp=x.compareTo(element);
            if(cmp>0){
                x.left=add(x.left, element);
            }else if(cmp<0){
                x.right=add(x.right, element);
            }else{
                x.element=element;
            }
        }
        x.N=1+size(x.left)+size(x.right);
        return x;
    }

    /**
     * Method used to delete an element from the tree
     * @param element
     */
    public void delete(int element){
        if(!contains(element)){
            System.out.println("The element is not in the tree");
        }else{
            root=delete(root, element);
        }

    }
    public BSTNode delete(BSTNode x, int element){
        if(x==null){
            return null;
        }else{
            int cmp=x.compareTo(element);
            if(cmp>0){
                x.left=delete(x.left, element);
            }else if(cmp<0){
                x.right= delete(x.right, element);
            }else{
                if(x.left==null) return x.right;
                if(x.right==null) return x.left;
                BSTNode t=x;
                x=min(t.right);
                x.right=deleteMin(t.right);
                x.left=t.left;
            }
            x.N=size(x.left)+size(x.right);
            return x;
        }
    }

    /**
     * Method used to delete the smallest element form the tree
     */
    public void deleteMin(){
        root=deleteMin(root);
    }
    private BSTNode deleteMin(BSTNode x){
        if(x.left==null){
            if(x.right!=null){
                return x.right;
            }else{
                return null;
            }
        }else{
            return deleteMin(x.left);
        }
    }
    public BSTNode min(){
        return min(root);
    }

    /**
     * Method used to return a reference to the smallest element of the tree
     * @param x
     * @return
     */
    private BSTNode min(BSTNode x){
        if(x.left==null){
            return x;
        }else{
            return min(x.left);
        }
    }

    public BSTNode max(){
        return max(root);
    }

    /**
     * Method used to return a reference to the biggest element of the tree
     * @param x
     * @return
     */
    private BSTNode max(BSTNode x){
       if(x.right==null){
           return x;
       }else{
           return max(x.right);
       }
    }

    /**
     * Method used to delete the biggest value of the tree
     */
    public void deleteMax(){
        root=deleteMax(root);
    }
    private BSTNode deleteMax(BSTNode x){
        if(x.right==null){
            if(x.left!=null){
                return x.left;
            }else{
                return x;
            }
        }else{
            return max(x.right);
        }
    }

    /**
     * Method used to calculate the number of nodes below the given one
     * @param x
     * @return
     */
    public int size(BSTNode x){
        if(x==null){
            return 0;
        }else{
            return 1+size(x.left)+size(x.right);
        }
    }

    /**
     * Method used to check if an element is in the tree or not
     * @param element
     * @return
     */
    public boolean contains(int element){
        return contains(root, element);
    }
    private boolean contains(BSTNode x, int element){
        if(x==null){
            return false;
        }else{
            int cmp=x.compareTo(element);
            if(cmp>0){
                return contains(x.left, element);
            }else if(cmp<0){
                return contains(x.right, element);
            }else{
                return true;
            }
        }
    }

    /**
     * Method used to generate an iterator
     * @return
     */
    @Override
    public Iterator iterator() {
        return inOrderLinkedList().iterator();
    }

    /**
     * Method used to create a LinkedList traversing the tree inorder
     * @return
     */
    public IntegerLinkedList inOrderLinkedList(){
        IntegerLinkedList list= new IntegerLinkedList();
        return inOrderLinkedList(root, list);

    }
    private IntegerLinkedList inOrderLinkedList(BSTNode x, IntegerLinkedList list){
        if(x!=null){
            list=inOrderLinkedList(x.left, list);
            list.addInAscendingOrder(x.element);
            list=inOrderLinkedList(x.right, list);
        }
        return list;
    }
}

package BST.exercises;

import DSAdefault.graphs.StdOut;

public class BinarySearchTree<T> {
    protected BinaryTreeNode<T> root;

    public BinarySearchTree(){

    }

    public void add(T element, Integer id){
        BinaryTreeNode<T> insert= new BinaryTreeNode<>(element, id);
        root=add(insert, root);
    }
    private BinaryTreeNode<T> add(BinaryTreeNode<T> insert, BinaryTreeNode<T> actual){
        if(actual==null){
            return insert;
        }else{
            int cmp=insert.id.compareTo(actual.id);
            if(cmp<0){
                actual.left=add(insert, actual.left);
            }else if(cmp>0){
                actual.right=add(insert, actual.right);
            }else{
                actual.element= insert.element;
            }
        }
        actual.n=size(actual);
        return actual;
    }

    public int size(BinaryTreeNode<T> x){
        int result=-1;
        if(x==null){
            result= 0;
        }else{
            result=size(x.left)+size(x.right);
        }
        return result;
    }

    public void delete(Integer id){
        root=delete(id, root);
    }
    private BinaryTreeNode<T> delete(Integer id, BinaryTreeNode<T> x){
        if(x==null){
            System.out.println("No element with the given id was found");
        }else{
            int cmp=id.compareTo(x.id);
            if(cmp<0){
                x.left=delete(id, x.left);
            }else if(cmp>0){
                x.right=delete(id, x.right);
            }else{
                BinaryTreeNode<T> temp=x;
                x=min(temp.right);
                x.right=deleteMin(temp.right);
                x.left=temp.left;
            }
            x.n=size(x);
        }
        return x;
    }

    public BinaryTreeNode<T> min(){
        return min(root);
    }
    private BinaryTreeNode<T> min(BinaryTreeNode<T> x){
        if(x.left==null){
            return x;
        }else{
            return min(x.left);
        }
    }
    public void deleteMin(){
        root=deleteMin(root);
    }
    private BinaryTreeNode<T> deleteMin(BinaryTreeNode<T> x){
        if(x.left==null){
            if(x.right!=null){
                x= x.right;
            }else
                x=null;
        }else{
            x.left=deleteMin(x.left);
        }
        return x;
    }

    public boolean appears(T element, int n){
        int res=appears(root, element);
        System.out.println(res);
        return n==res;
    }
    private int appears(BinaryTreeNode<T> x, T element){
        int res=0;
        if(x==null){
           res=0;
        }else{
            if(element.equals(x.element)){
                res+=appears(x.left,element)+appears(x.right,element)+1;
            }else{
                res+=appears(x.left,element)+appears(x.right,element);
            }
        }
        return res;
    }

}

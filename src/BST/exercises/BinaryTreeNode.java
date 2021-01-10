package BST.exercises;

public class BinaryTreeNode<T> {
    protected Integer id;
    protected T element;
    protected BinaryTreeNode<T> right;
    protected BinaryTreeNode<T> left;
    protected int n;
    public BinaryTreeNode(){

    }
    public BinaryTreeNode(T element, int id){
        this.element=element;
        this.id=id;
        n=0;
    }
}

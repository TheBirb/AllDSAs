package BST;

public class BSTNode implements Comparable {
    int element;
    BSTNode right, left;
    int N;


    public BSTNode(int element){
        this.element=element;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.element, (Integer)o);

    }
}

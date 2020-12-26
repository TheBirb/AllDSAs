package stacks;

public class Node<T> {
    //Parameters
    private Node next;
    private T element;

    /**
     * Constructor
     * @param element
     */
    public Node(T element){
        this.element=element;
    }

    /**
     * Method used to set the next node
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Method used to get the next node
     * @return next node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Method used to return a reference of the element
     * @return
     */
    public T getElement(){
        return element;
    }

}

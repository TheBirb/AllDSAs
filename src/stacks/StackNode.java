package stacks;

public class StackNode<T> {
    //Parameters
    private StackNode next;
    private T element;

    /**
     * Constructor
     * @param element
     */
    public StackNode(T element){
        this.element=element;
    }

    /**
     * Method used to set the next node
     * @param next
     */
    public void setNext(StackNode next) {
        this.next = next;
    }

    /**
     * Method used to get the next node
     * @return next node
     */
    public StackNode getNext() {
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

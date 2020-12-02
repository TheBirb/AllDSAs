package LinkedLists;

public class Node<T> {
    Node next;
    T element;
    public Node(T element){
        this.element=element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}

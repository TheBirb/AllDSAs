package queues;

import stacks.Node;

import java.util.Iterator;

public class QueueIterator<T> implements Iterator {

    Node<T> actual;
    public QueueIterator(Node<T> first){
        this.actual=first;
    }
    @Override
    public boolean hasNext() {
        return actual!=null;
    }

    @Override
    public T next() {
        T element= actual.getElement();
        actual=actual.getNext();
        return element;
    }
}

package queues;

import exceptions.EmptyCollectionException;
import stacks.Node;

import java.sql.SQLOutput;
import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    //Parameters
    private Node<T> first;
    private Node<T> last;
    private int count;

    /**
     * Constructor
     */
    public Queue(){
        first=null;
        last=null;
        count=0;
    }

    /**
     * Method used to add an element to the rear of the Queue
     * @param element
     */
    public void enqueue(T element){
        Node<T> insert= new Node<T>(element);
        if(isEmpty()){
            first=insert;
            last=insert;
            count++;
        }else{
            last.setNext(insert);
            last=insert;
            count++;
        }
    }

    /**
     * Method used to remove the first element from the queue and return an instance from the element
     * @return
     * @throws EmptyCollectionException
     */
    public T dequeue() throws EmptyCollectionException {

        if(isEmpty()){
            throw new EmptyCollectionException("queue");
        }else{
           T ret=first.getElement();
           first=first.getNext();
           count--;
           return ret;
        }

    }

    /**
     * Method used to get the first element of the queue without removing it from the Queue
     * @return
     * @throws EmptyCollectionException
     */
    public T first() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("queue");
        }else{
            return first.getElement();
        }
    }

    /**
     * Method used to check if the Queue is Empty
     * @return
     */
    public boolean isEmpty(){
        return first==null;
    }

    /**
     * Method used to check the size of the Queue
     * @return
     */
    public int size(){
        return count;
    }

    /**
     * Method used to get a String with the contents of the queue
     * @return
     */
    public String toString(){
        Node<T> actual=first;
        String ret="[";
        while(actual!=null){
            ret+=actual.getElement()+", ";
            actual=actual.getNext();
        }
        ret+="]";
        return ret;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator(first);
    }
}

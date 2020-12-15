package linkedlists.examNov2020;



import linkedlists.DoubleNode;

import java.util.Iterator;

public class ReverseDoubleLinkedListIterator implements Iterator<NodeCustomer> {

    //Param
    private NodeCustomer actual;
    public ReverseDoubleLinkedListIterator(NodeCustomer node){
        actual=node;
    }

    @Override
    public boolean hasNext() {
        return actual!=null;
    }

    @Override
    public NodeCustomer next() {
        NodeCustomer temp=actual;
        actual=actual.previous;
        return temp;
    }
}

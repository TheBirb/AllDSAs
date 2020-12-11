package linkedlists;

import java.util.Iterator;

public class IntegerLinkedListIterator implements Iterator {
    //Parameters
    private IntegerNode actual;

    /**
     * Constructor
     * @param first
     */
    public IntegerLinkedListIterator(IntegerNode first){
        actual=first;
    }

    /**
     * Checks if the node is not null
     * @return boolean
     */
    @Override
    public boolean hasNext() {
      return actual!=null;
    }

    /**
     * Method used to return a reference of the node
     * @return actual node
     */
    @Override
    public IntegerNode next() {
       IntegerNode temp=actual;
       actual=actual.getNext();
        return temp;
    }
}

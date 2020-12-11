package linkedlists;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class IntegerLinkedList implements Iterable{
    //Parameters
    IntegerNode first;
    IntegerNode last;
    int count;

    /**
     * Constructor
     */
    public IntegerLinkedList(){
        count=0;
    }

    /**
     * Method used to add elements in front of the LinkedList
     * @param element, integer
     */
    public void AddToFront(int element){
        IntegerNode insert= new IntegerNode(element);
        if(first==null){//list is empty
            first=insert;
            last=insert;
            count++;
        }else{//list has elements
            insert.setNext(first);
            first=insert;
            count++;
        }
    }

    /**
     * Method used to add elements at the rear of the LinkedList
     * @param element, integer
     */
    public void AddToRear(int element){
        IntegerNode insert= new IntegerNode(element);
        if(first==null){
            first=insert;
            last=insert;
            count++;
        }else{
            last.setNext(insert);
            insert.setNext(null);
            last=insert;
            count++;
        }
    }
    /**
     * Adds elements to the linked list in Ascending order
     * @param element, integer
     */
    public void AddInAscendingOrder(int element){
        IntegerNode insert= new IntegerNode(element);
        if(first==null){//list is empty
            first=insert;
            last=insert;
            count++;
        }else{
            IntegerNode prev=null;
            IntegerNode actual=first;

            while(actual!=null){//search for the position
                if(actual.getElement()>=insert.getElement()){
                    break;
                }else{
                    prev=actual;
                    actual=actual.getNext();
                }
            }
            if(actual==null){//last
                prev.setNext(insert);
                last=insert;
                count++;
            }else if(actual.equals(first)){//first
                insert.setNext(first);
                first=insert;
                count++;
            }else{//between two nodes
                insert.setNext(actual);
                prev.setNext(insert);
                count++;
            }
        }
    }

    /**
     * Adds elements to the linked list in Ascending order
     * @param element, integer
     */
    public void AddInDescendingOrder(int element){
        IntegerNode insert= new IntegerNode(element);
        if(first==null){//empty list
            first=insert;
            last=insert;
            count++;
        }else{
            IntegerNode prev=null;
            IntegerNode actual=first;
            while(actual!=null){//search for the position
                if(element>=actual.getElement()){
                    break;
                }else{
                    prev=actual;
                    actual=actual.getNext();
                }
            }
            if(actual==null){//last
                prev.setNext(insert);
                last=insert;
                count++;
            }else if(actual.equals(first)){//first
                insert.setNext(first);
                first=insert;
                count++;
            }else{//between two nodes
                insert.setNext(actual);
                prev.setNext(insert);
                count++;
            }
        }
    }

    /**
     * Method used to delete an element from the list
     * @param element
     */
    public void delete(int element){
        if(!contains(element)) throw new NoSuchElementException();//checks if the element is in the list
        IntegerNode actual=first;
        IntegerNode prev=null;
        while(actual!=null){//searches for the element
            if(actual.getElement()==element){
                break;
            }else{
                prev=actual;
                actual=actual.getNext();
            }
        }
        if(actual.getNext()==null){//last
            prev.setNext(null);
            count--;
        }else if(actual.equals(first)){//first
            first=first.getNext();
            count--;
        }else{//between two nodes
            prev.setNext(actual.getNext());
            count--;
        }


    }

    /**
     * Method used to check the size of the list
     * @return integer
     */
    public int size(){
        return count;
    }

    /**
     * Method used to check if the list is empty
     * @return integer
     */
    public boolean isEmpty(){
        return first==null;
    }

    /**
     * Method used to check if an element is in the list
     * @param element, integer
     * @return if the given element is in the list or not
     */
    public boolean contains(int element){
        IntegerNode actual=first;
        boolean found=false;
        while(actual!=null){
            if(actual.getElement()==element){
                found=true;
                break;
            }else{
                actual=actual.getNext();
            }
        }
        return found;
    }

    /**
     * Method used to return a String with all the elements of the list
     * @return
     */
    @Override
    public String toString(){
        String res= "[";
       for(IntegerNode actual=first; actual.getNext()!=null; actual=actual.getNext()){
           res+=actual.getElement()+",";
        }
        res+=last.getElement()+"]";
        return res;
    }

    /**
     * Method used to create an iterator from the list
     * @return
     */
    @Override
    public Iterator iterator() {
        return new IntegerLinkedListIterator(first);
    }




}

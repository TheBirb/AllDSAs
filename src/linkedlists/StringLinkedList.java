package linkedlists;

import java.awt.*;
import java.util.NoSuchElementException;
import java.util.Random;

public class StringLinkedList {
    //Parameters
    StringNode first;
    StringNode last;
    int count;

    public StringLinkedList(){
       this.count=0;
    }

    /**
     * Method used to add an element to the head of the list
     * @param element
     */
    public void addToFront(String element){
        StringNode insert= new StringNode(element);
        if(first==null){
            first=insert;
            last=insert;
        }else{
            insert.setNext(first);
            first=insert;
        }
    }

    /**
     * Method used to add an element to the rear of the list
     * @param element
     */
    public void addToRear(String element){
        StringNode insert= new StringNode(element);
        if(first==null){
            first=insert;
        }else{
            last.setNext(insert);
        }
        last=insert;
    }

    /**
     * Method used to add an element in Ascending Order
     * @param element
     */
    public void addInAscendingOrder(String element){
        StringNode insert= new StringNode(element);
        if(first==null){
            first=insert;
            last=insert;
            count++;
        }else{
            StringNode prev=null;
            StringNode actual=first;
            while(actual!=null){
                if(insert.compareTo(actual.getElement())<=0){
                    break;
                }else{
                    prev=actual;
                    actual=actual.getNext();
                }
            }
            if(actual==null){//last
                last.setNext(insert);
                last=insert;
                count++;
            }else if(actual.equals(first.getElement())){//first
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
     * Method used to add an element in Descending order
     * @param element
     */
    public void addInDescendingOrder(String element){
        StringNode insert= new StringNode(element);
        if(first==null){
            first=insert;
            last=insert;
            count++;
        }else{
            StringNode prev=null;
            StringNode actual=first;
            while(actual!=null){//search for position
                if(insert.compareTo(actual.getElement())>=0){
                    break;
                }else{
                    prev=actual;
                    actual=actual.getNext();
                }
            }
           if(actual==null){//last
               last.setNext(insert);
               last=insert;
               count++;
           }else if(actual.equals(first.getElement())){
               insert.setNext(first);
               first=insert;
               count++;
           }else{
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
    public void delete(String element){
        if(!contains(element))throw new NoSuchElementException();
        StringNode prev=null;
        StringNode actual=first;
        while(actual!=null){
            if(actual.equals(element)){
                break;
            }else{
                prev=actual;
                actual=actual.getNext();
            }
        }
        if(actual.getNext()==null){
            prev.setNext(null);
            last=prev;
            count--;
        }else if(actual.equals(first.getElement())){
            first=first.getNext();
            count--;
        }else{
            prev.setNext(actual.getNext());
            count--;
        }
    }

    /**
     * Method used to know if an element is in the list
     * @param element
     * @return boolean
     */
    public boolean contains(String element){
        StringNode actual=first;
        while(actual!=null){
            if(actual.equals(element)){
                return true;
            }else{
                actual=actual.getNext();
            }
        }
        return false;
    }
    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return first==null;
    }

    /**
     * Method used to convert the list into a String
     * @return String containing the list
     */
    @Override
    public String toString(){
        StringNode actual=first;
        String out="[";
        while(actual!=null){
            out+=actual.getElement()+", ";
            actual=actual.getNext();
        }
        out+="]";
        return out;
    }
    //Test client
    public static void main(String[] args) {
        StringLinkedList list= new StringLinkedList();
        list.addInDescendingOrder("a");
        list.addInDescendingOrder("b");
        list.addInDescendingOrder("d");
        list.addInDescendingOrder("c");
        System.out.println(list.toString());

    }
}

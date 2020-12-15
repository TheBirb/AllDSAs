package linkedlists;

import java.util.NoSuchElementException;

public class DoubleLinkedList {
    //Parameters
    DoubleNode first;
    DoubleNode last;
    int count=0;

    public DoubleLinkedList(){
        count=0;
    }

    /**
     * Method used to add an element to the rear of the list
     * @param element
     */
    public void addToRear(int element){
        DoubleNode insert= new DoubleNode(element);
        if(first==null){
            first=insert;
            last=insert;
            count++;
        }else{
            last.setNext(insert);
            insert.setPrev(last);
            last=insert;
        }
    }

    /**
     * Method used to add an element to the front of the list
     * @param element
     */
    public void addToFront(int element){
        DoubleNode insert= new DoubleNode(element);
        if(first==null){
            first=insert;
            last=insert;
            count++;
        }else{
            insert.setNext(first);
            first.setPrev(insert);
            first=insert;
            count++;
        }
    }

    /**
     * Method used to add an element in ascending order to the list
     * @param element
     */
    public void addInAscendingOrder(int element){
        DoubleNode insert= new DoubleNode(element);
        if(first==null){//list is empty
            first=insert;
            last=insert;
            count++;
        }else{
            DoubleNode actual=first;
            while(actual!=null){//search for pos
                if(insert.getElement()<actual.getElement()){
                    break;
                }else{
                    actual=actual.getNext();
                }
            }

            if(actual==null){//last
                last.setNext(insert);
                insert.setPrev(last);
                last=insert;
                count++;
            }else if(actual.equals(first.getElement())){//first
                insert.setNext(first);
                first.setPrev(insert);
                first=insert;
                count++;
            }else{//unknown position
                insert.setNext(actual);
                insert.setPrev(actual.getPrev());
                actual.getPrev().setNext(insert);
                actual.setPrev(insert);
                count++;

            }
        }
    }

    /**
     * Method used to add elements to the list in descending order
     * @param element
     */
    public void addInDescendingOrder(int element){
        DoubleNode insert= new DoubleNode(element);
        if(first==null){
            first=insert;
            last=insert;
            count++;
        }else{
            DoubleNode actual=first;
            while(actual!=null){
                if(insert.getElement()>actual.getElement()){
                    break;
                }else{
                    actual=actual.getNext();
                }
            }
            if(actual==null){
                last.setNext(insert);
                insert.setPrev(last);
                last=insert;
                count++;
            }else if (actual.equals(first.getElement())){
                insert.setNext(first);
                first.setPrev(insert);
                first=insert;
                count++;
            }else{
                insert.setNext(actual);
                insert.setPrev(actual.getPrev());
                actual.getPrev().setNext(insert);
                actual.setPrev(insert);
                count++;
            }
        }
    }

    /**
     * Method used to delete an element from the list.
     * If the element is not in the list an exception is raised.
     * @param element
     */
    public void delete(int element){
        if(!contains(element)) throw new NoSuchElementException();
        DoubleNode actual=first;
        while(actual!=null){
            if(actual.equals(element)){
                break;
            }else{
                actual=actual.getNext();
            }
        }
        if(actual.getNext()==null){//last
            last=actual.getPrev();
            last.setNext(null);
            count--;
        }else if(actual.equals(first.getElement())){
            first=first.getNext();
            first.setPrev(null);
            count--;
        }else{
            actual.getNext().setPrev(actual.getPrev());
            actual.getPrev().setNext(actual.getNext());
            count--;
        }
    }



    /**
     * Method used to check if an element is in the list
     * @param element
     * @return
     */
    public boolean contains(int element){
        boolean res=false;
        if(!this.isEmpty()){
            DoubleNode actual=first;
            while(actual!=null){
                if(actual.equals(element)){
                    res=true;
                    break;
                }else{
                    actual=actual.getNext();
                }
            }
        }
        return res;
    }

    /**
     * Method used to check the size of the list
     * @return int
     */
    public int size(){
        return count;
    }

    /**
     * Method used to check if list is empty
     * @return boolean
     */
    public boolean isEmpty(){
        return first==null;
    }

    /**
     * Method used to create an String with all the element from the list
     * @return
     */
    @Override
    public String toString(){
        DoubleNode actual= first;
        String out="[";
        while(actual!=null){
            out+=actual.getElement()+",";
            actual=actual.getNext();
        }
        out+="]";
        return out;
    }
    //Test client
    public static void main(String[] args) {
        DoubleLinkedList list= new DoubleLinkedList();
        list.addInDescendingOrder(1);
        list.addInDescendingOrder(5);
        list.addInDescendingOrder(3);
        list.addInDescendingOrder(8);
        System.out.println(list.toString());
        System.out.println(list.toString());
        System.out.println(list.first.getElement());
        System.out.println(list.last.getElement());
    }
}

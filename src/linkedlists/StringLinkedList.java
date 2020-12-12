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

    public void addToRear(String element){
        StringNode insert= new StringNode(element);
        if(first==null){
            first=insert;
        }else{
            last.setNext(insert);
        }
        last=insert;
    }

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

    public static void main(String[] args) {
        StringLinkedList list= new StringLinkedList();
        list.addInDescendingOrder("a");
        list.addInDescendingOrder("b");
        list.addInDescendingOrder("d");
        list.addInDescendingOrder("c");
        System.out.println(list.toString());

    }
}

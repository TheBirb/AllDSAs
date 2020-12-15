package linkedlists;

import java.util.Objects;

public class DoubleNode{
    int element;
    DoubleNode prev;
    DoubleNode next;
    public DoubleNode(int element){
        this.element=element;
        prev=null;
        next=null;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public int getElement() {
        return element;
    }


    @Override
    public boolean equals(Object o) {
      return this.element==(int)o;
    }


}

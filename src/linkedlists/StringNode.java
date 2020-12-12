package linkedlists;

import javax.swing.*;

public class StringNode implements Comparable{
    StringNode next;
    String element="";

    public StringNode(String element){
        this.element=element;
    }
    public String getElement(){
        return element;
    }
    public StringNode getNext(){
        return next;
    }
    public void setNext(StringNode next){
        this.next=next;
    }




    @Override
    public int compareTo(Object o) {
       int cmp= this.element.compareTo((String) o);
        if(cmp>0){
            return 1;
        }else if(cmp<0){
            return -1;
        }else{
            return cmp;
        }
    }
    @Override
    public boolean equals(Object o){
        return this.element.equals((String)o);
    }


}

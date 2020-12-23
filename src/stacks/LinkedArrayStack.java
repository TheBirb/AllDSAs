package stacks;

import java.util.LinkedList;

public class LinkedArrayStack<T> {
    //Parameters
    private StackNode<T> top;
    private int count;

    /**
     * Constructor
     */
    public LinkedArrayStack(){
        count=0;
        top=null;
    }

    /**
     * Method used to add an element to the top of the stack
     * @param element
     */
    public void push(T element){
        StackNode insert= new StackNode(element);
        if(isEmpty()){
            top=insert;
        }else{
            insert.setNext(top);
            top=insert;
        }
        count++;
    }

    /**
     * Method used to return a reference of the element at the top
     * @return
     */
    public T peek(){
        T ret= top.getElement();
        return ret;
    }

    /**
     * Method used to delete and return the top element of the stack
     * @return
     */
    public T pop(){
        T ret=top.getElement();
        top=top.getNext();
        count--;
        return ret;
    }

    /**
     * Method used to check if the stack is empty
     * @return
     */
    public boolean isEmpty(){
        return top==null;
    }

    /**
     * Method used to check the size of the stack
     * @return
     */
    public int size(){
        return count;
    }

    /**
     * Method used to create an String with the contents of the Stack
     * @return
     */
    public String toString(){
        StackNode actual=top;
        String ret="[";
        while(actual!=null){
            ret+=actual.getElement()+", ";
            actual=actual.getNext();
        }
        ret+="]";
        return ret;
    }
    //Test client
    public static void main(String[] args) {
        LinkedArrayStack<Integer> stack= new LinkedArrayStack();
        stack.push(4);
        stack.push(6);
        System.out.println(stack.peek());
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.toString());
    }

}

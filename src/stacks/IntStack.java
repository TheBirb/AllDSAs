package stacks;

import exceptions.EmptyCollectionException;



public class IntStack {
    //Parameters
    final int INIT_SIZE=10;
    int last=0;
    int[] arr;

    /**
     * Constructor
     */
    public IntStack(){
        arr= new int[INIT_SIZE];
    }

    /**
     * Method used to add an element to the stack
     * @param element
     */
    public void push(int element){
        check();
        arr[last]=element;
        last++;

    }

    /**
     * Method used to return the element on the front of the stack
     * @return
     * @throws EmptyCollectionException, exception throwed if the stack is empty
     */
    public int pop(){
        int ret=-1;
        if(!isEmpty()){
            last--;
             ret= arr[last];
        }else{
            System.out.println("The stack is empty");
        }
        check();
        return ret;
    }

    /**
     * Method used to resize the array
     * @param newSize
     */
    public void resize(int newSize){
        int[] newArr = new int[newSize];
        for(int i=0;i<last; i++){
            newArr[i]=arr[i];
        }
        arr=newArr;
    }

    /**
     * Method used to check if the stack is empty
     * @return
     */
    public boolean isEmpty(){
        return last==0;
    }

    /**
     * Method that return the size of the stack
     * @return
     */
    public int size(){
        return last;
    }
    /**
     * Method used to check the size of the array,
     * if the array is smaller than the last index, then it resizes it with double the size of the actual array,
     * if the array is two times bigger than the last index, then it resizes it with half the size.
     */
    public void check(){
        if(last<arr.length/2){
            resize(arr.length/2);
        }else if(last>=arr.length){
            resize(arr.length*2);
        }
    }
}

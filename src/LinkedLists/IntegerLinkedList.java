package LinkedLists;

import java.util.Random;

public class IntegerLinkedList<T> {
    IntegerNode first;
    IntegerNode last;
    int count=0;
    public IntegerLinkedList(){

    }
    //TODO
    public void add(int element){
        IntegerNode x= new IntegerNode(element);
        if(first==null){
            first=x;
            last=x;
            count++;
        }else{
            last.next=x;
            x.next=null;
            last=x;
            count++;
        }
    }

    /**
     * Adds elements to the linked list in Ascendant order
     * @param element, integer
     */
    public void addInOrderAscend(int element){
        IntegerNode x= new IntegerNode(element);
        if(first==null){
            first=x;
            last=x;
            count++;
        }else{
            IntegerNode prev=null;
            IntegerNode actual=first;
            while(actual!=null){
                int cmp=x.compareTo(actual);
                if(cmp<0){//If its smaller
                    if(actual.equals(first)){
                        x.next=actual;
                        first=x;
                        count++;
                        break;
                    }else{
                        x.next=actual;
                        prev.next=x;
                        count++;
                        break;
                    }
                }else if (cmp>0){//If it is bigger
                    if(actual.next==null){
                        actual.next=x;
                        last=x;
                        count++;
                        break;
                    }else{
                        prev=actual;
                        actual=actual.next;
                    }
                }else{//If it is equal
                    if(actual.next==null){
                        actual.next=x;
                        last=x;
                        count++;
                        break;
                    }else{
                        x.next=actual;
                        prev.next=x;
                        count++;
                        break;
                    }
                }
            }
        }

    }
    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return count==0;
    }
    public void addInOrderDescend(IntegerNode x){

    }
    //TODO
    public void delete(){

    }
    //TODO
    public boolean contains(){
        return false;
    }
    @Override
    public String toString(){
        String res= "[";
       for(IntegerNode actual=first; actual!=null; actual=actual.next){
           res+=actual.getElement()+",";
        }
        res+="]";
        return res;
    }

    /**
     * Test case
     * @param args
     */
    public static void main(String[] args) {
        IntegerLinkedList list= new IntegerLinkedList();
        Random r= new Random();
        int n=3000;
        for(int i=0; i<n; i++){
            list.addInOrderAscend(Math.abs(r.nextInt()%n));
        }
        System.out.println(list.toString());
    }


}

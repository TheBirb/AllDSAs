package linkedlists;

public class IntegerNode implements Comparable<IntegerNode>{
    private IntegerNode next;
    private int element;
    public IntegerNode(int element){
        this.element=element;
    }

    public IntegerNode getNext() {
        return next;
    }

    public void setNext(IntegerNode next) {
        this.next = next;
    }

   public int getElement(){
        return element;
   }

    public void setElement(Integer element) {
        this.element = element;
    }

    @Override
    public int compareTo(IntegerNode o) {
        if(element>o.getElement()){
            return 1;
        }else if(element<o.getElement()){
            return -1;
        }else{
            return 0;
        }
    }

    public boolean equals(IntegerNode x){
        if(this.element==x.element){
            return true;
        }else{
            return false;
        }
    }
}

package hashTable;

import queues.Queue;
import stacks.Node;

public class SequentialSearchST<Key, Value>{
    private int N; //number of key-value pairs
    private HashNode first; //the linked list of key-value pairs

    /**
     * Method used to check the size of the linked list
     * @return
     */
    public int size(){
        return N;
    }

    /**
     * Method used to check if the list is empty
     * @return
     */
    public boolean isEmpty(){
        return size()==0;
    }

    /**
     * Method used to check if the linkedlist contains an element
     * with the given key
     * @param key
     * @return
     */
    public boolean contains(Key key){
        return get(key) !=null;
    }

    /**
     * Method used to get the value of the element with the given key
     * @param key
     * @return
     */
    public Value get(Key key){
        for(HashNode x= first; x!=null; x=x.next){
            if(key.equals(x.key)){
                return (Value) x.val;
            }
        }
        return null;
    }

    /**
     * Method used to add an element to the linked list
     * @param key
     * @param val
     */
    public void put(Key key, Value val){
        if(val==null){
            delete(key);
            return;
        }
        for(HashNode x=first; x!=null; x=x.next){
            if(key.equals(x.key)){
                x.val=val;
                return;
            }
        }
        first=new HashNode(key, val, first);
        N++;
    }

    /**
     * Method used to remove key-value pair with given key
     * @param key
     */
    public void delete(Key key){
        first=delete(first, key);
    }

    /**
     * Method used to delete key in linked list
     * @param x
     * @param key
     * @return
     */
    public HashNode delete(HashNode x, Key key){
        if(x==null) return null;
        if(key.equals(x.key)){
            N--;
            return x.next;
        }
        x.next=delete(x.next,key);
        return x;
    }

    /**
     * Returns all keys as an Iterable
     * @return
     */
    public Iterable<Key> keys(){
        Queue<Key> queue= new Queue<Key>();
        for(HashNode x= first; x!=null; x=x.next){
            queue.enqueue((Key) x.key);
        }
        return queue;
    }

}

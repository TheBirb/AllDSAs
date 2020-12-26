package hashTable;

import queues.Queue;

public class HashTable<Key, Value> {
    private static final int INIT_CAPACITY=4;

    private int N;  //number of key value-pairs
    private int M; //hash table size
    private SequentialSearchST<Key, Value>[] st;

    public HashTable(){}

    public HashTable(int M){
        this.M=M;
        st=(SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for(int i=0; i<M; i++){
            st[i]= new SequentialSearchST<Key, Value>();
        }
    }

    private void resize(int chains){
        SequentialSearchST<Key, Value>[] stv2= (SequentialSearchST<Key, Value>[])new SequentialSearchST[chains];
        this.M=chains;
        for(int i=0; i<st.length; i++){
            stv2[i]=st[i];
        }
        this.st=stv2;
    }

    public int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return size()==0;
    }
    public boolean contains(Key key){
        return get(key) !=null;
    }
    public Value get(Key key){
        int i= hash(key);
        return st[i].get(key);
    }

    public void put(Key key, Value val){
        if(val==null){
            delete(key);
            return;
        }
        if(N>=10*M){
            resize(2*M);
        }
        int i= hash(key);
        if(!st[i].contains(key)){
            N++;
        }
        st[i].put(key, val);
    }

    public void delete(Key key){
        int i= hash(key);
        if(st[i].contains(key)){
            N--;
        }
        st[i].delete(key);
        if(M>INIT_CAPACITY && N<=2*M){
            resize(M/2);
        }
    }

    public Iterable<Key> keys(){
        Queue<Key> queue= new Queue<Key>();
        for(int i=0; i<M; i++){
            for(Key key : st[i].keys()){
                queue.enqueue(key);
            }
        }
        return queue;
    }
}

package hashTable;




public class HashNode<Key, Value> {
    Key key;
    Value val;
   HashNode next;

    public HashNode(Key key, Value val, HashNode next){
        this.key=key;
        this.val=val;
        this.next=next;
    }


}

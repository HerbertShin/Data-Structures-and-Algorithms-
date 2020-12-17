import java.util.Comparator;

public class PriorityQueue<K,V> extends AbstractPriorityQueue<K,V> implements PQ<K,V>{

    private DoublyLinkedList<Entry<K,V>> list = new DoublyLinkedList<>();

    public PriorityQueue(){
        super();
    }

    public PriorityQueue(Comparator<K> comp){
        super(comp);
    }

    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
        validateKey(key);
        list.setNode(1);
        Entry<K,V> temp = new QueueEntry<>(key, value);
        while(list.getCurrentNode().getPrev() != null && compareKeys(temp.getKey(), list.getCurrentElem().getKey()) < 0){
            list.incBack();
        }
        if(list.getCurrentElem() == null){
            list.addFirst(temp);
        }
        else{
            list.addBetween(temp, list.getCurrentNode(), list.getCurrentNode().getNext());
        }
        return temp;
    }

    public Entry<K,V> min(){
        if(isEmpty()){
          return null;
        }
        else {
            return list.first().getNext().getElement();
        }
    }

    public Entry<K,V> removeMin(){
        if(isEmpty()){
            return null;
        }
        else{
            return list.remove(list.first().getNext());
        }
    }

    public int size() {
        return list.size();
    }
}


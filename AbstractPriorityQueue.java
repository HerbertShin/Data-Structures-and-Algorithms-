public abstract class AbstractPriorityQueue<K,V> implements PQ<K,V> {

    protected static class QueueEntry<K,V> implements Entry<K,V>{

        private K key;
        private V value;

        public QueueEntry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }

        public void setKey(K key){
            this.key = key;
        }

        public void setValue(V value){
            this.value = value;
        }
    }

    private java.util.Comparator comparator;

    protected AbstractPriorityQueue(java.util.Comparator comparator){
        this.comparator = comparator;
    }

    protected AbstractPriorityQueue(){
        this(new Comp<K>());
    }

    protected int compare(QueueEntry<K,V> entry1, QueueEntry<K,V> entry2){
        return comparator.compare(entry1.getKey(), entry2.getKey());
    }

    protected int compareKeys(K key1, K key2){
        return comparator.compare(key1, key2);
    }

    protected boolean validateKey(K key) throws IllegalArgumentException{
        try{
            return comparator.compare(key, key) == 0;
        }
        catch(ClassCastException e){
            throw new IllegalArgumentException("Invalid key!");
        }
    }

    public boolean isEmpty(){
        return size() == 0;
    }
}


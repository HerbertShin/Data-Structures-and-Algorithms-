public class DoublyLinkedList<E> {

    protected static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private Node<E> node;
    private int size = 0;


    public DoublyLinkedList(){
        header = new Node<>(null,null,null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    //update methods
    public void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        //size--;
        return node.getElement();
    }

    public void setNode(int i){
        if(i == 0){
            node = first().getNext();
        }
        if(i == 1){
            node = last().getPrev();
        }
    }

    public E incBack(){
        node = node.getPrev();
        return node.getElement();
    }

    public Node<E> getCurrentNode(){
        return node;
    }

    public E getCurrentElem(){
        return node.getElement();
    }

    public Node<E> first(){
        return header;
    }

    public Node<E> last(){
        return trailer;
    }

    public int size(){
        return size;
    }
}
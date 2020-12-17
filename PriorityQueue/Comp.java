public class Comp<E> implements java.util.Comparator<E> {

    public int compare(E val1, E val2) {
        return ((Comparable<E>) val1).compareTo(val2);
    }

}

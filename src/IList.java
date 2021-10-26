public interface IList<E> {
    int size();
    boolean isEmpty();
    E get(int i) throws IndexOutOfBoundsException;
    E set(E e, int i) throws IndexOutOfBoundsException;
    E remove(int i) throws IndexOutOfBoundsException;
    void add(E e, int i) throws IndexOutOfBoundsException;
}

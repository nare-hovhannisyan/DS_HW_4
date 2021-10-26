public class DLLList<E> implements IList<E> {

    private static class Node<E>
    {
        private Node<E> prev;
        private Node<E> next;
        private E element;

        public Node(Node<E> p, Node<E> n, E el)
        {
            prev = p;
            next = n;
            element = el;
        }

        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public E getElement() { return element; }
        public void setElement(E el) { element = el; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }

    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DLLList()
    {
        header = new Node<>(null, null, null);
        trailer = new Node<>(header, null, null);
        header.setNext(trailer);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public E first() {
        if(isEmpty())
            return null;
        return header.getNext().getElement();
    }

    public E last()
    {
        if(isEmpty())
            return null;
        return trailer.getPrev().getElement();
    }

    private void addBetween(Node<E> prev, Node<E> next, E el)
    {
        // header el trailer
        var newest = new Node<>(prev, next, el);
        prev.setNext(newest);
        next.setPrev(newest);
        size++;
    }

    public void addFirst(E el)
    {
        addBetween(header, header.getNext(), el);
    }

    public void addLast(E el)
    {
        addBetween(trailer.getPrev(), trailer, el);
    }

    private E remove(Node<E> node)
    {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--;
        return node.getElement();

    }
    public E removeFirst()
    {
        if(isEmpty())
            return null;
        return remove(header.getNext());
    }

    public E removeLast()
    {
        if(isEmpty())
            return null;
        return remove(trailer.getPrev());
    }

    private void checkIndex(int i)
    {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException();
    }

    private Node<E> findNodeAtIndex(int i)
    {
        var node = header.getNext();
        int ind = 0;
        while(ind != i)
        {
            node = node.getNext();
            ind++;
        }
        return node;
    }

    public E get(int i) throws IndexOutOfBoundsException
    {
        //2
        checkIndex(i);
        var node = findNodeAtIndex(i);
        return node.getElement();
    }

    public E set(E e, int i) throws IndexOutOfBoundsException
    {
        // header -> 11 -> 12 -> 3 -> trailer
        checkIndex(i);
        var node = findNodeAtIndex(i);

        var ans = node.getElement();
        node.setElement(e);
        return ans;
    }

    public E remove(int i) throws IndexOutOfBoundsException
    {
        checkIndex(i);
        var node = findNodeAtIndex(i);
        var ans = node.getElement();
        remove(node);
        return ans;
    }

    public void add(E e, int i) throws IndexOutOfBoundsException
    {
        checkIndex(i);
        var node = findNodeAtIndex(i);
        addBetween(node.getPrev(), node, e);

    }

    public void print()
    {
        var node = header.getNext();
        while (node.getNext() != null)
        {
            System.out.print(node.getElement() + " ");
            node = node.getNext();
        }

        System.out.println();
    }
}

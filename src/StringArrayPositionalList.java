public class StringArrayPositionalList<String> implements IPositionalList<String> {

    public static final int CAPACITY = 10;
    private IPosition<String>[] data;
    private int size = 0;

    private int loc = 0;

    public StringArrayPositionalList()
    {
        this(CAPACITY);
    }

    public StringArrayPositionalList(int capacity)
    {
        data = (IPosition<String>[]) new Object[capacity];
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }


    public IPosition<String> first()
    {
        if(isEmpty())
            return null;
        return data[0];
    }

    public IPosition<String> last()
    {
        if(isEmpty())
            return null;
        return data[size-1];
    }

    public IPosition<String> before(IPosition<String> p) throws IllegalArgumentException
    {
        validate(p);
        return data[loc-1];
    }

    public IPosition<String> after(IPosition<String> p) throws IllegalArgumentException
    {
        validate(p);
        return data[loc+1];
    }

    private IPosition<String> validate(IPosition<String> p) throws IllegalArgumentException
    {
        if(p.getElement() == null)
            throw new IllegalArgumentException();

        return p;
    }

    protected void resize(int capacity)
    {
        String[] temp = (String[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            temp[i] = data[i];
        data = temp;
    }
}

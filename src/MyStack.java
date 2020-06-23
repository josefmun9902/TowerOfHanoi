import java.util.ArrayList;

public class MyStack<E> implements StackInterface<E>
{
    private ArrayList<E> data =new ArrayList<> ();
    public E push(E item)
    {
        data.add(0, item);
        return item;
    }
    public E add(E item)
    {
        data.add(item);
        return item;
    }
    public E peek()
    {
        return data.get(data.size()-1);
    }
    public E pop()
    {
        return data.remove(data.size()-1);
    }
    public boolean empty()
    {
        if(data.size()==0)
            return true;
        return false;
    }
    public int size()
    {
        return data.size();
    }
    public E get(int x)
    {
        return data.get(x);
    }
}

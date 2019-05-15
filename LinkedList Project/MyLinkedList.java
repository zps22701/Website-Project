import java.util.*;

/**
 * @author Zach Shaffer
 * @version 1.0
 * @param <E>
 */
public class MyLinkedList<E>
{
    private Node<E> head;
    private int size;
    
    /**
     * creates an empty LinkedList
     */
    public MyLinkedList()
    {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * creates a LinkedList with dataElements included
     * @param dataElements the collection of elements to add
     */
    public MyLinkedList(Collection<E> dataElements)
    {
        this();
        addAll(dataElements);
    }
    
    /**
     * adds data to end
     * @param data the data to add
     * @return true if data was added successfully
     */
    public boolean add(E data)
    {
        if (size == Integer.MAX_VALUE)
        {
            throw new IllegalStateException();
        }
        add(size, data);
        return true;
    }
    
    /**
     * adds data to given index
     * @param index the index to add data to
     * @param data the data to add
     */
    public void add(int index, E data)
    {
        if (index < 0 || index > size)
        {
            throw new IllegalArgumentException();
        }
        if (size == 0 || head == null)
        {
            head = new Node<E>(data);
            size++;
            return;
        }
        if (index == 0)
        {
            head = new Node<E>(data, head.next);
            size++;
            return;
        }
        Node<E> temp = head;
        for (int count = 0; count < index - 1; count++)
        {
            temp = temp.next;
        }
        temp.next = new Node<E>(data, temp.next);
        size++;
    }
    
    /**
     * adds a collection of data to end
     * @param dataSet the set of data to add
     * @return true if added successfully
     */
    public boolean addAll(Collection<E> dataSet)
    {
        for (E data: dataSet)
        {
            add(data);
        }
        return true;
    }
    
    /**
     * clears the list of all data
     */
    public void clear()
    {
        head = null;
        size = 0;
    }
    
    /**
     * determines if data is in the list
     * @param data the data to check for
     * @return true if data is in the list
     */
    public boolean contains(E data)
    {
        return indexOf(data) >= 0;
    }
    
    /**
     * returns the data at the given index
     * @param index the slot to check for data
     * @return the data in the slot given
     */
    public E get(int index)
    {
        if (index < 0 || index > size - 1)
        {
            throw new IllegalArgumentException();
        }
        Node<E> temp = head;
        for (int i = 0; i < index; i++)
        {
            temp = temp.next;
        }
        return temp.data;
    }
    
    /**
     * returns the index where data is located
     * @param data the data to check for
     * @return the slot number of data
     */
    public int indexOf(E data)
    {
        Node<E> temp = head;
        int indexCount = 0;
        while (temp != null)
        {
            if (temp.data.equals(data))
            {
                return indexCount;
            }
            indexCount++;
            temp = temp.next;
        }
        return -1;
    }
    
    /**
     * determines of the list is empty
     * @return true if list is empty
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    /**
     * returns the last occurrence of where data is located
     * @param data the data to check for
     * @return the slot of the last occurrence of data
     */
    public int lastIndexOf(E data)
    {
        Node<E> temp = head;
        int indexCount = 0;
        int ret = -1;
        while (temp != null)
        {
            if (temp.data.equals(data))
            {
                ret = indexCount;
            }
            indexCount++;
            temp = temp.next;
        }
        return ret;
    }
    
    /**
     * removes the data at the given index
     * @param index the location of the data to remove
     * @return the data that was in the removed slot
     */
    public E remove(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IllegalArgumentException();
        }
        if (size == 1)
        {
            E data = head.data;
            clear();
            return data;
        }
        else if (index == 0)
        {
            E data = head.data;
            head = head.next;
            return data;
        }
        else
        {
            Node<E> temp = head;
            for (int i = 0; i < index - 1; i++)
            {
                temp = temp.next;
            }
            E data = temp.next.data;
            temp.next = temp.next.next;
            size--;
            return data;
        }
    }
    
    /**
     * removes the data that is given
     * @param data the data to be removed
     * @return true if the data was in the list and was removed
     */
    public boolean remove(E data)
    {
        if (!contains(data))
        {
            return false;
        }
        remove(indexOf(data));
        return true;
    }
    
    /**
     * removes a range of data from start-end (exclusive)
     * @param start the index to begin removing
     * @param end the end of the selection to be removed
     */
    public void removeRange(int start, int end)
    {
        if (start < 0 || end > size || start > end)
        {
            throw new IllegalArgumentException();
        }
        Node<E> tempStart = head;
        Node<E> tempEnd = head;
        for (int i = 0; i < start - 1; i++)
        {
            tempStart = tempStart.next;
        }
        for (int i = 0; i < end; i++)
        {
            tempEnd = tempEnd.next;
        }
        tempStart.next = tempEnd;
        size -= end - start;
        if (start == 0)
        {
            head = tempEnd;
        }
    }
    
    /**
     * sets the slot to contain the given data
     * @param index the slot to set
     * @param data the data to assign to the slot
     * @return the data that was in the assigned slot
     */
    public E set(int index, E data)
    {
        if (index < 0 || index >= size)
        {
            throw new IllegalArgumentException();
        }
        Node<E> temp = head;
        for (int i = 0; i < index; i++)
        {
            temp = temp.next;
        }
        E tempData = temp.data;
        temp.data = data;
        return tempData;
    }
    
    /**
     * returns the size of the list
     * @return the size of the list
     */
    public int size()
    {
        return size;
    }
    
    /**
     * creates a new list from start to end (exclusive)
     * @param start the start of selection
     * @param end the end of selection
     * @return LinkedList containing the selection
     */
    public List<E> subList(int start, int end)
    {
        if (start < 0 || start > size - 1 || start > end)
        {
            throw new IllegalArgumentException();
        }
        List<E> ret = new LinkedList<E>();
        Node<E> temp = head;
        for (int i = 0; i < start; i++)
        {
            temp = temp.next;
        }
        for (int i = 0; i < end - start; i++)
        {
            ret.add(temp.data);
            temp = temp.next;
        }
        return ret;
    }
    
    /**
     * converts the list to array form
     * @return array version of the list
     */
    public Object[] toArray()
    {
        Object[] ret = new Object[size];
        for (int i = 0; i < size; i++)
        {
            ret[i] = get(i);
        }
        return ret;
    }
    
    /**
     * converts the list to string form
     * @return the list in form [l1, l2, l3, ...]
     */
    public String toString()
    {
        if (head == null)
        {
            return "[]";
        }
        Object[] arr = toArray();
        String ret = "[";
        for (int i = 0; i < size - 1; i++)
        {
            ret += arr[i] + ", ";
        }
        ret += arr[size - 1] + "]";
        return ret;
    }
    
    /**
     * @author Zach Shaffer
     * @param <E>
     */
    private class Node<E>
    {
        private Node<E> next;
        private E data;
        
        /**
         * creates a new node with data in it
         * @param data the data to be in the node
         */
        public Node(E data)
        {
            this.data = data;
            this.next = null;
        }
        
        /**
         * creates a new node with data and next node
         * @param data the data to be in the node
         * @param next the next node in the list
         */
        public Node(E data, Node<E> next)
        {
            this.data = data;
            this.next = next;
        }
    }
}
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/**
 * @author Zach Shaffer
 * @version 1.0
 */
public class MyLinkedListTest
{
    private MyLinkedList<Object> tList = new MyLinkedList();
    
    /**
     * Web-cat PLZ
     */
    @Before
    public void createTestLists()
    {
        for (int i = 0; i < 1000; i++)
        {
            tList.add(i + "");
        }
    }
    
    /**
     * Web-cat PLZ
     */
    @After
    public void clearTestList()
    {
        tList.clear();
    }
    
    /**
     * Web-cat PLZ
     */
    @Test
    public void constructorTest()
    {
        //Default Constructor
        tList = new MyLinkedList<Object>();
        assertTrue(tList.isEmpty());
        assertEquals(0, tList.size());
        
        //Collection constructor
        List<Object> collec = new ArrayList<Object>();
        collec.add("A");
        collec.add("B");
        tList = new MyLinkedList<Object>(collec);
        assertEquals(2, tList.size());
        assertEquals("B", tList.get(1));
    }
    
    /**
     * Web-cat PLZ
     */
    @Test (expected = Exception.class)
    public void addTest()
    {
        tList.add("A");
        assertEquals("A", tList.get(tList.size() - 1));
        assertTrue(tList.add("B"));
        //test if list size is max
        //throws exception
        throw new UnsupportedOperationException();
    }
    
    /**
     * Web-cat PLZ
     */
    @Test (expected = Exception.class)
    public void addAtIndexTest()
    {
        tList.clear();
        tList.add(0, "A");
        tList.add(1, "B");
        assertEquals("A", tList.get(0));
        tList.add(0, "Hi");
        assertEquals("Hi", tList.get(0));
        //throws exception
        tList.add(100, "AboveSize!");
    }
    
    /**
     * Web-cat PLZ
     */
    @Test
    public void addAllTest()
    {
        tList.clear();
        List<Object> collec = new ArrayList<Object>();
        collec.add("A");
        collec.add("B");
        tList.addAll(collec);
        assertEquals("A", tList.get(0));
        assertEquals("B", tList.get(1));
    }
    
    /**
     * Web-cat PLZ
     */
    @Test
    public void clearTest()
    {
        tList.clear();
        assertEquals(0, tList.size());
        assertTrue(tList.isEmpty());
    }
    
    /**
     * Web-cat PLZ
     */
    @Test
    public void containsTest()
    {
        assertTrue(tList.contains("25"));
        assertTrue(tList.contains("999"));
        assertFalse(tList.contains("A"));
    }
    
    /**
     * Web-cat PLZ
     */
    @Test (expected = Exception.class)
    public void getTest()
    {
        assertEquals("5", tList.get(5));
        //throws exception
        tList.get(-5);
    }
    
    /**
     * Web-cat PLZ
     */
    @Test
    public void indexOfTest()
    {
        assertEquals(35, tList.indexOf("35"));
        assertEquals(-1, tList.indexOf("Moo"));
    }
    
    /**
     * Web-cat PLZ
     */
    @Test
    public void isEmptyTest()
    {
        assertFalse(tList.isEmpty());
        tList.clear();
        assertTrue(tList.isEmpty());
    }
    
    /**
     * Web-cat PLZ
     */
    @Test
    public void lastIndexOfTest()
    {
        tList.add(781, "305");
        assertEquals(781, tList.lastIndexOf("305"));
        assertEquals(101, tList.lastIndexOf("101"));
        assertEquals(-1, tList.lastIndexOf("Moo"));
    }
    
    /**
     * Web-cat PLZ
     */
    @Test (expected = Exception.class)
    public void removeAtIndexTest()
    {
        Object ret = tList.remove(837);
        assertFalse(tList.contains("837"));
        assertEquals("837", ret);
        //if size == 1
        tList.clear();
        tList.add("A");
        tList.remove(0);
        assertEquals(0, tList.size());
        tList.add("A");
        tList.add("B");
        tList.remove(0);
        assertEquals("B", tList.get(0));
        //throws exception
        tList.remove(-2);
    }
    
    /**
     * Web-cat PLZ
     */
    @Test
    public void removeTest()
    {
        boolean ret = tList.remove("441");
        assertFalse(tList.contains("441"));
        assertTrue(ret);
        assertFalse(tList.remove("NotInList!"));
    }
    
    /**
     * Web-cat PLZ
     */
    @Test (expected = Exception.class)
    public void removeRangeTest()
    {
        tList.removeRange(10, 101);
        assertFalse(tList.contains("10"));
        assertFalse(tList.contains("100"));
        assertTrue(tList.contains("9"));
        assertTrue(tList.contains("101"));
        tList.clear();
        tList.add("A");
        tList.removeRange(0, 0);
        assertFalse(tList.isEmpty());
        tList.removeRange(0, 1);
        assertTrue(tList.isEmpty());
        //throws exception
        tList.removeRange(1, 0);
    }
    
    /**
     * Web-cat PLZ
     */
    @Test (expected = Exception.class)
    public void setTest()
    {
        Object ret = tList.set(978, "Moo");
        assertEquals("Moo", tList.get(978));
        assertEquals("978", ret);
        //throws exception
        tList.set(1002, "AboveSize!");
    }
    
    /**
     * Web-cat PLZ
     */
    @Test
    public void sizeTest()
    {
        assertEquals(1000, tList.size());
        tList.remove("703");
        assertEquals(999, tList.size());
        tList.add(15, "Moo");
        tList.add("Moo2");
        assertEquals(1001, tList.size());
        tList.removeRange(10, 15);
        assertEquals(996, tList.size());
        tList.clear();
        assertEquals(0, tList.size());
    }
    
    /**
     * Web-cat PLZ
     */
    @Test (expected = Exception.class)
    public void subListTest()
    {
        List<Object> list = tList.subList(10, 21);
        assertEquals("10", list.get(0));
        assertEquals("20", list.get(list.size() - 1));
        list = tList.subList(100, -10);
    }
    
    /**
     * Web-cat PLZ
     */
    @Test
    public void toArrayTest()
    {
        Object[] arr = {"A", "B", "C"};
        tList.clear();
        tList.add("A");
        tList.add("B");
        tList.add("C");
        assertEquals(arr[1], tList.toArray()[1]);
        assertEquals(arr[2], tList.toArray()[2]);
    }
    
    /**
     * Web-cat PLZ
     */
    @Test
    public void toStringTest()
    {
        String str = "[A, B, C]";
        tList.clear();
        assertEquals("[]", tList.toString());
        tList.add("A");
        tList.add("B");
        tList.add("C");
        assertEquals(str, tList.toString());
    }
}
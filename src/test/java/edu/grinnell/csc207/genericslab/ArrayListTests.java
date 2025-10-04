package edu.grinnell.csc207.genericslab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ArrayListTests {
    @Test
    public void emptyListTest() {
        ArrayList<Integer> l = new ArrayList<>();
        assertEquals(0, l.size());
    }

    @Test
    public void listAddSize10NumsAsStrings() {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        assertEquals(10, l.size());
    }

    @Test
    public void listAddSize10NumsAsStrings2() {
        ArrayList<String> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            l.add(Integer.toString(i));
        }
        assertEquals(10, l.size());
    }

    @Test
    public void listGetSeveral() {
        ArrayList<String> l = new ArrayList<String>();
        String[] elements = new String[] {"a", "b", "c", "d", "e", "f", "g"};
        for (int i = 0; i < elements.length; i++) {
            l.add(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], l.get(i));
        }
    }

    @Test
    public void listGetEmpty() {
        ArrayList<String> l = new ArrayList<String>();
        l.add("");
        assertEquals("", l.get(0));
    }

    @Test
    public void listGetOOB() {
        ArrayList<String> l = new ArrayList<String>();
        l.add("hello!");
        l.add("goodbye!");
        l.add("huh?");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(3);
        });
    }

    @Test
    public void listRemoveSome() {
        ArrayList<String> l = new ArrayList<String>();
        l.add("!");
        l.add("@");
        l.add(".");
        l.add("#");
        l.add("&");

        // @ #
        
        assertEquals(".", l.remove(2));
        assertEquals("@", l.get(1));
        assertEquals("#", l.get(2));
        
        assertEquals("!", l.remove(0));
        assertEquals("@", l.get(0));

        assertEquals("&", l.remove(2));
        assertEquals("#", l.get(1));
    }

    @Test
    public void listRemoveOOB() {
        ArrayList<String> l = new ArrayList<String>();
        l.add("A");
        l.add("B");
        l.add("C");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(3);
        });
    }
}

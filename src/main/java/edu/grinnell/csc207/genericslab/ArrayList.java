package edu.grinnell.csc207.genericslab;

import java.util.Arrays;

/**
 * An array-based implementation of a list.
 */
public class ArrayList<T> {

    private static final int INITIAL_SIZE = 8;
    private T[] data;
    private int sz;

    /**
     * Constructs a new, empty array list.
     */
    public ArrayList() {
        this.data = (T[]) new Object[INITIAL_SIZE];
        this.sz = 0;
    }

    private void ensureCapacity() {
        if (sz == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(T value) {
        ensureCapacity();
        data[sz++] = value;
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        return sz;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public T get(int index) {
        if (index < 0 || index >= sz) {
            throw new IndexOutOfBoundsException(index);
        }
        return data[index];
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public T remove(int index) {
        if (index < 0 || index >= sz) {
            throw new IndexOutOfBoundsException(index);
        } else {
            T ret = data[index];
            for (int i = index; i < data.length - 1; i++) {
                data[i] = data[i + 1];
            }
            sz -= 1;
            return ret;
        }
    }
    /**
     * mutates this array to have value sep in every other iteration.
     * @param sep: the value that is being added in between every other iterataion on the arraylist.
     */
    public void intersperse(T sep) {
        ArrayList<T> r = new ArrayList<>();
        r.sz = this.sz * 2 - 1;
        for (int i = 0; i < this.sz; i++) {
            r.data[2 * i] = this.data[i];
        }
        for (int i = 1; i < this.sz; i++) {
            r.data[1 + 2 * (i - 1)] = sep;
        }
        this.data = r.data;
        this.sz = r.sz;
    }

    /**
     * It is impossible to implement this method since we cannot find a "maximum" value in a String.
     * @return exception
     */
    public T maximum() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns all the elements in the arraylist as a string.
     * @returns string containing all the elements in the arraylist.
     */
    public String toString() {
        String newString = "[";
        for(int i = 0; i < this.sz - 1; i++){
            newString += (String) this.data[i];
            newString += ", ";
        }
        newString += (String) this.data[this.sz - 1];
        return newString += "]";
    }

    /**
     * It is impossible to compare differnt elements in the array if the types are not guarenteed.
     * @return exception
     */
    public void insertionSort() {
        throw new UnsupportedOperationException();
    }

}

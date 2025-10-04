package edu.grinnell.csc207.genericslab;

import java.util.NoSuchElementException;

/**
 * An Optional<@T> is either empty or holds a single value of type @T.
 * 
 * @param T the type of value potentially held by this <code>Optional</code>.
 */


// Get returns a null when the value is null, but also when there is a type matching issue, which can lead to issues if we have a function that is checking
// if a certain field is null, so the function would run and produce output that would be invalid, because the type isn't even correct.

public class Optional<T> {
    /* TODO: fill me in with implementation! */  
    private Optional() {}

    static <T> Optional<T> empty() {
        Optional<T> a = new Optional<>();
        return a;
    }

    static <T> Optional<T> of(T value) {
        Optional<T> b = (Optional <T>) value;
        return b;
    }

    public boolean isEmpty() {
        return this.isEmpty();
    }

    public boolean isPresent() {
        return !this.isEmpty();
    }

    public T get() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        else {
            return this.get();
        }
    }

    public T orElse(T other) {
        if (this.isPresent()) {
            return this.get();
        }
        else {
            return other;
        }
    }
}

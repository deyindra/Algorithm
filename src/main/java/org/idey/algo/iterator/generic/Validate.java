package org.idey.algo.iterator.generic;

/**
 * @author indranil dey
 * A interface which validate object and return true if the validation passed
 * Used by {@link FilterIterator}
 */
public interface Validate<T> {
    boolean validate(T object);
}

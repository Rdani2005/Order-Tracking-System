package com.rdani2005.uberdirect.common.functional;


/**
 * Represents a function that accepts three arguments and produces a result.
 * This is a functional interface whose functional method is {@link #apply(Object, Object, Object)}.
 *
 * <p>This interface is designed for cases where a standard {@code BiFunction} or {@code Function}
 * is insufficient, and an operation requires three input parameters.</p>
 *
 * @param <T> the type of the first input to the function
 * @param <U> the type of the second input to the function
 * @param <V> the type of the third input to the function
 * @param <R> the type of the result of the function
 *
 * @author Rdani2005
 */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {

    /**
     * Applies this function to the given arguments.
     *
     * @param t the first input argument
     * @param u the second input argument
     * @param v the third input argument
     * @return the function result
     */
    R apply(T t, U u, V v);

}

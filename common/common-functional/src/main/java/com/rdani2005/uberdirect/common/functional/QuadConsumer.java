package com.rdani2005.uberdirect.common.functional;

/**
 * Represents an operation that accepts four input arguments and returns no result.
 * This is the four-arity specialization of {@link java.util.function.Consumer}.
 * Unlike most other functional interfaces, {@code QuadConsumer} is expected
 * to operate via side effects.
 *
 * <p>This is a functional interface whose functional method is {@link #accept(Object, Object, Object, Object)}.</p>
 *
 * @param <T> the type of the first argument to the operation
 * @param <U> the type of the second argument to the operation
 * @param <V> the type of the third argument to the operation
 * @param <W> the type of the fourth argument to the operation
 *
 * @author Rdani2005
 */
@FunctionalInterface
public interface QuadConsumer<T, U, V, W> {

    /**
     * Performs this operation on the given arguments.
     *
     * @param t the first input argument
     * @param u the second input argument
     * @param v the third input argument
     * @param w the fourth input argument
     */
    void accept(T t, U u, V v, W w);

    /**
     * Returns a composed {@code QuadConsumer} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation. If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code QuadConsumer} that performs in sequence this
     *         operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     */
    default QuadConsumer<T, U, V, W> andThen(QuadConsumer<? super T, ? super U, ? super V, ? super W> after) {
        if (after == null) {
            throw new NullPointerException("The after QuadConsumer cannot be null.");
        }

        return (t, u, v, w) -> {
            accept(t, u, v, w);
            after.accept(t, u, v, w);
        };
    }
}
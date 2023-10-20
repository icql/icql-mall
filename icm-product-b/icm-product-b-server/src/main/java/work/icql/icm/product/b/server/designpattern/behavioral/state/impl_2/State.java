package work.icql.icm.product.b.server.designpattern.behavioral.state.impl_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum State {

    STATE_A,
    STATE_B,
    STATE_C,
    STATE_D;

    private static final Chain<State> SUCCESS;
    private static final Chain<State> FAIL;
    private static final Chain<State> EXCEPTION;


    static {
        SUCCESS = Chain.<State>builder()
                .from(STATE_A).to(STATE_B)
                .from(STATE_B).to(STATE_C)
                .from(STATE_C).to(STATE_D)
                .build();
        FAIL = Chain.<State>builder()
                .from(STATE_B).to(STATE_A)
                .from(STATE_C).to(STATE_A)
                .from(STATE_D).to(STATE_A)
                .build();
        EXCEPTION = Chain.<State>builder()
                .from(STATE_A).to(STATE_D)
                .build();
    }


    public State doEvent(State currentState) {
        try {
            return success(currentState);


        } catch (Exception e) {
            return exception(currentState);
        }
    }

    public State success(State currentState) {
        State nextState = SUCCESS.getNextState(currentState);
        if (Objects.isNull(nextState)) {
            throw new RuntimeException("success, currentState=" + currentState + ", nextState is null");
        }
        return nextState;
    }

    public State fail(State currentState) {
        State nextState = FAIL.getNextState(currentState);
        if (Objects.isNull(nextState)) {
            throw new RuntimeException("fail, currentState=" + currentState + ", nextState is null");
        }
        return nextState;
    }

    public State exception(State currentState) {
        State nextState = EXCEPTION.getNextState(currentState);
        if (Objects.isNull(nextState)) {
            throw new RuntimeException("exception, currentState=" + currentState + ", nextState is null");
        }
        return nextState;
    }

    private static class Chain<T> {

        private final Map<T, T> chain;

        private Chain(Map<T, T> chain) {
            this.chain = chain;
        }

        public T getNextState(T t) {
            return chain.get(t);
        }

        public static <V> Builder<V> builder() {
            return new Builder<V>();
        }
    }

    private static class Builder<T> {

        private final Map<T, T> data = new HashMap<>();

        public Semi<T> from(T t) {
            return new Semi<>(this, t);
        }

        public Chain<T> build() {
            return new Chain<T>(data);
        }

        private static class Semi<T> {
            private final T key;
            private final Builder<T> parent;

            private Semi(Builder<T> builder, T key) {
                this.parent = builder;
                this.key = key;
            }

            public Builder<T> to(T value) {
                parent.data.put(key, value);
                return parent;
            }
        }
    }
}

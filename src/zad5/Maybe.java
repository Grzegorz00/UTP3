package zad5;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe<T> {

    T value;

    private Maybe(T value) {
        this.value = value;
    }

    private Maybe(){
        this(null);
    }

    public static <T> Maybe<T> of(T value) {
        return new Maybe<>(value);
    }

    public void ifPresent(Consumer<T> cons){
        if(isPresent()) cons.accept(value);
    }

    public <R>Maybe<R> map(Function<T,R> func){
        return new Maybe<>((isPresent()) ? func.apply(value) : null);
    }
    public T get(){
        if(!isPresent()) throw new NoSuchElementException("maybe is empty");
        return value;
    }

    public boolean isPresent(){
        return value != null;
    }

    public T orElse(T defVal){
        return (isPresent()) ? value : defVal;
    }

    public Maybe<T> filter(Predicate<T> pred){
        return (isPresent() && pred.test(value)) ? this : new Maybe<>();
    }

    @Override
    public String toString() {
        return "Maybe " + (isPresent() ? "has value " + value : "is empty");
    }

}

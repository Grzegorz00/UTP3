package zad1;

import java.util.function.Function;

public class InputConverter<T> {

    private final T file;

    public InputConverter(T file) {
        this.file = file;
    }

    public <T>T convertBy(Function ... function){
        Object x = file;
        for(Function f : function){
            x = f.apply(x);
        }
        return (T)x;
    }
}

package zad3;

import java.util.List;
import java.util.function.Function;

public class InputConverter<T> {

    private final T file;

    public InputConverter(T file) {
        this.file = file;
    }

    /*public List<String> convertBy(Function<String, List<String>> f){
        String x = (String)file;
        List<String> list;
        list = f.apply(x);
        return list;
    }*/

    public <R>R convertBy(Function<T,R> f1){
        Object x = file;
        x = f1.apply((T)x);
        return (R)x;
    }

    public <T,R>T convertBy(Function<T,R> f1,Function<R,T> f2){
        Object x = file;
        Object list;
        list = f1.apply((T)x);
        x = f2.apply((R)list);

        return (T)x;
    }
    public <T,R,K,L>L convertBy(Function<T,R> f1,Function<R,K> f2,Function<K,L> f3){
        Object x = file;
        Object list;
        Object y = null;
        list = f1.apply((T)x);
        x = f2.apply((R)list);
        y = f3.apply((K)y);

        return (L)y;
    }
    public <T,R,K,L,P>P convertBy(Function<T,R> f1,Function<R,K> f2,Function<K,L> f3,Function<L,P> f4){
        Object x = file;
        Object list;
        Object y = null;
        list = f1.apply((T)x);
        x = f2.apply((R)list);
        y = f3.apply((K)y);

        return f4.apply((L)y);
    }
}

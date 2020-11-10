package zad2;

import java.util.function.Function;

public interface MyFunction <T,R> extends Function <T,R>{

    R checkedApply(T arg) throws Exception;

    default R apply(T arg){
        try {
            return checkedApply(arg);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}

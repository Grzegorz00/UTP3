package zad1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InputConverter<T> {

    private final T value;

    public InputConverter(T file) {
        this.value = file;
    }
}

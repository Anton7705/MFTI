package ru.dorogov.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamingPlatform<T> {
    public Reader<T> reader;
    public List<Transformer<T>> list = new ArrayList<>();
    public Writer<T> writer;

    public final void stream() {
        T tmp = reader.read();
        for (int i = 0; i < list.size(); i++) {
            tmp = list.get(i).transform(tmp);
        }
        writer.write(tmp);
    }
}

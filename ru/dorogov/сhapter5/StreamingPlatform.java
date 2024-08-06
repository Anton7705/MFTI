package ru.dorogov.сhapter5;

import java.util.ArrayList;
import java.util.List;

public class StreamingPlatform <T> {
    Reader<T> reader;
    List<Transformer<T>> list = new ArrayList<>();
    Writer<T> writer;

    public final void stream() {
        T tmp = reader.read();
        for (int i = 0; i < list.size(); i++) {
            tmp = list.get(i).transform(tmp);
        }
        writer.write(tmp);
    }
}

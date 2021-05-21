package org.bd.java_exercise.design.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregation implements Aggregation{

    private final List<Object> list = new ArrayList<>();

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public CustomizedIterator getIterator() {
        return new ConcreteIterator(this.list);
    }
}

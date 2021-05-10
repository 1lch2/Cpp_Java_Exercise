package design.iterator;

import java.util.List;

public class ConcreteIterator implements CustomizedIterator{

    private final List<Object> list;
    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public Object next() {
        Object obj = null;
        if (this.hasNext()) {
            this.index += 1;
            obj = list.get(this.index);
        }
        return obj;
    }

    @Override
    public boolean hasNext() {
        return index < list.size() - 1;
    }
}

package org.bd.java_exercise.design.run;

import org.bd.java_exercise.design.iterator.Aggregation;
import org.bd.java_exercise.design.iterator.ConcreteAggregation;
import org.bd.java_exercise.design.iterator.CustomizedIterator;

public class RunIteratorPattern {

    public static void main(String[] args) {
        Aggregation aggregation = new ConcreteAggregation();

        aggregation.add("first");
        aggregation.add("second");
        aggregation.add("third");

        CustomizedIterator iterator = aggregation.getIterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.print(obj);

            if (iterator.hasNext()) {
                System.out.print(", ");
            }
        }
    }
}

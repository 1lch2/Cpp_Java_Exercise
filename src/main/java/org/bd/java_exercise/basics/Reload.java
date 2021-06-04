package org.bd.java_exercise.basics;

import java.util.*;

/**
 * Reloaded methods are decided at compile time, not run time.
 */
public class Reload {

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<String>(),
                new HashMap<String, Integer>().values()
        };

        for (Collection<?> c : collections) {
            System.out.println(reload(c)); // print "unknown 3 times"
        }
    }

    public static String reload(Set<?> set) {
        return "set";
    }

    public static String reload(List<?> list) {
        return "list";
    }

    /**
     * IntelliJ should highlight this method only.
     *
     * @param collection input collection of collections
     * @return plain message
     */
    public static String reload(Collection<?> collection) {
        return "unknown";
    }
}

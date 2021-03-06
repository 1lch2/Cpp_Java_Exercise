package org.bd.java_exercise.design.run;

import org.bd.java_exercise.design.observer.Customer;
import org.bd.java_exercise.design.observer.Product;
import org.bd.java_exercise.design.observer.Store;

public class RunObserverPattern {

    public static void main(String[] args) {
        Store store = new Store();

        Customer customer0 = new Customer("customer0");
        Customer customer1 = new Customer("customer1");

        store.addObserver(customer0);
        store.addObserver(customer1);

        store.addNewProduct(new Product("vodka", 20));
        store.addNewProduct(new Product("whiskey", 25));

        store.removeObserver(customer1);

        store.addNewProduct(new Product("brandy", 18));
        store.setProductPrice("vodka", 30);
    }
}

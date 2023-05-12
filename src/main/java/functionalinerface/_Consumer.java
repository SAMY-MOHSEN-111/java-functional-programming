package functionalinerface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer samy = new Customer("samy", "01156261362");
        greetCustomer(samy);
        greetingCustomerConsumer.accept(samy);
        greetingCustomerConsumerV2.accept(samy,false);
    }

    static Consumer<Customer> greetingCustomerConsumer = customer ->
            System.out.printf("Welcome %s thanks for registering %s%n", customer.name, customer.phone);
    static BiConsumer<Customer, Boolean> greetingCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.printf("Welcome %s " + (showPhoneNumber ? "thanks for registering %s%n" : "%n"), customer.name, customer.phone);


    static void greetCustomer(Customer customer) {
        System.out.printf("Welcome %s thanks for registering %s%n", customer.name, customer.phone);
    }

    static class Customer {
        private final String name;
        private final String phone;

        Customer(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }
}

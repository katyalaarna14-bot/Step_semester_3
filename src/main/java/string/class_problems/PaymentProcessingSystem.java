package string.class_problems;

import java.util.ArrayList;
import java.util.List;

class ShoppingProduct {
    private String name;
    private double price;

    ShoppingProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCustomer {
    private String name;

    ShoppingCustomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class ShoppingOrder {
    private ShoppingCustomer customer;
    private List<ShoppingProduct> products = new ArrayList<>();
    private String status = "Pending";

    ShoppingOrder(ShoppingCustomer customer) {
        this.customer = customer;
    }

    public void addProduct(ShoppingProduct product) {
        products.add(product);
    }

    public double getTotal() {
        double total = 0;
        for (ShoppingProduct product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public ShoppingCustomer getCustomer() {
        return customer;
    }
}

interface PaymentMethod {
    boolean pay(double amount);
}

class CreditCard implements PaymentMethod {
    public boolean pay(double amount) {
        System.out.println("Paid Rs. " + amount + " using Credit Card.");
        return true;
    }
}

class PayPal implements PaymentMethod {
    public boolean pay(double amount) {
        System.out.println("Paid Rs. " + amount + " using PayPal.");
        return true;
    }
}

class BankTransfer implements PaymentMethod {
    public boolean pay(double amount) {
        System.out.println("Bank transfer failed.");
        return false;
    }
}

class PaymentProcessor {
    public void processPayment(ShoppingOrder order,
                               PaymentMethod method) {
        if (order.isEmpty()) {
            System.out.println("Cannot pay for an empty order.");
            return;
        }

        if (method.pay(order.getTotal())) {
            order.setStatus("Paid");
        }

        System.out.println("Customer: "
                + order.getCustomer().getName());
        System.out.println("Order status: " + order.getStatus());
        System.out.println();
    }
}

public class PaymentProcessingSystem {
    public static void main(String[] args) {
        ShoppingCustomer customer = new ShoppingCustomer("Aarna");
        ShoppingOrder order = new ShoppingOrder(customer);

        PaymentProcessor processor = new PaymentProcessor();

        processor.processPayment(order, new CreditCard());

        order.addProduct(new ShoppingProduct("Keyboard", 1500));
        order.addProduct(new ShoppingProduct("Mouse", 500));

        processor.processPayment(order, new BankTransfer());
        processor.processPayment(order, new PayPal());
    }
}
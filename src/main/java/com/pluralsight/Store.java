package com.pluralsight;
import java.io.*;
import java.util.*;

public class Store {
    private final Map<String, Product> products = new HashMap<>();
    private final Map<String, Integer> cart = new HashMap<>();

    public void loadProducts(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 4) {
                    Product product = new Product(values[0], values[1], Double.parseDouble(values[2]), values[3]);
                    products.put(values[0], product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayProducts() {
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    public void addToCart(String sku) {
        if (products.containsKey(sku)) {
            cart.put(sku, cart.getOrDefault(sku, 0) + 1);
            System.out.println("Added " + products.get(sku).getName() + " to the cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void removeFromCart(String sku) {
        if (cart.containsKey(sku)) {
            cart.remove(sku);
            System.out.println("Removed " + products.get(sku).getName() + " from the cart.");
        } else {
            System.out.println("Product not in the cart.");
        }
    }

    public void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                Product product = products.get(entry.getKey());
                System.out.println(entry.getKey() + ": " + product.getName() + " • $" +
                        product.getPrice() + " x " + entry.getValue());
            }
        }
    }

    public void checkout() {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += products.get(entry.getKey()).getPrice() * entry.getValue();
        }
        System.out.printf("Total amount due: $%.2f%n", total);

    }
}
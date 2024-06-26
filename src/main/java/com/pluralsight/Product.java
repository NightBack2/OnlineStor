package com.pluralsight;
public class Product {
    private final String sku;
    private final String name;
    private final double price;
    private final String department;

    public Product(String sku, String name, double price, String department) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.department = department;
    }

    // Getters and Setters
    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return String.format("%s: %s • $%.2f [%s]", sku, name, price, department);
    }
}


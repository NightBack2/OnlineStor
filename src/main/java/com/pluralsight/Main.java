package com.pluralsight;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.loadProducts("products.csv");

        Scanner scanner = new Scanner(System.in);
        String input;
        boolean running = true;

        while (running) {
            System.out.println("1. Display Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. Remove from Cart");
            System.out.println("4. Display Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            input = scanner.nextLine();

            switch (input) {
                case "1":
                    store.displayProducts();
                    break;
                case "2":
                    System.out.print("Enter SKU to add to cart: ");
                    input = scanner.nextLine();
                    store.addToCart(input);
                    break;
                case "3":
                    System.out.print("Enter SKU to remove from cart: ");
                    input = scanner.nextLine();
                    store.removeFromCart(input);
                    break;
                case "4":
                    store.displayCart();
                    break;
                case "5":
                    store.checkout();
                    break;
                case "6":
                    running = false;
                    System.out.println("Exiting the store. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
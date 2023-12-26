package BasicProgram;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RestaurantOrderSystem {

    public static void main(String[] args) {
        // Food Menu
        Map<String, Double> menu = new HashMap<>();
        menu.put("Burger", 5.99);
        menu.put("Pizza", 8.99);
        menu.put("Salad", 3.99);
        menu.put("Coke", 1.99);

        // Input... Use Scanner
        Scanner scanner = new Scanner(System.in);

        // Order Food
        Map<String, Integer> order = new HashMap<>();
        boolean continueOrdering = true;

        while (continueOrdering) {
            System.out.println("List of Foods:");
            for (String item : menu.keySet()) {
                System.out.println(item + ": RM" + menu.get(item));
            }

            System.out.print("Please Enter Your Order (Enter 'Done' to Complete Your Order): ");
            String foodItem = scanner.nextLine();

            if (foodItem.equalsIgnoreCase("Done")) {
                continueOrdering = false;
            } else if (menu.containsKey(foodItem)) {
                System.out.print("Quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                order.put(foodItem, quantity);
            } else {
                System.out.println("Sorry, Invalid Option, Please Choose Again");
            }
        }

        // Total Price
        double total = calculateTotal(menu, order);

        // Print Total Price
        System.out.println("\nYour Order:");
        for (String item : order.keySet()) {
            int quantity = order.get(item);
            double price = menu.get(item);
            System.out.println(item + " x " + quantity + ": RM" + (quantity * price));
        }
        System.out.println("Total Price: RM" + total);

        // Release Resources
        scanner.close();
    }

    // Calculate Total Price
    private static double calculateTotal(Map<String, Double> menu, Map<String, Integer> order) {
        double total = 0;

        for (String item : order.keySet()) {
            int quantity = order.get(item);
            double price = menu.get(item);
            total += quantity * price;
        }

        return total;
    }

}

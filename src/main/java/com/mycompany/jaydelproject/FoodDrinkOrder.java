/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.jaydelproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author CL2~PC19
 */
public class FoodDrinkOrder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        HashMap<String, Integer> foodMenu = new HashMap<>();
        foodMenu.put("Hotdog", 25);
        foodMenu.put("Burger", 30);

        HashMap<String, Integer> drinkMenu = new HashMap<>();
        drinkMenu.put("Coke", 20);
        drinkMenu.put("Water", 15);

        
        ArrayList<String> orderedItems = new ArrayList<>();
        HashSet<String> uniqueItems = new HashSet<>();
        HashMap<String, Integer> orderQty = new HashMap<>();

        
        System.out.println("\n--- FOOD MENU ---");
        System.out.println("[0] - None");
        int fIndex = 1;
        for (String food : foodMenu.keySet()) {
            System.out.println("[" + fIndex + "] - " + food + " " + foodMenu.get(food));
            fIndex++;
        }
        System.out.print("Enter food choice: ");
        int foodChoice = input.nextInt();

        if (foodChoice > 0 && foodChoice <= foodMenu.size()) {
            String foodItem = (String) foodMenu.keySet().toArray()[foodChoice - 1];
            if (!uniqueItems.contains(foodItem)) {
                System.out.print("Enter quantity: ");
                int qty = input.nextInt();
                orderedItems.add(foodItem);
                uniqueItems.add(foodItem);
                orderQty.put(foodItem, qty);
            }
        }

        
        System.out.println("\n--- DRINKS MENU ---");
        System.out.println("[0] - None");
        int dIndex = 1;
        for (String drink : drinkMenu.keySet()) {
            System.out.println("[" + dIndex + "] - " + drink + " " + drinkMenu.get(drink));
            dIndex++;
        }
        System.out.print("Enter drink choice: ");
        int drinkChoice = input.nextInt();

        if (drinkChoice > 0 && drinkChoice <= drinkMenu.size()) {
            String drinkItem = (String) drinkMenu.keySet().toArray()[drinkChoice - 1];
            if (!uniqueItems.contains(drinkItem)) {
                System.out.print("Enter quantity: ");
                int qty = input.nextInt();
                orderedItems.add(drinkItem);
                uniqueItems.add(drinkItem);
                orderQty.put(drinkItem, qty);
            }
        }

        
        double total = 0;
        for (String item : orderedItems) {
            int price = 0;
            if (foodMenu.containsKey(item)) {
                price = foodMenu.get(item);
            } else if (drinkMenu.containsKey(item)) {
                price = drinkMenu.get(item);
            }
            int qty = orderQty.get(item);
            total += price * qty;
        }

        
        System.out.println("\nDiscount Category:");
        System.out.println("[1] - None");
        System.out.println("[2] - Senior Citizen (20%)");
        System.out.println("[3] - PWD (15%)");
        System.out.println("[4] - Pregnant (10%)");
        System.out.print("Enter category: ");
        int category = input.nextInt();

        double discount = 0;
        if (category == 2) discount = 0.20;
        else if (category == 3) discount = 0.15;
        else if (category == 4) discount = 0.10;

        double discountedTotal = total - (total * discount);
        double vat = discountedTotal * 0.12;
        double netSales = discountedTotal - vat;

        // Payment
        int cash;
        do {
            System.out.print("\nEnter payment: ");
            cash = input.nextInt();
            if (cash < discountedTotal) {
                System.out.println("Not enough cash, try again.");
            }
        } while (cash < discountedTotal);

        double change = cash - discountedTotal;

        
        System.out.println("\n----- RECEIPT -----");
        if (orderedItems.isEmpty()) {
            System.out.println("No items ordered.");
        } else {
            for (String item : orderedItems) {
                int qty = orderQty.get(item);
                int price = foodMenu.containsKey(item) ? foodMenu.get(item) : drinkMenu.get(item);
                double subTotal = qty * price;
                System.out.println(item + " x" + qty + " @ " + price + " = " + subTotal);
            }
        }
        System.out.printf("\nTotal: %.2f\n", total);
        System.out.printf("Discount (%.0f%%): -%.2f\n", discount * 100, total * discount);
        System.out.printf("Discounted Total: %.2f\n", discountedTotal);
        System.out.printf("VAT (12%%): %.2f\n", vat);
        System.out.printf("Net Sales: %.2f\n", netSales);
        System.out.printf("Cash: %.2f\n", (double) cash);
        System.out.printf("Change: %.2f\n", change);
        System.out.println("-------------------");

        input.close();
    }
}

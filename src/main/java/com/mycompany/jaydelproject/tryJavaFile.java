/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.jaydelproject;

import java.util.Scanner;

/**
 *
 * @author CL2~PC19
 */
public class tryJavaFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    Scanner input = new Scanner(System.in);

System.out.println("CAFETERIA");
System.out.println("[1] - Snacks");
System.out.println("[2] - Drinks");

System.out.print("Enter your choice: ");
int choice = input.nextInt();

if (choice == 1) {
    System.out.println("Snacks!");
    System.out.println("[1] = Hotdog [25.00]");
    System.out.println("[2] = Siomai [14.00]");

    System.out.print("Enter your choice of snacks: ");
    int snackChoice = input.nextInt();

    if (snackChoice == 1) {
        System.out.println("You chose hotdog");
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        int price = 25;
        int subtotal = quantity * price;
        double tax = subtotal * 0.12; // Assuming 12% tax rate
        double total = subtotal + tax;

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Tax: " + tax);
        System.out.println("Total: " + total);

        System.out.print("Enter your cash: ");
        double cash = input.nextDouble();
        while (cash < total) {
            System.out.println("Insufficient cash. Please enter a valid amount.");
            System.out.print("Enter your cash: ");
            cash = input.nextDouble();
        }
        double change = cash - total;
        System.out.println("Change: " + change);
    } else if (snackChoice == 2) {
        System.out.println("You chose siomai");
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        int price = 14;
        int subtotal = quantity * price;
        double tax = subtotal * 0.12; // Assuming 12% tax rate
        double total = subtotal + tax;

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Tax: " + tax);
        System.out.println("Total: " + total);

        System.out.print("Enter your cash: ");
        double cash = input.nextDouble();
        while (cash < total) {
            System.out.println("Insufficient cash. Please enter a valid amount.");
            System.out.print("Enter your cash: ");
            cash = input.nextDouble();
        }
        double change = cash - total;
        System.out.println("Change: " + change);
    } else {
        System.out.println("Invalid snack choice");
    }
} else if (choice == 2) {
    System.out.println("Drinks");
} else {
    System.out.println("Invalid drink choice");
}
    }
}

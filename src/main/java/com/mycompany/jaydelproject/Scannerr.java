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
public class Scannerr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);

        int hb1 = 5;
        int hb2 = 5;

        while (hb1 > 0 && hb2 > 0) {  // game continues while both players have health
            System.out.println("\n[1] - rock");
            System.out.println("[2] - paper");
            System.out.println("[3] - scissor");

            System.out.print("Enter Player 1: ");
            int x = input.nextInt();

            System.out.print("Enter Player 2: ");
            int y = input.nextInt();

            if (x == y) {
                System.out.println("Draw!");
            } else if ((x == 1 && y == 3) || (x == 2 && y == 1) || (x == 3 && y == 2)) {
                System.out.println("Player 1 wins this round!");
                hb2--;  // decrease player 2's health
            } else {
                System.out.println("Player 2 wins this round!");
                hb1--;  // decrease player 1's health
            }

            System.out.println("Health Bar -> Player 1: " + hb1 + " | Player 2: " + hb2);
        }

        // Final result
        if (hb1 == 0) {
            System.out.println("Player 2 wins the game!");
        } else {
            System.out.println("Player 1 wins the game!");
        }
	}
}


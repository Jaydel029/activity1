/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.jaydelproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author CL2~PC19
 */
public class HMAP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	 // Create a HashMap object called capitalCities
    HashMap<String, String> capitalCities = new HashMap<String, String>();

    // Add keys and values (Country, City)
    capitalCities.put("England", "London");
    capitalCities.put("Germany", "Berlin");
    capitalCities.put("Norway", "Oslo");
    capitalCities.put("USA", "Washington DC");
    System.out.println(capitalCities);
	}
}


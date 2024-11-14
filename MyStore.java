/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mystore;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author TMacRae2026
 */


public class MyStore {
    
    static final double MAX_BUDGET = 250.00;
    
    static ArrayList<Item> cart = new ArrayList<Item>(); // array lists have to be static to be accessed from a static location (static void main)
    static ArrayList<Item> items = new ArrayList<Item>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        
        items.add(new Item("T Shirt", 29.99));
        items.add(new Item("Shoes", 125.99));
        items.add(new Item("Jeans", 60.99));
        items.add(new Item("Jacket", 250.00));
        items.add(new Item("Hat", 25.99));
        items.add(new Item("Shorts", 75.99));
        items.add(new Item("Blouse", 88.99));
        
        for(Item i : items) {
            System.out.println(i);
        }
        System.out.println("\nMax Budget: $" + df.format(MAX_BUDGET));
        
        
        while(true) {
            System.out.print("\nEnter Item you would like to add to your cart (enter 'end' to finish or type cart to view your cart): ");
            String responce = scanner.nextLine();
            if(responce.equalsIgnoreCase("end")) {
                break;
            }
            
            switch(responce.toLowerCase()) {
                case "t shirt":
                    AddToCartCalculated(0);
                    break;
                case "shoes":
                    AddToCartCalculated(1);
                    break;
                case "jeans":
                    AddToCartCalculated(2);
                    break;
                case "jacket":
                    AddToCartCalculated(3);
                    break;
                case "hat":
                    AddToCartCalculated(4);
                    break;
                case "shorts":
                    AddToCartCalculated(5);
                    break;
                case "blouse":
                    AddToCartCalculated(6);
                    break;
                case "cart": //prints out the cart items and the total price of all items in the cart
                    System.out.println("Your cart: ");
                    double totalPrice = 0;
                    for(Item i : cart) {
                        System.out.println(i);
                        totalPrice += i.getDblPrice();
                    }
                    System.out.println("\nYour cart costs: $" + df.format(totalPrice));
                    break;
                default:
                    System.out.println("Please enter an item from the items list: ");
                    for(Item i : items) {
                        System.out.println(i);
                    }
                    break;
                    
            }
        }
        double total = 0;
        for(Item i: cart) {
            total += i.getDblPrice();
        }
        System.out.println("You spent: $" + df.format(total));
        
    }
    
    static void AddToCartCalculated(int itemIndex) { //calculates the amount of money being spent + the next item being added to the cart.
        double total = 0;
        for(Item i: cart) {
            total += i.getDblPrice();
        }
        total += items.get(itemIndex).getDblPrice();
        if(total > MAX_BUDGET) {
            System.out.println("Warning: can't add item to your cart because it exceeds your budget!");
        } else {
            cart.add(items.get(itemIndex));
        }
        
    }
    
}


class Item {
    private String strName;
    private double dblPrice;
    
    @Override
    public String toString() {
        return "Name: " + strName + " Price: " + dblPrice;
    }
    
    public Item(String strName, double dblPrice) {
        this.strName = strName;
        this.dblPrice = dblPrice;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public double getDblPrice() {
        return dblPrice;
    }

    public void setDblPrice(double dblPrice) {
        this.dblPrice = dblPrice;
    }
    
}

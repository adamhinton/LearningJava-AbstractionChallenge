package dev.lpa;

import java.util.ArrayList;

public class Store {

    private ArrayList<ProductForSale> productsForSale;

    public void addItemToOrder(ProductForSale item){
        productsForSale.add(item);
    }

    public void printOrder(){
        for(ProductForSale productForSale : productsForSale){
            System.out.println();
            productForSale.printPricedLineItem();
        }
    }


    public static void main(String[] args) {

    }


    class OrderItem{
        private int quantity;
        private ProductForSale productForSale;

        public OrderItem(int quantity, ProductForSale productForSale) {
            this.quantity = quantity;
            this.productForSale = productForSale;
        }
    }

    abstract class ProductForSale{
        private String type;
        private double price;
        private String description;

        public ProductForSale(String type, double price, String description) {
            this.type = type;
            this.price = price;
            this.description = description;
        }

        public double getSalesPrice(int quantity){
            return quantity * this.price;
        }

        public void printPricedLineItem(int quantity){
            System.out.println(quantity + " x " + this.type + " : " + getSalesPrice(quantity));
        }

        // Not sure what he means here
        public abstract void showDetails();
    }

    class Mug extends ProductForSale{
        public Mug(String type, double price, String description) {
            super(type, price, description);
        }

        @Override
        public void showDetails() {

        }
    }


}



// Storefront for any imaginable item
// Store class should:
// Manage list of products, display product detail
// manage order which should be OrderItem objs
// methods to add item to the order, and print ordered items like a sales receipt

// ProductForSale class:
// type, price, and description fields
// Methods:
// - X get a sales price, a conc method which takes quantity and returns quantity times price
// - X print a Priced Line item, a conc mtd which takes quant and prints itemized line item for order -- with quantity
// and line item price
// - showDetails, an abst method which reps what might be displ'd on product page: type, description, price, and so on


// OrderItem class:
// Fields:
// - quantity
// - Product for sale

// ProductForSale subclasses:
// Two or three classes that extend PFS, that will be products in my store
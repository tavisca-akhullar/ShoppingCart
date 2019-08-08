package com.tavisca.cart.entity;

public class Product
{
   private String name;
   private Category category;
   private  double price;



    public Product(String name, double price,Category category) {
        this.name = name;
        this.price = price;
        this.category=category;

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

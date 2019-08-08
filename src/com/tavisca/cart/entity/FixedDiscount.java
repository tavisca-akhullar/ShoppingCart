package com.tavisca.cart.entity;

import java.util.HashMap;

public class FixedDiscount implements IDiscount {
    public HashMap<Category,Double> discounts;
    private double dicountPercentage;
    public FixedDiscount()
    {
        discounts=new HashMap<>();
        this.dicountPercentage=Vendor.discounValue;
        for (Category category:Category.values())
        {
        discounts.put(category,dicountPercentage);
        }
     }

    @Override
    public double getDiscount(Cart cart) {
         HashMap<Product,Double> cartItems=cart.getCartItems();
        double discount=0.0;
        for (Product product:cartItems.keySet())
        {
            double itemDiscount=discounts.get(product.getCategory());
            discount+=(itemDiscount*cartItems.get(product)*product.getPrice())/100;
        }
        return discount;
    }

}

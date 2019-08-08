package com.tavisca.cart.entity;

import java.util.HashMap;

public class CategoryDiscount implements IDiscount {
    public HashMap<Category,Double> discounts;
    public CategoryDiscount()
    {
        discounts=new HashMap<>();
        for (Category category:Category.values())
        {
            discounts.put(category,20.0);
        }
    }

    @Override
    public double getDiscount(Cart cart) {
        HashMap<Product,Double> cartItems=cart.getCartItems();
        double discount=0.0;
        for (Product product:cartItems.keySet())
        {
            double itemDiscount=discounts.get(product.getCategory());
            discount=(itemDiscount*cartItems.get(product))/100;
        }
        return discount;
    }

}

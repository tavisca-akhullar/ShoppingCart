package com.tavisca.cart.entity;

import com.tavisca.cart.factory.DiscountFactory;

import java.util.*;

public class Bill {
    private Cart cart;
    private IDiscount discount;
    public Bill(Cart cart,String discount) throws Exception
    {
        this.cart=cart;
        this.discount= DiscountFactory.getDiscount(discount);
    }


    public double discountedAmount()
    {
      return discount.getDiscount(cart);
    }


    public double payableAmount()
    {
       return totalAmount()-discountedAmount();
    }


    public double totalAmount()
    {
        double total=0.0;
        HashMap<Product,Double> cartItems=cart.getCartItems();
        for (Product product:cartItems.keySet())
        {
            total+=(product.getPrice()*cartItems.get(product));
        }
        return total;
    }
}

package com.tavisca.cart.entity;

import java.util.*;

public class Bill {
    private double discountedPercentage;
    private Cart cart;
    private List<CartItem> cartItemList;

    public Bill(Cart cart)
    {
        this.cart=cart;
        discountedPercentage=0.0;
        cartItemList=this.cart.getCartItems();
    }

    public double getDiscountedPercentage() {
        return discountedPercentage;
    }

    public void setDiscountedPercentage(double discountedPercentage) {
        this.discountedPercentage = discountedPercentage;
    }

    public double discountedAmount()
    {
        double totalPrice=cart.totalPrice();
        return totalPrice*(discountedPercentage/100);
    }

    public double payableAmount()
    {
        double totalPrice=cart.totalPrice();
        return  totalPrice-this.discountedAmount();
    }
}

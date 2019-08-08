package com.tavisca.cart.entity;

import java.util.HashMap;

    public interface IDiscount
    {
   public HashMap<Category,Integer> discounts = null;
   public double getDiscount(Cart cart);
    }

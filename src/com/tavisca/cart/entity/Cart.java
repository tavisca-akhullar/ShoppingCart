package com.tavisca.cart.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private  List<CartItem> cartItems;
       public Cart()
        {
            cartItems=new ArrayList<>();
        }

    public List<CartItem> getCartItems()
    {
        return cartItems;
    }

    public void AddProduct(CartItem item)
        {
            cartItems.add(item);
        }

     public double totalPrice()
        {
            double total=0.0;
            for(CartItem item:cartItems)
            {
                total+=item.getTotalCount();
            }
            return  total;
        }

}

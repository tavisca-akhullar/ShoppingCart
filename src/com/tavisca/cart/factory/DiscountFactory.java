package com.tavisca.cart.factory;

import com.tavisca.cart.entity.*;

public class DiscountFactory {

    public static IDiscount getDiscount(String discount) throws Exception
    {
       switch(discount) {
           case "Fixed":
               return new FixedDiscount();
           case "Configurable":
               return new ConfigurableDiscount();
           case "Category":
               return new CategoryDiscount();
               default:
                   new IllegalDiscountException("Illegal Discount Type");
       }
       return null;
    }

}

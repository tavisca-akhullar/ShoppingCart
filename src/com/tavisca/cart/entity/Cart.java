package com.tavisca.cart.entity;

import java.util.HashMap;

public class Cart {
    private ShoppingItem shoppingItem;
    private HashMap<Product,Double> cartItems;
       public Cart(ShoppingItem shoppingItem)
        {
            this.shoppingItem=shoppingItem;
            cartItems=new HashMap<Product,Double>();
        }

    public HashMap<Product,Double> getCartItems()
    {
        return cartItems;
    }

    public void addProduct(Product product, double quantity) throws Exception
        {
            HashMap<Product,Double> items=shoppingItem.getShoppingItems();
            if(quantity>0)
               if(items.containsKey(product))
               {
                   cartItems.put(product,quantity);
                   shoppingItem.removeShoppingItem(product,quantity);
               }
            else
                {
                    throw  new ItemNotFoundException("Item Not Found..");
                }
            else
                {
                throw  new InsufficientQuantityException("Insufficient Quantity");
                }
        }

    public void removeProduct(Product product, double quantity) throws  Exception
    {
        HashMap<Product,Double> items=shoppingItem.getShoppingItems();
        if(quantity>0 && quantity<cartItems.get(product) )
            if(items.containsKey(product))
            {
                cartItems.put(product,cartItems.get(product)-quantity);
                shoppingItem.addShoppingItem(product,quantity);
            }
            else
            {
                throw  new ItemNotFoundException("Item Not Found..");
            }
            else
                {
                    throw  new InsufficientQuantityException("Insufficient Quantity");
                }
    }
}

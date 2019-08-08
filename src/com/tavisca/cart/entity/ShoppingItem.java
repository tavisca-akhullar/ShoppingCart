package com.tavisca.cart.entity;

import java.util.HashMap;

public class ShoppingItem {
    private HashMap<Product,Double> shoppingItems;

    public ShoppingItem()
    {
        shoppingItems =new HashMap<>();
    }



    public void addShoppingItem(Product product, double quantity) throws ItemNotFoundException
    {
        if(quantity>=0)
            if(shoppingItems.containsKey(product) )
            {
                shoppingItems.put(product, shoppingItems.get(product)+quantity);
            }
            else
            {
                shoppingItems.put(product,quantity);
            }
        else
        {
            throw new ItemNotFoundException("Item Not found");
        }
    }

    public void removeShoppingItem(Product product, double quantity)
    {
        if(quantity>=shoppingItems.get(product))
        {
            shoppingItems.remove(product);
        }
        else
        {
            shoppingItems.put(product, shoppingItems.get(product)-quantity);
        }
    }

    public HashMap<Product, Double> getShoppingItems() {
        return shoppingItems;
    }
}
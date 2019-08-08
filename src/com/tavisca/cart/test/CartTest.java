package com.tavisca.cart.test;

import com.tavisca.cart.entity.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CartTest
{
    static Product mobile;
    static ShoppingItem shoppingItems;
    static Bill bill;
    static Product pen;
    static  Cart cart;
    @BeforeClass
    public static void initialization()
    {
        try {
            pen=new Product("pen",10, Category.Stationary);
            mobile=new Product("mobile",10000,Category.ELectronics);
            shoppingItems=new ShoppingItem();
            shoppingItems.addShoppingItem(mobile,100);
            cart=new Cart(shoppingItems);
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
        }

    }
    @AfterClass
    public static void cleanUp()
    {
        mobile=null;
        shoppingItems=null;
        bill=null;
        pen=null;
        cart=null;
    }
    @Test
    public void Add_Product_To_Cart()
    {
        try {
            cart.addProduct(mobile,1);
            for (Product product:cart.getCartItems().keySet())
            {
                Assert.assertEquals("mobile",product.getName());
            }
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Remove_Product_From_Cart()
    {
        try {
            cart.addProduct(mobile,2);
            cart.removeProduct(mobile,1);
            for (Product product:cart.getCartItems().keySet())
            {
                Assert.assertEquals("mobile",product.getName());
            }
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

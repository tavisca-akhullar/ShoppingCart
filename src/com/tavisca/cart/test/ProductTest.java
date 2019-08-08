package com.tavisca.cart.test;
import com.tavisca.cart.entity.*;
import org.junit.*;
import org.junit.Test;


public class ProductTest {
    static Product mobile;
    static ShoppingItem shoppingItems;
    static Bill bill;
    static Product pen;
    @BeforeClass
    public static void initialization()
    {
        pen=new Product("pen",10,Category.Stationary);
        mobile=new Product("mobile",10000,Category.ELectronics);
         shoppingItems=new ShoppingItem();

    }

    @AfterClass
    public static void cleanUp()
    {
    mobile=null;
    shoppingItems=null;
    bill=null;
    pen=null;
    }

    @Test
    public void Add_Product_For_Shopping()
    {
        try {
               shoppingItems.addShoppingItem(mobile,100);
                for (Product product:shoppingItems.getShoppingItems().keySet())
                {
                Assert.assertEquals("mobile",product.getName());
                }
            } catch (ItemNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Remove_Product_For_Shopping()
    {
        try {
            shoppingItems.addShoppingItem(mobile,100);
            shoppingItems.addShoppingItem(pen,10000);
            shoppingItems.removeShoppingItem(mobile,100);
            for (Product product:shoppingItems.getShoppingItems().keySet())
            {
                Assert.assertEquals("pen",product.getName());
            }
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
        }
    }

}
package com.tavisca.cart.test;

import com.tavisca.cart.entity.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BillTest {
        static Product mobile;
        static ShoppingItem shoppingItems;
        static Bill bill;
        static Product pen;
        static Cart cart;

        @BeforeClass
        public static void initialization()
        {
            try {
                pen=new Product("pen",10, Category.Stationary);
                mobile=new Product("mobile",10000,Category.ELectronics);
                shoppingItems=new ShoppingItem();
                shoppingItems.addShoppingItem(mobile,100);
                shoppingItems.addShoppingItem(pen,10000);
                cart=new Cart(shoppingItems);
                cart.addProduct(mobile,1);
                cart.addProduct(pen,20);
                bill=new Bill(cart,Vendor.discounttype);
            } catch (ItemNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
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
            bill=null;
        }

    @Test
    public void GetTotalPrice()
    {
        double totalPrice=bill.totalAmount();
        Assert.assertEquals("10200.0",String.valueOf(totalPrice));
    }

    @Test
    public void GetDiscountedPrice()
    {
        double discountedPrice=bill.discountedAmount();
        Assert.assertEquals("1020.0",String.valueOf(discountedPrice));
    }

    @Test
    public void GetPayablePrice()
    {
        double payableAmount=bill.payableAmount();
        Assert.assertEquals("9180.0",String.valueOf(payableAmount));
    }

    }

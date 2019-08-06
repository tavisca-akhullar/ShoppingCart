package com.tavisca.cart.test;


import com.tavisca.cart.entity.Bill;
import com.tavisca.cart.entity.Cart;
import com.tavisca.cart.entity.CartItem;
import com.tavisca.cart.entity.Product;
import org.junit.*;
import org.junit.Test;


public class ProductTest {
    Product product;
    CartItem cartItem;
    Cart cart;
     Bill bill;
    @BeforeClass
    public static void initialization()
    {


    }

    @AfterClass
    public static void cleanUp(){}

    @Test
    public void AddProductToCart()
    {
        product =new Product("soap",50);
        cartItem=new CartItem(product,4);
        cart=new Cart();
        cart.AddProduct(cartItem);
        for (CartItem value:cart.getCartItems()) {
            Assert.assertEquals("soap",product.getName());
        }
     }

     @Test
    public void GetTotal()
     {
         product =new Product("soap",50);
         cartItem=new CartItem(product,4);
         cart=new Cart();
         cart.AddProduct(cartItem);
         double total= cart.totalPrice();
         Assert.assertEquals(Double.toString(200.0),Double.toString(total));
     }

     @Test
    public void GetDiscountedValue()
     {
         product =new Product("soap",50);
         cartItem=new CartItem(product,4);
         Cart cart=new Cart();
         cart.AddProduct(cartItem);
         Bill bill=new Bill(cart);
        bill.setDiscountedPercentage(20);
         Assert.assertEquals(Double.toString(40.0),Double.toString(bill.discountedAmount()));

     }

    @Test
    public void GetPayableValue()
    {
        product =new Product("soap",50);
        cartItem=new CartItem(product,4);
        cart=new Cart();
        cart.AddProduct(cartItem);
        bill=new Bill(cart);
        bill.setDiscountedPercentage(20);
        Assert.assertEquals(Double.toString(160.0),Double.toString(bill.payableAmount()));

    }

}

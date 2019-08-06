package com.tavisca.cart.entity;

public class CartItem {
    private Product product;
    private int qunatity;
    private double totalCount;

    public CartItem(Product product, int qunatity) {
        this.product = product;
        this.qunatity = qunatity;
        totalCount=product.getPrice()*qunatity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQunatity() {
        return qunatity;
    }

    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }

    public double getTotalCount() {
        return totalCount;
    }



    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", qunatity=" + qunatity +
                ", totalCount=" + totalCount +
                '}';
    }
}

package com.tavisca.cart.entity;

    public class InsufficientQuantityException extends Exception {
    public InsufficientQuantityException(String exception)
    {
        super(exception);
    }
}

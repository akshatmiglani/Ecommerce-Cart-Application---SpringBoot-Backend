package com.shoppingcart.akshatshop.exceptions;

public class AlreadyExistsException extends RuntimeException{

    public AlreadyExistsException(String message){
        super(message);
    }
}

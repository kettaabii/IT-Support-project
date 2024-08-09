package com.example.ITsupport.exeption;

public class NoSeatsAvailableException extends RuntimeException{
    public NoSeatsAvailableException(String message){ super(message);}
}

package com.bookMyShow.bookMyShow.Exception;

public class ShowSeatNtAvailableException extends Exception {
    public ShowSeatNtAvailableException(Long id) {
        super("Show seat with id: "+ id +" is not available!");
    }
}

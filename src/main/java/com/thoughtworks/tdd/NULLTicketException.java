package com.thoughtworks.tdd;

public class NULLTicketException extends RuntimeException{

  public NULLTicketException() {
  }
  public NULLTicketException(String message){
    super(message);
  }
}

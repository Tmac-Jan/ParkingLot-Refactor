package com.thoughtworks.tdd;

public class UnlawfulTicketException extends RuntimeException  {
  public UnlawfulTicketException(String message){
    super(message);
  }
public UnlawfulTicketException(){}
}

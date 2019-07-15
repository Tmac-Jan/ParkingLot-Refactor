package com.thoughtworks.tdd;

public class TicketUnlawfulException extends RuntimeException  {
  public TicketUnlawfulException(String message){
    super(message);
  }
public TicketUnlawfulException(){}
}

package com.thoughtworks.tdd;

public class NotEnoughPositionException extends RuntimeException {
  public NotEnoughPositionException(){}

  public NotEnoughPositionException(String message){
    super(message);
  }
}

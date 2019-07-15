package com.thoughtworks.tdd;

import java.io.Serializable;

public class ResultVo<T> implements Serializable {
  private String message ;
  private T Data;

}

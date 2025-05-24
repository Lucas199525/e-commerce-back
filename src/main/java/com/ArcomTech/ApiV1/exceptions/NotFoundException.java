package com.ArcomTech.ApiV1.exceptions;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String element, Object id) {
    super(String.format("%s %s not found", element, id));
  }
}

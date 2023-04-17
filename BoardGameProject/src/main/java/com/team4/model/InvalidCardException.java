
  package com.team4.model;
  
  public class InvalidCardException extends Exception {
  
  public InvalidCardException() { super("Invalid Card, Try Again!"); }
  
  public InvalidCardException(String message) { super(message); }
  
  }
 
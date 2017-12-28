package org.yyf.javase.genericType;

public class Plate<T> {

  private T item;

  public T getItem() {
    return item;
  }

  public void setItem(final T item) {
    this.item = item;
  }
}

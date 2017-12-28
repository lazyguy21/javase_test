package org.yyf.javase.genericType;

public class ExtendsPlate<T extends Fruit> {
  private T item;

  public T getItem() {
    return item;
  }

  public void setItem(final T item) {
    this.item = item;
  }
}

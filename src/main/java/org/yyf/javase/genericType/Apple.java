package org.yyf.javase.genericType;

import java.util.Objects;

public class Apple extends Fruit{
  private String name;
  private String nickName;
  private Integer price;

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Apple apple = (Apple) o;
    return com.google.common.base.Objects.equal(name, apple.name) &&
        com.google.common.base.Objects.equal(nickName, apple.nickName) &&
        com.google.common.base.Objects.equal(price, apple.price);
  }

  @Override
  public int hashCode() {
    return com.google.common.base.Objects.hashCode(name, nickName, price);
  }
}

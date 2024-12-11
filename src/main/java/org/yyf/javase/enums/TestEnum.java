package org.yyf.javase.enums;

import lombok.AllArgsConstructor;

/**
 * Created by @author yyf on 2024/4/28.
 */
@AllArgsConstructor
public enum TestEnum implements BaseEnum {
  Teacher(10,"adsf"),Student(20,"aaa");
  private Integer key;
  private String label;
  @Override
  public Integer getKey() {
    return key;
  }

  @Override
  public String getLabel() {
    return label;
  }
}

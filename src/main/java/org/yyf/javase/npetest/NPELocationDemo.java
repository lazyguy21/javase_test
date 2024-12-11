package org.yyf.javase.npetest;

import lombok.Data;

/**
 * Created by @author yyf on 2024/10/16.
 */
public class NPELocationDemo {

  public static void main(String[] args) {
   User user = new User();
    System.out.println();
//    String location = user.getAddress().getLocation();
//    System.out.println(location);

    String location1 = user.address.location;

  }
  @Data
  public static class User{
    public Address address;

    @Data
    private class Address{
      private String location;
    }
  }
}

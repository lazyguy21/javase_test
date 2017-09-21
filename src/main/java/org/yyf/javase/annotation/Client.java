package org.yyf.javase.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@BaseDemo(name = "tobi",friends = "123")
public class Client {
  public static void main(String[] args) throws Exception {
    Class<?> aClass = Client.class;
    Annotation[] annotations = aClass.getAnnotations();
    System.out.println(Arrays.toString(annotations));
    Class<? extends Annotation> aClass1 = annotations[0].annotationType();
    System.out.println(aClass1);
    try{
      throw new RuntimeException();
    }catch (RuntimeException e){
      System.out.println(1);
      throw e;
    }catch (Exception e){
      System.out.println(2);
      throw e;
    }
  }


}

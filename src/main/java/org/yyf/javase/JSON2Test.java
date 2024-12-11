package org.yyf.javase;

import com.alibaba.fastjson2.JSON;
import java.util.Date;
import lombok.Data;

/**
 * Created by @author yyf on 2024/6/4.
 */
public class JSON2Test {


  public static void main(String[] args) {
    String t = "{\n"
        + "  \"dD\": 1717466361305\n"
        + "}";
    TDate tDate = JSON.parseObject(t, TDate.class);
    System.out.println(tDate.getDD());
  }

  @Data
  class TDate {
    private Date dD;

  }

}

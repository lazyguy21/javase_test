package org.yyf.javase.java9.collection;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.yyf.javase.domain.User;

/**
 * Created by @author yyf on 2024/9/12.
 */
public class tt {

  public static void main(String[] args) {
    User user = new User();
    ArrayList<User> users = Lists.newArrayList(user);
    List<Long> collect = users.stream().map(User::getId).collect(Collectors.toList());
    System.out.println(collect);
  }

}

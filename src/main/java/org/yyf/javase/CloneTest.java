package org.yyf.javase;

import org.yyf.javase.domain.App;
import org.yyf.javase.domain.User;

/**
 * Created by lazyguy on 2016-4-28.
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User();
        user.setId(1L);
        user.setName("aa");
        App app = new App();
        app.setId(1L);
        app.setName("zfe");
        user.setApp(app);
        Object clone = user.clone();
        System.out.println(user);
        System.out.println(clone);
        System.out.println(user==clone);
        System.out.println(((User)clone).getApp()==app);
    }
}

package org.yyf.javase.serialize;

import java.io.Serializable;

/**
 * Created by tobi on 16-7-26.
 * a
 */
public class User implements Serializable{
//    private static final long serialVersionUID = -763618247875550322L;
    private Integer age;
    private String name;
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

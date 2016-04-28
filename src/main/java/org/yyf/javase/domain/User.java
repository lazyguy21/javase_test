package org.yyf.javase.domain;

/**
 * Created by lazyguy on 2016-4-28.
 */
public class User implements Cloneable {
    private Long id;
    private String name;
    private App app;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
//        App app = ((User) clone).getApp();
//        ((User) clone).setApp(app.clone);
        return clone;
    }
}

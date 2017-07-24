package org.yyf.javase.domain;

/**
 * Created by lazyguy on 2016-4-28.
 */
public class App {
    private Long id;
    private String name;

    public App(final Long id) {
        this.id = id;
    }

    public App(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public App() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

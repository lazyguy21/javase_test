package org.yyf.javase.reference;

class DemoObject {
    @Override
    public String toString() {
        return "demo";
    }

    // finalize method
    public void finalize() {
        System.out.println("Finalize method is called");
    }
} 
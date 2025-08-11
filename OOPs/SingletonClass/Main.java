package com.kunal.singleton;


public class Main {
    public static void main(String[] args) {
        // Singleton obj = new Singleton(); // private constructor is not assisble
        Singleton obj1 = Singleton.getInstance();

        Singleton obj2 = Singleton.getInstance();

        Singleton obj3 = Singleton.getInstance();
        System.out.println(obj1.getClass()+""+obj2.getClass());

        // all 3 ref variables are pointing to just one object

        // A a = new A(10, "Kunal");
        // a.getNum();
//        int n = a.num;
    }
}



class Singleton {
    private Singleton () {

    }

    private static Singleton instance;

    public static Singleton getInstance() {
        // check whether 1 obj only is created or not
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

}
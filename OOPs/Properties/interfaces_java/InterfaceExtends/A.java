package interfaces_java.InterfaceExtends;

public interface A {
    int a = 10; // auto. public static final
    static void vikash(){
        System.out.println("Vikash");
    }
    void fun();
}

abstract class InnerA implements A { // abstract class can implement interface

    
}
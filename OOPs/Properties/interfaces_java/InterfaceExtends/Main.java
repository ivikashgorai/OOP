package interfaces_java.InterfaceExtends;

public class Main implements B {

    @Override
    public void fun() {
    }

    @Override
    public void greet() {
       
    }
    public static void main(String[] args) {
        A b = new Main();
        System.out.println(b.a); // we can call variable but by object but not static methods
    }
    
}

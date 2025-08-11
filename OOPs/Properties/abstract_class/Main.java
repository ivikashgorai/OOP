package abstract_class;

abstract class  GrandParents {
 abstract void carrier2();
    
}
abstract class Parent extends GrandParents{
    static int age;
    int a;
    public Parent(int age){ // abstract class can have instance variable and constructor
        this.age = age;
        a=10;
    }
    
    //static method in abstract class
    static void meth(){ // agar sirf void meth rehta toh kabhi call nhi ho pata kyuki object required hota call karne ke liye jo ki abstract class ka nhi ban sakta
        System.out.println("Static");
    }

    void normal(){ //concrete method in abstract class
        System.out.println("I am normal method");
    }

    abstract void carrier(); // jitne bhi yaha abstract method honge wo sare method use hone chaiye child mein
    abstract void partner();
}

class Son extends Parent {
    public Son(int age){
        super(age);
        this.age = age;
    }

    // Parent p = new Parent(); we cannot make object of parent class but constructor can be made and can be called by child class  
    @Override
    void carrier() {
        System.out.println("I want to be a Doctor");
    }

    @Override
    void partner() {
        System.out.println("Her name is Son");
    }

    @Override
    void carrier2() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'carrier2'");
    }
}

class Daughter extends Parent {
     public Daughter(int age){
        super(age);
        this.age = age;
    }

    @Override
    void carrier() {
        System.out.println("I want to be a Housewife");
    }

    @Override
    void partner() {
        System.out.println("Her name is daughter");
    }

    @Override
    void carrier2() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'carrier2'");
    }
}

public class Main {
    public static void main(String[] args) {
        Son son = new Son(22); // we know overriding depend on object not refrence type
        Daughter daughter = new Daughter(19);
        Parent parent = new Son(20);
        parent.normal();
        parent.meth();
        parent.carrier(); // Son is ovverriding so its depends on Object, so sons carrier got printed
        son.carrier(); // simple overriding
        son.partner();
        daughter.carrier();
        Parent.meth();
        son.normal();
        System.out.println(Parent.age);
        son.meth();
      //  Parent son3 = new Son(21); // we can also write like this
       //Error --> Parent parent = new Parent(); // we cannot create object of abstract class
    }
}

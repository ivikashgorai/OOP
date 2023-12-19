package Inheritance;

public class Main {
    public static void main(String[] args) {
        Box b1 = new Box();
      //  System.out.println(b1.weight);// this will give an error because child class variable are not accessed by parent class
        Extendsuper box1 = new Extendsuper();
        Extendsuper box2 = new Extendsuper(1, 2, 3, 4);
        System.out.println(box2.weight + " " + box1.l);

        Box b2 = new Extendsuper(1, 2, 3, 5);
      //  System.out.println(b2.weight);// this will give an error because it type of refrence varibale not object which determines what member can be accessed
        Box b3 = new Extendsuper(1, 2, 3, 5);
        System.out.println(b2.w);// not give error because it is type of refrence varibale which defines which member to call not type of object
        // also child object has all access to superclass but parent does not have access to child class
            
       // Extendsuper b4 = new Box(1,2,3); // this will give error because a child refrence variable and parent object is there
        //here object is type of parent and parent class is not aware of variable and methods of child class
        // parent class does not have access of child class variable and method
        //so thius will give an error,so weight cant be initialized by.
        
    }
}

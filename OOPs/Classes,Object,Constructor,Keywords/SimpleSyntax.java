
public class SimpleSyntax{
    public static void main(String[] args) {
        //Creating an object named Vikash
        Student2 Vikash = new Student2(22,"vikjh",9.99f);
        Student2 abhishek = new Student2(22,"wtf",8.9f);
        System.out.println(Vikash.marks);
        System.out.println(abhishek.name);
    }
}
// Creating an class named Student
class Student2{
    int marks;
    String name;
    float percent;
     Student2 (int markss,String vik,float per){
        // when we dont want the initial value of all object same or when it is not same
        // variable name of function should be different fron class variable
        marks = markss;  
        name = vik;
        percent = per;       
        }
    }

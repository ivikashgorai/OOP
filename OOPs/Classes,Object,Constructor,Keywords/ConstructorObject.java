// cerating a constructor that taking value from another object 
public class ConstructorObject{
    public static void main(String[] args) {
        Student Vikash = new Student(2,"Vik",99.9f);
        Student random = new Student(Vikash);
        // this will be rplace by random and other will be replace by Vikash
        System.out.println(random.marks);
    }
}
class Student{
    int marks;
    String name;
    float percent;
    
    Student(Student other){
        // this will be rplace by random and other will be replace by Vikash
        this.marks = other.marks;
    }

    Student(int marks,String name,float percent){
        this.marks = marks;
        this.name = name;
        this.percent = percent;
    }
}

// cerating a constructor that taking value from another object 
public class ConstructorObject{
    public static void main(String[] args) {
        Student5 Vikash = new Student5(2,"Vik",99.9f);
        Student5 random = new Student5(Vikash);
        // this will be rplace by random and other will be replace by Vikash
        System.out.println(random.marks);
    }
}
class Student5{
    int marks;
    String name;
    float percent;

    Student5(Student5 other){
        // this will be rplace by random and other will be replace by Vikash
        this.marks = other.marks;
    }

    Student5(int marks,String name,float percent){
        this.marks = marks;
        this.name = name;
        this.percent = percent;
    }
}

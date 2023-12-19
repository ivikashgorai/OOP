public class finalKeyword {
    public static void main(String[] args) {
        Student Vikash = new Student(22,99.9f,"VV");
        Student random = new Student(Vikash); 
        // final int A =5;         
        //  A =6; // error value of A will not change  
        final Student Arpit = new Student(2, 99.9f, "Arpit");
        Arpit.marks = 33; // final keyword does not work on non primitive datatype we can change the value of object but we cant change the object to other object 
        //refrence variable of object will always point toward the same object.
       //  Arpit = Vikash; // this will give an error because of final keyword,  refrence variable of arpit is pointing towards object vikash
    }
}
class Student{
    int marks;
    float percent;
    String name;

    Student(Student other){
        this.marks = other.marks;
    }

    Student(int marks,float percent,String name){
         this.marks = marks;
         this.percent = percent;
         this.name = name;
    }
  
}

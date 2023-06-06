public class Thissyntax {
        public static void main(String[] args) {
            //Creating an object named Vikash
            Student Vikash = new Student(2,"hero",22.3f);
            Student abhishek = new Student();
            System.out.println(Vikash.name);
            System.out.println(abhishek.name);
        }
    }
    // Creating an class named Student
    class Student{
        int marks;
        String name;
        float percent;
         Student (){ // tjis wii make all object created with zero function variable , value same
            this.marks =5;
            this.name ="vik";
            this.percent = 88.9f;   
            }
         //   Student(int number, String naam, float per){
           //     marks = number;  // can be this but variable name cant be same here
             //   name = naam;
               // percent = per;
           // }
            Student(int marks,String name,float percent){
                this.marks = marks;  // instead of above we can use this everytime;
                this.name = name;
                this.percent = percent;
            }
        }

public class thisSyntax {
        public static void main(String[] args) {
            //Creating an object named Vikash
            Student Vikash = new Student(2,"hero",22.3f); // this will be replaced by Vikash
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
         int equal;
         Student (){ // tjis wii make all object with zero function variable , value same
            // this will be replaced by object name
            this.marks =5;
            this.name ="vik";
            this.percent = 88.9f; 
            }
         //   Student(int number, String naam, float per){
           //     marks = number;  // can be this but variable name cant be same here
             //   name = naam;
               // percent = per;
           // }

           // Student arpit = new Student(90,"Arpit",99.9f);
           // here this is replced by arpit
            Student(int marks,String name,float percent){
                this.marks = marks;  // instead of above we can use this everytime;
                this.name = name;
                this.percent = percent;
                this.equal = 2023; //equal for all object that calls this constructor
            }
        }

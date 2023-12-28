package compare;

public class Main {
    public static void main(String[] args) {
        Student one = new Student(22);
        Student two = new Student(44);

        if (one < two) { // to do this comparing thing we have to implement comparable // will do it later
            System.out.println("one is smaller");
        }
    }
}

class Student {
    int rollno;
    

    public Student(int roll) {
        this.rollno = roll;
    }
}

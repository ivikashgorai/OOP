package compare;

public class Main  {
    public static void main(String[] args) {
        Student one = new Student(22, 85.2);
        Student two = new Student(44, 74.3);

        if (one.compareTo(two)>0) { // to do this comparing thing we have to implement comparable
            System.out.println("one is bigger");
        }
    }
}

class Student implements Comparable<Student> {
    int rollno;
    double marks;

    public Student(int roll,double marks) {
        this.rollno = roll;
        this.marks = marks;
    }

    @Override 
    public int compareTo(Student o) { // comparing marks only
        int diff = (int) (this.marks - o.marks);
        return diff;
    }
}

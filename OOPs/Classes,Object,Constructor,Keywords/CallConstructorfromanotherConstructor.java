public class CallConstructorfromanotherConstructor {
    public static void main(String[] args) {
        Student Vikash = new Student(22,"Vik",99.9f);
        Student random = new Student();
        System.out.println(random.marks);
    }
}
class Student{
    int marks;
    String name;
    float percent;
    Student(){
        // Calling a constructor from another constructor
        // internally : new Student(33,"Vvv",88.5f);
      this(33,"Vvv",88.5f);
    }

    Student(int marks,String name,float percent){
            this.marks = marks;
            this.name = name;
            this.percent = percent;
    }
}

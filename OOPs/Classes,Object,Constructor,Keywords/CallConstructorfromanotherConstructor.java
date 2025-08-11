public class CallConstructorfromanotherConstructor {
    public static void main(String[] args) {
        Student4 Vikash = new Student4(22,"Vik",99.9f);
        Student4 random = new Student4();
        System.out.println(random.marks);
    }
}
class Student4{
    int marks;
    String name;
    float percent;
    Student4(){
        // Calling a constructor from another constructor
        // internally : new Student(33,"Vvv",88.5f);
        //   System.out.println("Hello"); // ❌ Compilation error
          //   Constructor call must be the first statement in a constructor // no code before constructor call
      this(33,"Vvv",88.5f); // known as constructor chaining
      //only one constructor calling is allowed
    //    this(50, "Another", 90.0f); // ❌ Error: Constructor call must be the first statement
    }

    Student4(int marks,String name,float percent){
            this.marks = marks;
            this.name = name;
            this.percent = percent;
    }
}

public class finalizeMethod {
    public static void main(String[] args) {
        Student Vikash;
        for (int i = 0; i < 1000000000; i++) {
            Vikash = new Student(33,"Hit" ,99.8f); // so many objects are creating at one by one so java have to garbage it after use
            System.out.println(Vikash.marks);
        }
      
    }
}
class Student{
    int marks;
    String name;
    float percent;
 
    Student(int marks,String name,float percent){
            this.marks = marks;
            this.name = name;
            this.percent = percent;
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Vikash"); // in last it will print vikash
    }
}

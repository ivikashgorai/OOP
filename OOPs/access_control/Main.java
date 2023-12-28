package access_control;

public class MaIn {
    public static void main(String[] args) {
        Class one = new Class(5, "Vikash");
        // need to do a few things
        // 1. Access the data member
        // 2. Modify the data member
        one.num = 44; // can't access the num because it is private this is known as data hiding
        // we can access it by getters and setters (this is the method we use to access
        // the private refrence)
      one.getNum();
      one.setNum(22);
    }
}

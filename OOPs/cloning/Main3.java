import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human4 vikash = new Human4(34,"Vikash");
        // Human4 kunal = new Human4(vikash); // creating the exact copy , but due to new keyword it will take lot of processing so we use Clonable 

        // we have to implement Clonable interface to the class which want to make clone of

        Human4 twin = (Human4) vikash.clone(); // shallow copying, therefore if we change in vikash object then twin object will also change, primitive will not change, for primitive new copies are made but for objects/non-primitive like array,String points to the same object only
        System.out.println(twin.age);
        vikash.age = 10;
        System.out.println(twin.age);
        //age is independent in both as they are primitive
        System.out.println(vikash.age);

        System.out.println(Arrays.toString(vikash.arr));
        System.out.println(Arrays.toString(twin.arr));
        vikash.arr[0] = 10;
        System.out.println(Arrays.toString(vikash.arr));
        System.out.println(Arrays.toString(twin.arr));
        vikash.name ="allo";
        System.out.println(twin.name);
        // both are changing as it is shallow copying , so objects remains same

        // Deep-copying - making the diffrent object but value will be same, change in one does not affect in other, both are diffrent object

    }
}

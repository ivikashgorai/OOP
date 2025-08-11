import java.util.ArrayList;
import java.util.Arrays;

//Restriction on Generics
// https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html#createObjects

public class CustomGenArrayListRestrict<T extends Number> { //just array ke samne object likhna hai yani ki array object type ka banana hai baki jagah T, use type casting

    //here T could be Number or its Subclasses

    private static Object[] data; // make thing here static  and make display method static
    private static int i = -1;
    private final static int size = 5;

    public CustomGenArrayListRestrict() {
        data = new Object[size]; // array Object type hoga bas
    }

    public CustomGenArrayListRestrict(int size2) {
        data = new Object[size2];
    }

    public void add(T value) {
        if (i == data.length - 1) {
            Object[] copy = new Object[data.length * 2];
            for (int j = 0; j <= data.length - 1; j++) {
                copy[j] = data[j];
            }
            data = copy;
            i += 1;
            data[i] = value;
            return;
        }
        i += 1;
        data[i] = value;
        return;
    }

    public static void display() {
       System.out.println(Arrays.toString(data));
    }

    public T get(int index) {
        if (i < index) {
            System.out.println("Value not initialized at index " + index);
        }
        return (T) data[index];
    }

    public Object remove(int index) {
        if (i < index) {
            System.out.println("Value not initialized at index " + index);
            return -1;
        }
        if (index == i) {
            i -= 1;
            return (T)data[index];
        } else {
            T a = (T) (data[index]);
            for (int j = index; j <= i; j++) {
                data[j] = data[j + 1];
            }
            i -= 1;
            return a;
        }
    }

    public static void main(String[] args) {
        // CustomGenArrayList<Integer> list = new CustomGenArrayList<>(); // problem --> it can only store integer
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // list.add(6);
        // list.add(7);
        // list.display();
        // System.out.println(list.remove(2));
        // list.display();
        // System.out.println(list.get(2));
        // list.display();
        // list.add(10);
        // list.display();

//        CustomGenArrayListRestrict<String> list2 = new CustomGenArrayListRestrict<>(); // this will give error as number requeired
//        list2.add("Vikas"); // we cant add string because T extends Number class which contain integer ,float,double etc
//        list2.add("Gorai");
//        list2.add("Hii");
//        display();
//        list2.remove(0);
//        display();
//        System.out.println( list2.get(1));
//        display();

    }
}

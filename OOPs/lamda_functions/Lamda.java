import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Lamda {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list.forEach((item) -> { // taking item as parameter // item represent every single value of list
            System.out.println(item * 2); // body of the lamda function
        });

        Comparator<Integer> comparator = (a, b) -> {
            return Integer.compare(b, a);
        };
        Collections.sort(list, comparator);
        System.out.println(list);

        Operation sum = (a, b) -> {
            return a + b;
        };
        Operation mul = (a, b) -> {
            return a * b;
        };

        Lamda fun = new Lamda();
        System.out.println(fun.operate(3,4,sum));
    }

    private int operate(int a,int b,Operation op){
        return op.operation(a, b);
    }

}

interface Operation {

    int operation(int a, int b);

}
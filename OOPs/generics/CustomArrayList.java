import java.util.Arrays;

public class CustomArrayList {

    private int[] data;
    private int i = -1;
    private final static int size = 5;

    public CustomArrayList() {
        data = new int[size];
    }

    public CustomArrayList(int size2) {
        data = new int[size2];
    }

    public void add(int value) {
        if (i == data.length - 1) {
            int[] copy = new int[data.length * 2];
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
    public void display(){
        int[] ret = new int[i+1];
        for(int j=0;j<ret.length;j++){
            ret[j] = data[j];
        }
        System.out.println(Arrays.toString(ret));
    }

    public int get(int index) {
        if (i < index) {
            System.out.println("Value not initialized at index " + index);
            return -1;
        }
        return data[index];
    }

    public int remove(int index){
        if (i < index) {
            System.out.println("Value not initialized at index " + index);
            return -1;
        }
        if(index==i){
            i-=1;
            return data[index];
        }
        else{
              int a = data[index];
            for(int j=index;j<=i;j++){
                data[j] = data[j+1];
            }
            i-=1;
            return a;
        }
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList(); // problem --> it can only store integer 
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        // list.remove(6);
        // System.out.println(list.get(6));
        // System.out.println(list.remove(6));
        // System.out.println(list.get(6));
        list.display();
        System.out.println(list.remove(2));
        list.display();
        System.out.println(list.get(2));
        list.display();
        list.add(10);
        list.display();
    }
}

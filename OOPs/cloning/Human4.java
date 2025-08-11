public class Human4 implements Cloneable { // implements just to tell that Human4 class is allowed to cloned
    int age;
    String name;
    int[] arr;
    public Human4(int age, String name){
        this.age = age;
        this.name = name;
        this.arr =  new int[] {1,2,3,4,5};
    }

    public Human4(Human4 other){
        this.name = other.name;
        this.age = other.age;
        this.arr = other.arr;
    }

    // @Override
    // protected Object clone() throws CloneNotSupportedException {
    //     //this is shallow copy
    //     return super.clone();
    // }

        @Override
    protected Object clone() throws CloneNotSupportedException {
        //this is deep copy
        Human4 twin = (Human4) super.clone(); // shallow


        //deep
        twin.name = new String(this.name);
        twin.arr = new int[this.arr.length];

        for(int i=0;i<this.arr.length;i++){
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }
}

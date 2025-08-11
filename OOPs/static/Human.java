public class Human {
    int age;
    String name;
    int height;
    static long population;
    Human(int age,String name,int height){
        this.age = age;
        this.height = height;
        this.name = name;
        population +=1; // this. also works but it does not make sense
    }
}

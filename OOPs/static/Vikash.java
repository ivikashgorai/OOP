public class Vikash {
    public static void main(String[] args) {
        Human vikash = new Human(22,"Vikash",32);
        Human arpit = new Human(343,"arpit",555);
        // dont have to import if class/function
        // present in same package
        System.out.println(vikash.age);
        System.out.println(Human.population); // can asswssed population even without creating an object
    }
}

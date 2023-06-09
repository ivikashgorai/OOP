package packages.b;
import static packages.a.Greeting.message;
public class Greeting {
    public static void main(String[] args) {
        System.out.println("Vii");
        message();// we can call the function of other class of same sub director
                   //  or directory(if no subdirectory exist) in another class of same sub directory
                       // but method or function must me public
    }
}

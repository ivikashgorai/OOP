import java.util.*;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
            String name = "kunal";
            if(name.equals("kunal")){
                throw new MyException("Got an Exception");
            }
        }
        catch (MyException e) { // catch only ArithmeticException
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) { // catch only ArithmeticException
            System.out.println(e.getMessage());
        } catch (Exception e) { // catch any other exception
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Code finished");
        }
    }

    static int divide(int a, int b) throws Exception {
        if (b == 0) {
            throw new ArithmeticException("Please do not divide by zero");
        }
        return a / b;
    }
}

public class Main1 {
    public static void main(String[] args) {
        int a = 3;
        int b  = 2;
        try{
            divide(a,b);
            throw new MyException("My exception");
        }
          catch(MyException e){
            System.out.println(e.getMessage());
        }
        catch(ArithmeticException e){ // catches only Arthemetic exception, if we want to catch every exception the use Exception e
            System.out.println(e.getMessage());
        }
        finally{
            //runs no matter exception or not
        }

    }
    static int divide(int a,int b)  throws ArithmeticException{
        if(b==0) throw new ArithmeticException("b is 0");

        return a/b;
    }
}

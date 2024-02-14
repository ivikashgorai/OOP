public class Main2 {
    public static void main(String[] args) {
        int a =10,b=0,c;
        try{
            c = a/b;
        }
        catch(Exception e){
            System.out.println("cannot divide by zero"+e.getMessage());
        }
        finally{
            System.out.println("Okay");
        }
    }
}

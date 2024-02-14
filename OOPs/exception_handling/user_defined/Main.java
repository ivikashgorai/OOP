package user_defined;

public class Main {

    public static void main(String[] args) throws InvalidAgeException {
       try{
         vote(15); // risky code may be give exception
          vote(19); // exception agaya upar ab ye code nhi chalega neeche wala
       }
       catch(InvalidAgeException e){
        System.out.println(e);
       }
        
    }
    public static void vote(int age) throws InvalidAgeException { // we created this exception
        if(age<18){
            throw new InvalidAgeException("Age is not above or equal to 18");
        }
        else{
            System.out.println("Okay");
        }
    }
}

class InvalidAgeException extends Throwable { // hamesha throwable ko extend karna hoga jab bhi new exception baneyenge user defined
    public InvalidAgeException(){
        System.out.println("InvalidAgeException");
    }

  public InvalidAgeException(String name){
    System.out.println(name);
  }
}
// import java.util.Scanner;
import java.io.*;
public class InputStreamRead{
    public static void main(String[] args) {
      try{
        InputStreamReader reader = new InputStreamReader(System.in);
        System.out.println("Enters some letters");
        int letters =  reader.read();
        while(reader.ready()){
            System.out.println((char) letters);
            letters = reader.read();
        }
        // reader.close(); dont have to write this it will auto. close new java feature
        System.out.println();
      }
      catch(Exception e){
        System.out.println(e.getMessage());
      }
    }
}
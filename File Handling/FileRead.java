// import java.util.Scanner;
import java.io.*;
public class FileRead{
    public static void main(String[] args) {
      try{
        FileReader fr = new FileReader("notes.txt");
        System.out.println("Enters some letters");
        int letters =  fr.read();  // read take/returns only integer
        while(fr.ready()){
            System.out.println((char) letters);
            letters = fr.read();
        }
        // reader.close(); dont have to write this it will auto. close new java feature
        System.out.println();
        fr.close();
      }
      catch(Exception e){
        System.out.println(e.getMessage());
      }
    }
}
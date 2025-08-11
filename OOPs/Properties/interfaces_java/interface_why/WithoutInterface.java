package interfaces_java.interface_why;

public class WithoutInterface {
    public static void main(String[] args) {
        Report report = new Report();
        report.generate();
    }
}

class Printer{
    void print(){
        System.out.println("Printing ..... ");
    }
}

class Report{
   Printer printer = new Printer();// tightly coupled
   //Report is directly dependent on printer class, if we want to chamge the printer(PDF printer, etc) we cant change it without chnageing the report class, this makes system rigid and hard to test
   void generate(){
    printer.print();
   }
}
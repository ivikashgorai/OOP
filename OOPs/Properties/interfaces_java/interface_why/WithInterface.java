package interfaces_java.interface_why;

public class WithInterface {
    public static void main(String[] args) {
        Report1 report1 = new Report1(new Printer1());
        Report1 report2 = new Report1(new PdfPrinter1());
        report1.generate();
        report2.generate();
    }
}

interface Printable{
    void print();
}

class Printer1 implements Printable {
    @Override
    public void print() {
       System.out.println("Simple Printing ..... ");
    }
}

class PdfPrinter1 implements Printable{

    @Override
    public void print() {
       System.out.println("Pdf printing .....");
    }
    
}

class Report1 {
    Printable printer;

     Report1(Printable printer){ // not tightly coupled can have any class object which implements Printable, we dont have to change the Report class if printer changed
        this.printer = printer;
     }

     void generate(){
        printer.print();
     }
}
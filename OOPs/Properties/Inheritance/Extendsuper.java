package Inheritance;

public class Extendsuper extends Box {
   double weight;

   public Extendsuper() {
      this.weight = -1;
      this.l = 99;
   }
   public Extendsuper(Extendsuper other){
      super(other);
      this.weight = other.weight; // because child class have all access of parent class like in main file line 15 here refrence other is type extensuper which have acess to parent class box
   }

   public Extendsuper(double l, double h, double w, double weight) {
      super(l, h, w); // this calls the parent class constructor which contain 3 parameter
      this.weight = weight;
   }
}

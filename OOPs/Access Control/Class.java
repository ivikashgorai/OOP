package access_control;

public class Class {
    private int num;
    public String name;
    protected int[] arr;

  public int getNum() { //since the num is private it can't be accessed directly,but num can be accessed any where in this class so we are accessing private variable by calling a public method which can be accessed by anywhere(also applied in set method)
      return num;
  }
  public void setNum(int num) {
      this.num = num;
  }

    public Class(int num, String name) {
        this.num = num;
        this.name = name;
        this.arr = new int[num];
    }
}

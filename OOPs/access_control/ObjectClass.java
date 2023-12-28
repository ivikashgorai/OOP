public class ObjectClass {

    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    public static void main(String[] args) {
        ObjectClass obj = new ObjectClass();
        System.out.println(obj.hashCode());

        System.out.println(obj instanceof ObjectClass); // is obj is related to ObjectClass or not
        System.out.println(obj.getClass().getClassLoader()); // any property of class
    }
}

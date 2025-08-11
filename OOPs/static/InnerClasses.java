public class InnerClasses {

    class Test {
        String name;
        public Test(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        static class Test1 {
        String name;
        public Test1(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        InnerClasses innerClasses = new InnerClasses();
        InnerClasses.Test a = innerClasses.new Test("Vikash"); // inner class object // we need object of outer class as Test class is non static therefore it is dependent on object
        Test1 b = new Test1("Rahul"); // as Test 1 is static we did not need object of outer class

        // System.out.println(a);

       System.out.println(a.name);
       System.out.println(b.name);
    }
}
}

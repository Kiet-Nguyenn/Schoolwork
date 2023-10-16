public class UsingSuper {
    public static void main(String[] args) {
        Super obj = new Sub();
        obj.method1();

        //When calling a method, it will always try to use the dynamic type.
    }
}

class Super{
    public void method1(){
        System.out.println("Calling super method1");
        method2();
    }

    public void method2(){
        System.out.println("Calling super method2");
    }
}

class Sub extends Super{
    public void method1(){
        System.out.println("Calling sub method1");
        super.method1();
    }

    public void method2(){
        System.out.println("Calling sub method2");
    }
}
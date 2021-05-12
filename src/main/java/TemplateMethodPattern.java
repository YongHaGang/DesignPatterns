public class TemplateMethodPattern {
    public static void main(String[] args) {
        Template myClass = new MyClass();
        Template yourClass = new YourClass();

        myClass.operationA();
        myClass.operationB();

        yourClass.operationA();
        yourClass.operationB();
    }
}

abstract class Template {
    void operationA() {
        System.out.println("template operationA");
    }

    void operationB() {
        System.out.println("template operationB");
    }
}

class MyClass extends Template {
    @Override
    void operationA() {
        super.operationA();
        System.out.println("MyClass operationA");
    }
}

class YourClass extends Template {
    @Override
    void operationB() {
        super.operationB();
        System.out.println("YourClass operationB");
    }
}

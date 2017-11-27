package di.test;

import di.configuration.Fibonacci;
import di.configuration.NumberReversal;

public class ClientApplication {

    public static void main(String[] args) {
        /*
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DIConfiguration.class);

        MyApplication app = context.getBean(MyApplication.class);

        app.processMessage("Hi Prashant", "prashanta@abc.com");

        System.out.println(app.getDisplayMsg());

        context.close();
        */
        System.out.println("Reverse of number 123456789 is :"+ NumberReversal.reverseNumber(123456789));
        Fibonacci.getFiboNumber(9);

        System.out.println(NumberReversal.reverseNumDyn(4567));
    }
}

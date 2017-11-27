package di.test;

import di.configuration.DIConfiguration;
import di.consumer.MyApplication;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value="di.consumer")
public class MyApplicationTest {

    private AnnotationConfigApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext(DIConfiguration.class);
    }

    @After
    public void tearDown() throws Exception {
        context.close();
    }

    @Test
    public void test() {
        MyApplication app = context.getBean(MyApplication.class);
        Assert.assertTrue(app.processMessage("Hi Prshant", "prashanta@abc.com"));
    }
}

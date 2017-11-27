package di.configuration;

import org.springframework.stereotype.Component;

@Component
public class Fibonacci {

    static int fiboArr[] = null;

    public static void getFiboNumber(int maxLimit) {
        int init_val = 1;
        int next_val = 1;
        int total_val = 0;
        System.out.println(init_val);
        System.out.println(next_val);

        for(int i=0;i <= maxLimit-3; i++){
            total_val = init_val + next_val;
            System.out.println(total_val);
            init_val = next_val;
            next_val = total_val;
        }
    }
}

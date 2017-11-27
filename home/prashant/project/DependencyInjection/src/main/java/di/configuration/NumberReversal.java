package di.configuration;

import org.springframework.stereotype.Component;

@Component
public class NumberReversal {
    static int reverse = 0;
    static int remainder = 0;

    public static int reverseNumber(int num) {
        int remainder = 0;
        int reverse = 0;
        while(num > 0) {
            remainder = num % 10;
            reverse  = reverse*10 + remainder;
            num = num/10;
        }
        return reverse;
    }
    public static int reverseNumDyn(int num) {
        if ( num > 0 ) {
            remainder = num % 10;
            reverse  = reverse*10 + remainder;
            reverseNumDyn(num/10);
        }
        else
            return reverse;
        return reverse;
    }


    public static void findSumDivisbleBy7() {

    }


}

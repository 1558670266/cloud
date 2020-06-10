package com.example.provider;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProviderApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(100021%100000/10);
    }

    public static void main(String[] args) {




        System.out.println(isPalindrome(10021));
    }
    public static boolean isPalindrome(int x) {
        // String string = x+"";
        // String reverse = new StringBuffer(string).reverse().toString();
        // return string.equals(reverse);
        if(x<0){
            return false;
        }
        int num = 1;
        int tmp = x;
        while(tmp>=10){
            tmp/=10;
            num*=10;
        }
        while(x!=0){
            if(x/num != x%10){
                return false;
            }
            x=x%num/10;
            num/=100;
        }
        return true;
    }

}

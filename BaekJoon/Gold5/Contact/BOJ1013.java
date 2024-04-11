package BaekJoon.Gold5.Contact;

import java.util.Scanner;

public class BOJ1013 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        String str = "(100+1+|01)+";
        for (int i = 0; i < T; i++) {
            String isOk = sc.next();
            if(isOk.matches(str)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

package SWAcademy.D4.괄호짝짓기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    static int len;
    static List<Character> bracket;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            len = sc.nextInt();
            String input = sc.next();
            bracket = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                bracket.add(input.charAt(i));
            }
            int result = compute();
            System.out.println("#" + test_case + " " + result);
        }
    }

    private static int compute() {
        int smallFront = 0;
        int smallBack = 0;
        int midFront = 0;
        int midBack = 0;
        int largeFront = 0;
        int largeBack = 0;
        int leftFront = 0;
        int rightFront = 0;
        for (int i = 0; i < len; i++) {
            switch (bracket.get(i)) {
                case '(':
                    smallFront++;
                    break;
                case ')':
                    smallBack++;
                    break;
                case '{':
                    midFront++;
                    break;
                case '}':
                    midBack++;
                    break;
                case '[':
                    largeFront++;
                    break;
                case ']':
                    largeBack++;
                    break;
                case '<':
                    leftFront++;
                    break;
                case '>':
                    rightFront++;
                    break;
            }
        }

        if (smallFront == smallBack && midFront == midBack && largeFront == largeBack && leftFront == rightFront) {
            return 1;
        }
        return 0;
    }
}
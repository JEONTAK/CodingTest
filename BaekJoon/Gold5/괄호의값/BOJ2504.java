package BaekJoon.Gold5.괄호의값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504 {

    static int result, temp;
    static char[] c;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        c = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        result = 0;
        temp = 1;

        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                stack.push(c[i]);
                temp *= 2;
            } else if (c[i] == '[') {
                stack.push(c[i]);
                temp *=3;
            } else if (c[i] == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if (c[i - 1] == '(') {
                    result += temp;
                }
                stack.pop();
                temp /= 2;
            } else if (c[i] == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (c[i - 1] == '[') {
                    result += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(0);
        }else{
            System.out.println(result);
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ2504.solution();
    }
}

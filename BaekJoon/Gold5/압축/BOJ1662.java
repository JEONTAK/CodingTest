package BaekJoon.Gold5.압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1662 {

    static String S;
    static String[] splitStr;
    static int idx;
    static Stack<String> stack = new Stack<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        splitStr = S.split("");
        System.out.println(compute(0));
    }
    static int compute(int s){
        int len = 0;
        for (int i = s; i < splitStr.length; i++) {
            if (splitStr[i].equals("(")) {
                stack.push(splitStr[i]);
                len += Integer.parseInt(splitStr[i - 1]) * compute(i + 1) - 1;
                i = idx;
            } else if (splitStr[i].equals(")")) {
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    idx = i;
                    stack.pop();
                    return len;
                }
            }else{
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) throws IOException {
        BOJ1662.solution();
    }
}

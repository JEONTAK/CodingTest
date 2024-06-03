package BaekJoon.Gold4.PPAP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ16120 {

    static String str;
    static Stack<Character> stack = new Stack<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (stack.size() >= 4) {
                String s = "";
                for (int j = 0; j < 4; j++) {
                    s = stack.pop() + s;
                }
                if (s.equals("PPAP")) {
                    stack.push('P');
                }else{
                    for (int j = 0; j < 4; j++) {
                        stack.push(s.charAt(j));
                    }
                }
            }
        }
        if (stack.size() == 1 && stack.peek().equals('P')) {
            System.out.println("PPAP");
        }else{
            System.out.println("NP");
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ16120.solution();
    }
}

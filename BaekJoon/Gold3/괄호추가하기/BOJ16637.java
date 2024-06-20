package BaekJoon.Gold3.괄호추가하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ16637 {

    static int N;
    static ArrayList<Character> oper;
    static ArrayList<Integer> num;
    static int result = -Integer.MAX_VALUE;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        oper = new ArrayList<>();
        num = new ArrayList<>();

        String temp = br.readLine();
        for (int i = 0; i < N; i++) {
            char c = temp.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                oper.add(c);
            }else{
                num.add((int) (c - '0'));
            }
        }

        compute(num.get(0), 0);
        System.out.println(result);
    }

    static void compute(int sum, int idx) {
        if (idx >= oper.size()) {
            result = Math.max(result, sum);
            return;
        }
        //괄호 X
        int n1 = calculate(oper.get(idx), sum, num.get(idx + 1));
        compute(n1, idx + 1);

        //괄호 O
        if (idx + 1 < oper.size()) {
            int n2 = calculate(oper.get(idx + 1), num.get(idx + 1), num.get(idx + 2));
            compute(calculate(oper.get(idx), sum, n2), idx + 2);
        }
    }

    static int calculate(char o, int n1, int n2) {
        if (o == '+') {
            return n1 + n2;
        } else if (o == '-') {
            return n1 - n2;
        } else if (o == '*') {
            return n1 * n2;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BOJ16637.solution();
    }
}

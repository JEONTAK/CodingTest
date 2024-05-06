package BaekJoon.Gold5.애너그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class BOJ6443 {

    static int N, len;
    static char[] temp;
    static int[] alphabet;
    static Stack<Character> stack = new Stack<>();
    static Set<String> result;
    static StringBuilder sb = new StringBuilder();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            temp = br.readLine().toCharArray();
            len = temp.length;
            alphabet = new int[26];
            for (char now : temp) {
                alphabet[now - 'a']++;
            }
            result = new TreeSet<>();
            compute(temp,len);
            result.stream().forEach(System.out::println);
        }
    }
    static void compute(char[] s, int idx){
        if (idx == stack.size()) {
            sb = new StringBuilder();
            for (char now : stack) {
                sb.append(now);
            }
            result.add(sb.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > 0) {
                alphabet[i]--;
                stack.push((char) (i + 'a'));
                compute(s, idx);
                stack.pop();
                alphabet[i]++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BOJ6443.solution();
    }
}

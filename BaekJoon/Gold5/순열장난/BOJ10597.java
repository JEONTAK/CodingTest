package BaekJoon.Gold5.순열장난;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10597 {

    static String temp;
    static int N;
    static boolean[] visited;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        temp = br.readLine();
        if (temp.length() > 9) {
            int len = temp.length() - 9;
            N = 9 + len / 2;
        }else{
            N = temp.length();
        }
        visited = new boolean[N + 1];
        compute(0, "");
    }

    static void compute(int idx, String result){
        if (idx == temp.length()) {
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    return;
                }
                System.out.println(result.trim());
                System.exit(0);
            }
            return;
        }

        int one = temp.charAt(idx) - '0';
        if (!visited[one]) {
            visited[one] = true;
            compute(idx + 1, result + " " + one);
            visited[one] = false;
        }
        if (idx < temp.length() - 1) {
            int two = (temp.charAt(idx) - '0') * 10 + (temp.charAt(idx + 1) - '0');
            if (two <= N && !visited[two]) {
                visited[two] = true;
                compute(idx + 2, result + " " + two);
                visited[two] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ10597.solution();
    }
}

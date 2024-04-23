package BaekJoon.Gold5.순열의순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1722 {

    static int N;
    static int [] seq;
    static long[] factorial = new long[21];
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    static long result = 1;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        seq = new int[N + 1];
        visited = new boolean[N + 1];
        factorial[0] = 1;
        for (int i = 1; i <= 20; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        if (num == 1) {
            long k = Long.parseLong(st.nextToken());
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(visited[j]) continue;
                    if (k - factorial[N - 1 - i] > 0) {
                        k -= factorial[N - 1 - i];
                    }else{
                        list.add(j);
                        visited[j] = true;
                        break;
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }else{
            for (int i = 0; i < N; i++) {
                seq[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < seq[i]; j++) {
                    if(!visited[j]){
                        result += factorial[N - 1 - i];
                    }
                }
                visited[seq[i]] = true;
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ1722.solution();
    }
}

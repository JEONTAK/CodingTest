package BaekJoon.Gold4.좋은친구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3078 {

    static int N, K;
    static long result = 0;
    static Queue<Integer>[] q;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        q = new Queue[21];
        for (int i = 0; i < 21; i++) {
            q[i] = new LinkedList<>();
        }

        for (int i = 0; i < N; i++) {
            int len = br.readLine().length();
            if (q[len].isEmpty()) {
                q[len].offer(i);
            }else{
                while (i - q[len].peek() > K) {
                    q[len].poll();
                    if (q[len].isEmpty()) {
                        break;
                    }
                }
                result += q[len].size();
                q[len].offer(i);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ3078.solution();
    }
}

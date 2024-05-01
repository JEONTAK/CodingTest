package BaekJoon.Gold5.풍선맞추기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11509 {
    static int N;
    static int[] balloon;
    static HashMap<Integer, Integer> dart = new HashMap<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        balloon = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            balloon[i] = h;
            dart.put(h, 0);
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (dart.get(balloon[i]) > 0) {
                dart.put(balloon[i], dart.get(balloon[i]) - 1);
            }else{
                result++;
            }
            dart.put(balloon[i] - 1, dart.getOrDefault(balloon[i] - 1, 0) + 1);
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BOJ11509.solution();
    }
}

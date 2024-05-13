package BaekJoon.Gold4.이중우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ7662 {

    static int T, K;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            K = Integer.parseInt(br.readLine());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                String oper = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (oper.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }else if (map.size() == 0) {
                    continue;
                }else{
                    int key = num == 1 ? map.lastKey() : map.firstKey();
                    int cnt = map.get(key);
                    if (cnt == 1) {
                        map.remove(key);
                    }else{
                        map.put(key, cnt - 1);
                    }
                }
            }
            if (map.size() ==0) {
                System.out.println("EMPTY");
            }else{
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ7662.solution();
    }
}

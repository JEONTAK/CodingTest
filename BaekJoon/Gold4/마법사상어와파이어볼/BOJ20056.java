package BaekJoon.Gold4.마법사상어와파이어볼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20056 {

    static class FireBall{
        int x;
        int y;
        int m;
        int s;
        int d;

        public FireBall(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int N, M, K;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static ArrayList<FireBall> list;
    static ArrayList<FireBall>[][] map;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new FireBall(r, c, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            compute(N);
        }

        int result = 0;
        for (FireBall cur : list) {
            result += cur.m;
        }
        System.out.println(result);
    }

    static void compute(int N){
        for (FireBall cur : list) {
            int tR = (cur.x + N + dx[cur.d] * (cur.s % N)) % N;
            int tC = (cur.y + N + dy[cur.d] * (cur.s % N)) % N;
            cur.x = tR;
            cur.y = tC;
            map[cur.x][cur.y].add(cur);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() < 2) {
                    map[i][j].clear();
                    continue;
                }

                int m = 0 , s = 0 , odd = 0, even = 0;
                int size = map[i][j].size();
                for (FireBall cur : map[i][j]) {
                    m += cur.m;
                    s += cur.s;
                    if (cur.d % 2 == 1) {
                        odd++;
                    }else{
                        even++;
                    }
                    list.remove(cur);
                }
                map[i][j].clear();
                m /= 5;
                if (m == 0) {
                    continue;
                }
                s /= size;
                if (odd == size || even == size) {
                    for (int k = 0; k < 8; k += 2) {
                        list.add(new FireBall(i, j, m, s, k));
                    }
                }else{
                    for (int k = 1; k < 8; k += 2) {
                        list.add(new FireBall(i, j, m, s, k));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ20056.solution();
    }
}

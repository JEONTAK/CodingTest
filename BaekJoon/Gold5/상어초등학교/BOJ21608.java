package BaekJoon.Gold5.상어초등학교;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ21608 {

    static class Seat{
        int x;
        int y;
        int friends;
        int empty;

        public Seat(int x, int y, int friends, int empty) {
            this.x = x;
            this.y = y;
            this.friends = friends;
            this.empty = empty;
        }
    }

    static int N;
    static int[][] school;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static HashMap<Integer, int[]> friends = new HashMap<>();
    static int result = 0;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        school = new int [N][N];
        StringTokenizer st;
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int me = Integer.parseInt(st.nextToken());
            int[] fr = new int[4];
            for (int j = 0; j < 4; j++) {
                fr[j] = Integer.parseInt(st.nextToken());
            }
            friends.put(me, fr);
            compute(me);
        }

        getResult();
        System.out.println(result);
    }

    static void getResult() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                int[] fr = friends.get(school[i][j]);

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(!isAvailable(nx,ny)) continue;

                    for (int l = 0; l < 4; l++) {
                        if (school[nx][ny] == fr[l]) {
                            cnt++;
                        }
                    }
                }

                switch (cnt){
                    case 1: result += 1; break;
                    case 2: result += 10; break;
                    case 3: result += 100; break;
                    case 4: result += 1000; break;
                }
            }
        }
    }

    static void compute(int me){
        int [] fr = friends.get(me);
        ArrayList<Seat> seats = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                int friendCnt = 0;
                int emptyCnt = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (!isAvailable(nx, ny)) {
                        continue;
                    }

                    for (int l = 0; l < 4; l++) {
                        if(school[nx][ny] == fr[l]) friendCnt++;
                    }

                    if(school[nx][ny] == 0) emptyCnt++;
                }

                seats.add(new Seat(i, j, friendCnt, emptyCnt));
            }
        }

        seats.sort((s1, s2) -> {
            if (s1.friends == s2.friends) {
                if (s1.empty == s2.empty) {
                    if (s1.x == s2.x) {
                        return s1.y - s2.y;
                    }
                    return s1.x - s2.x;
                }
                return s2.empty - s1.empty;
            }
            return s2.friends - s1.friends;
        });

        for(Seat seat : seats){
            if(school[seat.x][seat.y] != 0) continue;
            school[seat.x][seat.y] = me;
            return;
        }
    }

    static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BOJ21608.solution();
    }
}

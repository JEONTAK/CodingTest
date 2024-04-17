package BaekJoon.Gold5.컨베이어벨트위의로봇;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20055 {

    static int N, K;
    static int[][] belt;
    static int put, get, len;
    static int sumDur = 0;
    static int idx = 1;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[2 * N][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i][0] = Integer.parseInt(st.nextToken());
        }
        put = 0;
        get = N - 1;
        len = 2 * N;

        while(true){
            //1 벨트 한칸 전진
            put--;
            get--;
            if (put == -1) {
                put = len - 1;
            }
            if (get == -1) {
                get = len - 1;
            }

            int i = get;
            //2 가장 먼저 올라간 로봇부터 한칸 이동 가능하면 이동
            while (i != put) {
                if (belt[i][1] == 1) {
                    if (i == get) {
                        belt[i][1] = 0;
                        continue;
                    }
                    int next = (i + 1) % len;
                    if (belt[next][1] == 0 && belt[next][0] != 0) {
                        belt[i][1] = 0;
                        belt[next][0]--;
                        if (next != get) {
                            belt[next][1] = 1;
                        }
                        if (belt[next][0] == 0) {
                            sumDur++;
                        }
                    }
                }
                i--;
                if (i == -1) {
                    i = len - 1;
                }
            }

            //3 내구도가 0 아니면 로봇 올림
            if(belt[put][1] == 0 && belt[put][0] != 0){
                belt[put][1] = 1;
                belt[put][0]--;
                if (belt[put][0] == 0) {
                    sumDur++;
                }
            }
            //4 내구도 0인 칸의 개수 K개 이상 과정 종료
            if(sumDur >= K){
                System.out.println(idx);
                break;
            }
            idx++;
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ20055.solution();
    }
}

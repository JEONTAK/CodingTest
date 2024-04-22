package BaekJoon.Gold5.로봇시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2174 {
    static class Robot{
        int x;
        int y;
        int t;

        public Robot(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    static int A, B, N, M;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean flag = false;
    static Robot[] robots;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[B + 1][A + 1];
        robots = new Robot[N + 1];
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char t = st.nextToken().charAt(0);
            int toward = 0;
            if (t == 'N') {
                toward = 0;
            } else if (t == 'E') {
                toward = 1;
            } else if (t == 'S') {
                toward = 2;
            } else if (t == 'W') {
                toward = 3;
            }
            robots[i] = new Robot(x,y,toward);
            map[y][x] = i;
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            char move = st.nextToken().charAt(0);
            int cnt = Integer.parseInt(st.nextToken());

            compute(idx, move, cnt);
            if (flag) {
                break;
            }
        }
        if (!flag) {
            System.out.println("OK");
        }
    }

    static void compute(int idx, char move, int cnt){
        for (int i = 0; i < cnt; i++) {
            Robot robot = robots[idx];
            if (move == 'R' || move == 'L') {
                int nextT = getT(robot.t,move);
                robots[idx] = new Robot(robot.x, robot.y, nextT);
            } else if (move == 'F') {
                int nX = robot.x + dx[robot.t];
                int nY = robot.y + dy[robot.t];
                if (isAvailable(nX, nY)) {
                    if (map[nY][nX] != 0) {
                        System.out.println("Robot " + idx + " crashes into robot " + map[nY][nX]);
                        flag = true;
                        return;
                    }else{
                        map[robot.y][robot.x] = 0;
                        map[nY][nX] = idx;
                        robots[idx] = new Robot(nX, nY, robot.t);
                    }
                }else{
                    System.out.println("Robot " + idx + " crashes into the wall");
                    flag = true;
                    return;
                }
            }
        }
    }

    static int getT(int t, char move) {
        if (move == 'L') {
            if (t == 0) {
                t = 3;
            }else{
                t--;
            }
        } else if (move == 'R') {
            if (t == 3) {
                t = 0;
            }else{
                t++;
            }
        }
        return t;
    }


    static boolean isAvailable(int x, int y){
        return x >= 1 && x <= A && y >= 1 && y <= B;
    }

    public static void main(String[] args) throws IOException {
        BOJ2174.solution();
    }
}

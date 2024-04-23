package BaekJoon.Gold5.감시피하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18428 {

    static class Location{
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static char[][] map;
    static ArrayList<Location> students = new ArrayList<>();
    static boolean flag = false;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'S') {
                    students.add(new Location(i, j));
                }
            }
        }

        compute(0);

        if (!flag) {
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }

    }

    static void compute(int o){
        if (o == 3) {
            checkAvoid();
            return;
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    compute(o + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    static void checkAvoid(){
        Queue<Location> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        char[][] cMap = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cMap[i][j] = map[i][j];
                if (cMap[i][j] == 'T') {
                    q.add(new Location(i, j));
                    visited[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            Location now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                while (isAvailable(nx, ny)) {
                    if (cMap[nx][ny] != 'O') {
                        visited[nx][ny] = true;
                        nx += dx[i];
                        ny += dy[i];
                    }else{
                        break;
                    }
                }
            }
        }
        if (isCanAvoid(visited)) {
            flag = true;
        }
    }

    static boolean isCanAvoid(boolean[][] visited) {
        for (Location location : students) {
            if (visited[location.x][location.y]) {
                return false;
            }
        }
        return true;
    }

    static boolean isAvailable(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void main(String[] args) throws IOException {
        BOJ18428.solution();
    }
}

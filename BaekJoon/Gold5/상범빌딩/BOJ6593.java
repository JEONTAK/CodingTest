package BaekJoon.Gold5.상범빌딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6593 {

    static class Location{
        int z;
        int y;
        int x;
        int time;

        public Location(int z, int y, int x, int time) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    static int L, R, C;
    static int[][] delta = {{1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {-1, 0, 0}};
    //L : 층수, R : 행, C : 열


    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[][][] building;
        boolean[][][] visited;
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Queue<Location> q;
        while (!canNotTest(L, R, C)) {
            building = new char[L][R][C];
            visited = new boolean[L][R][C];
            q = new LinkedList<>();
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String temp = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = temp.charAt(k);
                        if(building[i][j][k] == 'S'){
                            q.add(new Location(i, j, k, 0));
                            visited[i][j][k] = true;
                        }
                    }
                }
                String trash = br.readLine();
            }
            boolean flag = false;
            int result = 0;
            while (!q.isEmpty()) {
                Location location = q.poll();
                if(building[location.z][location.y][location.x] == 'E'){
                    flag = true;
                    result = location.time;
                    break;
                }
                for (int i = 0; i < 6; i++) {
                    int nz = location.z + delta[i][0];
                    int ny = location.y + delta[i][1];
                    int nx = location.x + delta[i][2];

                    if (isAvailable(nz, ny, nx)) {
                        if(!visited[nz][ny][nx] && building[nz][ny][nx] != '#'){
                            visited[nz][ny][nx] = true;
                            q.add(new Location(nz,ny,nx, location.time + 1));
                        }
                    }
                }
            }

            if (!flag) {
                System.out.println("Trapped!");
            }else{
                System.out.println("Escaped in " + result + " minute(s).");
            }

            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
        }

    }

    static boolean canNotTest(int L, int R, int C) {
        return L == 0 && R == 0 && C == 0;
    }

    static boolean isAvailable(int z, int y, int x) {
        return z >= 0 && z < L && y >= 0 && y < R && x >= 0 && x < C;
    }

    public static void main(String[] args) throws IOException {
        BOJ6593.solution();
    }
}

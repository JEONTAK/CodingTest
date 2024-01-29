package BaekJoon.구슬탈출2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int[][] maze;

    public static Marble R, B;

    public static int holeX, holeY;

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static boolean[][][][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Rx = 0, Ry = 0, Bx = 0, By = 0;
        maze = new int[N][M];
        visited = new boolean[N][M][N][M];
        String str;
        for (int i = 0; i < N; i++) {
            str = sc.next();
            for (int j = 0; j < M; j++) {
                switch (str.charAt(j)) {
                    case '.':
                        maze[i][j] = 0;
                        break;
                    case '#':
                        maze[i][j] = 1;
                        break;
                    case 'O':
                        maze[i][j] = 2;
                        holeX = i;
                        holeY = j;
                        break;
                    case 'R':
                        maze[i][j] = 0;
                        Rx = i;
                        Ry = j;
                        break;
                    case 'B':
                        maze[i][j] = 0;
                        Bx = i;
                        By = j;
                        break;
                }
            }
        }

        R = new Marble(Rx, Ry, 0, 0, 0);
        B = new Marble(0, 0, Bx, By, 0);

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Marble> queue = new LinkedList<>();
        queue.add(new Marble(R.rx, R.ry, B.bx, B.by, 1));
        visited[R.rx][R.ry][B.bx][B.by] = true;

        while (!queue.isEmpty()) {
            Marble marble = queue.poll();
            int curRx = marble.rx;
            int curRy = marble.ry;
            int curBx = marble.bx;
            int curBy = marble.by;
            int curCount = marble.count;

            if (curCount > 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isMeetRedAndHole = false;
                boolean isMeetBlueAndHole = false;

                while (maze[newRx + dx[i]][newRy + dy[i]] != 1) {
                    newRx += dx[i];
                    newRy += dy[i];

                    if (newRx == holeX && newRy == holeY) {
                        isMeetRedAndHole = true;
                        break;
                    }
                }

                while (maze[newBx + dx[i]][newBy + dy[i]] != 1) {
                    newBx += dx[i];
                    newBy += dy[i];

                    if (newBx == holeX && newBy == holeY) {
                        isMeetBlueAndHole = true;
                        break;
                    }
                }

                if (isMeetBlueAndHole) {
                    continue;
                }

                if (isMeetRedAndHole && !isMeetBlueAndHole) {
                    return curCount;
                }

                if (newRx == newBx && newRy == newBy) {
                    if (i == 0) {
                        if (curRx > curBx) {
                            newRx -= dx[i];
                        } else {
                            newBx -= dx[i];
                        }
                    } else if (i == 1) {
                        if (curRy < curBy) {
                            newRy -= dy[i];
                        } else {
                            newBy -= dy[i];
                        }
                    } else if (i == 2) {
                        if (curRx < curBx) {
                            newRx -= dx[i];
                        } else {
                            newBx -= dx[i];
                        }
                    } else {
                        if (curRy > curBy) {
                            newRy -= dy[i];
                        } else {
                            newBy -= dy[i];
                        }
                    }
                }

                if (!visited[newRx][newRy][newBx][newBy]) {
                    visited[newRx][newRy][newBx][newBy] = true;
                    queue.add(new Marble(newRx, newRy, newBx, newBy, curCount + 1));
                }
            }
        }
        return -1;
    }

    static class Marble {
        int rx;
        int ry;
        int bx;
        int by;
        int count;

        public Marble(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }
}

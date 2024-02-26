package BaekJoon.달이차오른다가자;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] maze;
    static int N, M;
    static Node start;

    static class Node{
        int x, y, cost, key;

        public Node(int x, int y, int cost, int key) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.key = key;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String temp;
        N = sc.nextInt();
        M = sc.nextInt();
        maze = new char[N][M];
        for (int i = 0; i < N; i++) {
            temp = sc.next();
            for (int j = 0; j < M; j++) {
                maze[i][j] = temp.charAt(j);
                if(maze[i][j] == '0'){
                    start = new Node(i,j,0,0);
                }
            }
        }
        System.out.println(compute());
    }


    static int compute() {
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][64];
        q.offer(start);
        visited[start.x][start.y][0] = true;

        while(!q.isEmpty()){
            Node current = q.poll();
            if(maze[current.x][current.y] == '1') return current.cost;

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(isInMaze(nextX,nextY)) continue;
                if(visited[nextX][nextY][current.key] || maze[nextX][nextY] == '#')continue;

                if(maze[nextX][nextY] >= 'a' && maze[nextX][nextY] <= 'f'){
                    int next_key = 1 << (maze[nextX][nextY] - 'a');
                    next_key = current.key | next_key;
                    visited[nextX][nextY][next_key] = true;
                    q.offer(new Node(nextX,nextY, current.cost + 1, next_key));
                }
                else if(maze[nextX][nextY] >= 'A' && maze[nextX][nextY] <= 'F'){
                    if((current.key & 1 << (maze[nextX][nextY] - 'A')) == (int)Math.pow(2,maze[nextX][nextY] - 'A')){
                        visited[nextX][nextY][current.key] = true;
                        q.offer(new Node(nextX, nextY, current.cost + 1, current.key));
                    }

                }
                else{
                    visited[nextX][nextY][current.key] = true;
                    q.offer(new Node(nextX, nextY, current.cost + 1, current.key));
                }
            }
        }
        return -1;
    }

    static boolean isInMaze(int x, int y){
        return x < 0 || y < 0 || x >= N || y >= M;
    }
}

package BaekJoon.다리만들기2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Bridge implements Comparable<Bridge>{

        int start;
        int end;
        int length;

        public Bridge(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Bridge o) {
            return this.length - o.length;
        }
    }


    static int N,M;
    static int[][] map;
    static boolean[][] isIsland;
    static int[] parents;
    static int island;

    static Queue<int[]> q;
    static PriorityQueue<Bridge> pq = new PriorityQueue<>(); ;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        isIsland = new boolean[N][M];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                map[i][j] = sc.nextInt();
            }
        }

        countIsland();
        makingBridge();
        compute();

    }

    static void countIsland(){
        island = 2;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 1 && !isIsland[i][j]){
                    islandMaking(j,i,island);
                    island++;
                }
            }
        }
    }

    static void islandMaking(int x, int y, int index){
        q = new LinkedList<>();

        q.add(new int[] {x,y});
        map[y][x] = index;
        isIsland[y][x] = true;

        while(!q.isEmpty()){
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];

            for(int i = 0 ; i < 4 ; i ++){
                int nextX = px + dx[i];
                int nextY = py + dy[i];

                if(nextX < 0 || nextY < 0 || nextX > M - 1 || nextY > N - 1 || isIsland[nextY][nextX]) continue;

                if(map[nextY][nextX] == 1){
                    map[nextY][nextX] = index;
                    isIsland[nextY][nextX] = true;
                    q.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    static void makingBridge(){

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] != 0){
                    makeBridge(j,i,map[i][j]);
                }
            }
        }
    }

    static void makeBridge(int x, int y, int index) {
        q = new LinkedList<>();

        isIsland = new boolean[N][M];
        for(int i = 0 ; i < 4 ; i++){
            q.add(new int[] {x,y,0});
            isIsland[y][x] = true;

            while(!q.isEmpty()){
                int[] p = q.poll();
                int px = p[0];
                int py = p[1];
                int length = p[2];

                int nextX = px + dx[i];
                int nextY = py + dy[i];

                if(nextX < 0 || nextY < 0 || nextX > M - 1 || nextY > N - 1 || isIsland[nextY][nextX]) continue;

                if(map[nextY][nextX] != index){
                    if(map[nextY][nextX] != 0){
                        int start = index - 1;
                        int end = map[nextY][nextX] - 1;
                        if(length > 1){
                            pq.add(new Bridge(start,end, length));
                            break;
                        }
                    }else{
                        isIsland[nextY][nextX] = true;
                        q.add(new int[] {nextX, nextY, length + 1});
                    }
                }
            }
            q.clear();
        }
    }

    static void compute() {
        island--;
        parents = new int[island];
        for(int i = 1 ; i < island ; i++) {
            parents[i] = i;
        }
        int result = findPath();

        if(result == 0){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }

    }

    static int findPath() {
        int sum = 0;
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            Bridge bridge = pq.poll();
            int x = bridge.start;
            int y = bridge.end;

            if(find(x) != find(y)){
                sum += bridge.length;
                union(x,y);
            }
        }

        int rx = parents[1];
        for (int i = 2; i < island; i++) {
            if(rx != find(parents[i])){
                return 0;
            }
        }
        return sum;
    }


    private static int find(int x) {
        if(parents[x] == x) return x;
        int rx = find(parents[x]);
        return rx;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parents[y] = x;
        }else{
            parents[x] = y;
        }
    }

}
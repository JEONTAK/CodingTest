package BaekJoon.Gold1.낚시왕;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static Shark[][] sea;

    static int M;
    static int R;
    static int C;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        M = sc.nextInt();
        int r,c,s,d,z;
        int result = 0;
        sea = new Shark[R][C];
        for(int i = 0 ; i < M ; i++){
            r = sc.nextInt() - 1;
            c = sc.nextInt() - 1;
            s = sc.nextInt();
            d = sc.nextInt();
            z = sc.nextInt();

            if(d == 1) d = 0;
            else if(d == 4) d = 1;
            sea[r][c] = new Shark(r,c,s,d,z);
        }



        for(int col = 0 ; col < C ; col++){
            for(int row = 0 ; row < R ; row++) {
                if (sea[row][col] != null) {
                    result += sea[row][col].z;
                    sea[row][col] = null;
                    break;
                }
            }
            compute();
        }

        System.out.println(result);
    }

    public static void compute(){
        Queue<Shark> queue = new LinkedList<>();
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(sea[i][j] != null){
                    queue.add(new Shark(i,j,sea[i][j].s, sea[i][j].d,sea[i][j].z));
                }
            }
        }

        sea = new Shark[R][C];

        while(!queue.isEmpty()){
            Shark shark = queue.poll();

            int speed = shark.s;
            if(shark.d == 0 || shark.d == 2){
                speed %= (R - 1) * 2;
            }
            else if(shark.d == 1 || shark.d == 3){
                speed %= (C - 1) * 2;
            }

            for(int s = 0 ;s < speed; s++){
                int newR = shark.r + dx[shark.d];
                int newC = shark.c + dy[shark.d];

                if(newR < 0 || newR >= R || newC < 0 || newC >= C){
                    shark.r -= dx[shark.d];
                    shark.c -= dy[shark.d];
                    shark.d = (shark.d + 2 ) % 4;
                    continue;
                }

                shark.r = newR;
                shark.c = newC;
            }

            if(sea[shark.r][shark.c] != null){
                if(sea[shark.r][shark.c].z < shark.z){
                    sea[shark.r][shark.c] = new Shark(shark.r, shark.c, shark.s, shark.d, shark.z);
                }
            }else{
                sea[shark.r][shark.c] = new Shark(shark.r, shark.c, shark.s, shark.d, shark.z);
            }
        }
    }
}

class Shark{
    int r;
    int c;
    int s;//속력
    int d;//방향
    int z;//크기

    public Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }
}

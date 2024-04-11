package BaekJoon.Gold5.톱니바퀴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14891 {

    static int [][] crank;
    static int [] curIdx;
    static int K;
    static int num, toward;
    static int result = 0;
    static boolean visited[];

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        crank = new int[4][8];
        curIdx = new int[4];
        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                crank[i][j] = str.charAt(j) - '0';
            }
            curIdx[i] = 0;
        }

        K = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            visited = new boolean[4];
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            toward = Integer.parseInt(st.nextToken());
            compute(num - 1,toward);
        }
        computeResult();
        System.out.println(result);
    }

    static void compute(int cur, int t){
        visited[cur] = true;
        int left = cur - 1;
        int right = cur + 1;
        int nT = t;

        if (left >= 0 && !visited[left]) {
            if(crank[cur][(curIdx[cur] + 6) % 8] != crank[left][(curIdx[left] + 2) % 8]){
                compute(left, nT == 1 ? -1 : 1);
            }
        }

        if (right < 4 && !visited[right]) {
            if(crank[cur][(curIdx[cur] + 2) % 8] != crank[right][(curIdx[right] + 6) % 8]){
                compute(right, nT == 1 ? -1 : 1);
            }
        }
        //12시 방향
        curIdx[cur] = (curIdx[cur] - t + 8) % 8;
    }

    static void computeResult(){
        for (int i = 0; i < 4; i++) {
            if(crank[i][curIdx[i]] == 1){
                result = (int) (result + Math.pow(2,i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BOJ14891.solution();
    }
}
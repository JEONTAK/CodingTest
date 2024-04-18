package BaekJoon.Gold5.개똥벌레;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3020 {

    static int N, H;
    static int[] top, down;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        top = new int[N / 2];
        down = new int[N / 2];
        for (int i = 0; i < N / 2; i++) {
            int downO = Integer.parseInt(br.readLine());
            int topO = Integer.parseInt(br.readLine());
            down[i] = downO;
            top[i] = topO;
        }

        Arrays.sort(top);
        Arrays.sort(down);
        int min = N;
        int result = 0;

        for (int i = 1; i < H + 1; i++) {
            int obstacle = bSearch(0, N / 2, i, down) + bSearch(0, N / 2, H - i + 1, top);
            if (min == obstacle) {
                result++;
                continue;
            }
            if (min > obstacle) {
                min = obstacle;
                result = 1;
            }
        }
        System.out.println(min + " " + result);
    }

    static int bSearch(int left, int right, int h, int[] obs){
        while(left < right){
            int mid = (left + right) / 2;

            if(obs[mid] >= h){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return obs.length - right;
    }

    public static void main(String[] args) throws IOException {
        BOJ3020.solution();
    }
}

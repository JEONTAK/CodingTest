package BaekJoon.Gold5.색칠1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long W,H,f,c,x1,y1,x2,y2;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Long.parseLong(st.nextToken());
        H = Long.parseLong(st.nextToken());
        f = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        x1 = Long.parseLong(st.nextToken());
        y1 = Long.parseLong(st.nextToken());
        x2 = Long.parseLong(st.nextToken());
        y2 = Long.parseLong(st.nextToken());

        System.out.println(compute());
    }

    static long compute(){
        result += (x2 - x1) * (y2 - y1) * (c + 1);
        if (f <= W / 2) {
            if (f > x1) {
                result += (Math.min(f,x2) - x1) * (y2 - y1) * (c + 1);
            }
        }else{
            if (x1 + f < W) {
                result += (Math.min(W , f + x2) - (f + x1)) * (y2 - y1) * (c + 1);
            }
        }
        result = W * H - result;
        return result;
    }

}

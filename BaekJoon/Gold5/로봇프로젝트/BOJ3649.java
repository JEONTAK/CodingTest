package BaekJoon.Gold5.로봇프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class BOJ3649 {

    static int x, n;
    static int[] l;
    static final int nano = 10_000_000;
    static int maxLen;
    static int max1, max2;
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String temp = br.readLine();
            if (temp == null) {
                break;
            }
            x = Integer.parseInt(temp) * nano;
            n = Integer.parseInt(br.readLine());
            l = new int[n];
            for (int i = 0; i < n; i++) {
                l[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(l);
            int left = 0;
            int right = l.length - 1;
            maxLen = -1;
            compute(left, right);
            if (maxLen == -1) {
                System.out.println("danger");
            }else{
                System.out.println("yes " + l[max1] + " " + l[max2]);
            }
        }
    }
    static void compute(int ptr1, int ptr2){
        while (ptr1 < ptr2) {
            int curLen = l[ptr1] + l[ptr2];
            if (curLen > x) {
                ptr2--;
            } else if (curLen == x) {
                if (maxLen < l[ptr2] - l[ptr1]) {
                    maxLen = l[ptr2] - l[ptr1];
                    max1 = ptr1;
                    max2 = ptr2;
                }
                ptr1++;
                ptr2--;
            }else{
                ptr1++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BOJ3649.solution();
    }
}

package BaekJoon.주사위;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long N;
    static long[] dice = new long[6];
    static long result = 0;
    static long[] count = new long[3];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        count[0] = 5 * (N - 2) * (N - 2) + 4 * (N - 2);
        count[1] = 8 * (N - 2) + 4;
        count[2] = 4;

        if (N == 1) {
            Arrays.sort(dice);
            for (int i = 0; i < 5; i++) {
                result += dice[i];
            }
            System.out.println(result);
        } else {
            long min = dice[0];
            for (int i = 1; i < 6; i++) {
                min = Math.min(min, dice[i]);
            }
            result += count[0] * min;

            min = Long.MAX_VALUE;
            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {
                    if (j + i != 5) {
                        min = Math.min(min, dice[i] + dice[j]);
                    }
                }
            }
            result += count[1] * min;

            long sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += Math.min(dice[i], dice[5 - i]);
            }
            result += count[2] * sum;

            System.out.println(result);
        }
    }

}

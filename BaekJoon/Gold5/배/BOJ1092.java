package BaekJoon.Gold5.배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1092 {

    static List<Integer> crane = new ArrayList<>();
    static List<Integer> box = new ArrayList<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        crane.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        System.out.println(compute());

    }

    static int compute() {
        if (crane.get(0) < box.get(0)) {
            return -1;
        }
        int day = 0;

        while (!box.isEmpty()) {
            int boxIndex = 0, craneIndex = 0;

            while (craneIndex < N) {
                if (boxIndex == box.size()) {
                    break;
                } else if (crane.get(craneIndex) >= box.get(boxIndex)) {
                    box.remove(boxIndex);
                    craneIndex++;
                } else {
                    boxIndex++;
                }
            }

            day++;
        }
        return day;
    }
}

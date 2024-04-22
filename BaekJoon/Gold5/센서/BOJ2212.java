package BaekJoon.Gold5.센서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2212 {

    static class SensorDiff implements Comparable<SensorDiff>{
        int s;
        int e;
        int diff;

        public SensorDiff(int s, int e, int diff) {
            this.s = s;
            this.e = e;
            this.diff = diff;
        }

        @Override
        public int compareTo(SensorDiff o) {
            return o.diff - this.diff;
        }
    }

    static int N, K;
    static int[] sensor;
    static ArrayList<SensorDiff> list = new ArrayList<>();
    static int min = 0;
    static ArrayList<Integer> result = new ArrayList<>();


    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        if (K >= N) {
            System.out.println(0);
        }else{
            StringTokenizer st = new StringTokenizer(br.readLine());
            sensor = new int[N];
            for (int i = 0; i < N; i++) {
                sensor[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(sensor);
            result.add(sensor[0]);
            result.add(sensor[sensor.length - 1]);
            sensor = Arrays.stream(sensor).distinct().toArray();
            for (int i = 1; i < sensor.length; i++) {
                list.add(new SensorDiff(sensor[i - 1], sensor[i], sensor[i] - sensor[i - 1]));
            }
            Collections.sort(list);

            for (int i = 0; i < K - 1; i++) {
                int start = list.get(i).s;
                int end = list.get(i).e;
                result.add(start);
                result.add(end);
            }

            Collections.sort(result);
            for (int i = 0; i < result.size(); i = i + 2) {
                min = min + result.get(i + 1) - result.get(i);
            }
            System.out.println(min);
        }
    }
    public static void main(String[] args) throws IOException {
        BOJ2212.solution();
    }
}

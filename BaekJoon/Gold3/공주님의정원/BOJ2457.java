package BaekJoon.Gold3.공주님의정원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2457 {

    static class Flower implements Comparable<Flower>{
        int start;
        int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            if(this.start < o.start)return -1;
            else if(this.start == o.start){
                if(this.end > o.end)return -1;
                else if(this.end == o.end) return 0;
                else return 1;
            }else return 1;
        }
    }

    static int N;
    static Flower[] flowers;
    static int result = 0;
    static int idx = 0;
    static int max = 0;
    static int startD = 301, finD = 1201;

    private static void solution() throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        flowers = new Flower[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int fm = Integer.parseInt(st.nextToken());
            int fd = Integer.parseInt(st.nextToken());
            int start = sm * 100 + sd;
            int fin = fm * 100 + fd;
            flowers[i] = new Flower(start, fin);
        }

        Arrays.parallelSort(flowers);

        while(startD < finD){
            boolean flag = false;
            for (int i = idx; i < N; i++) {
                if (flowers[i].start > startD) {
                    break;
                }

                if (max < flowers[i].end) {
                    flag = true;
                    max = flowers[i].end;
                    idx = i + 1;
                }
            }

            if (flag) {
                startD = max;
                result++;
            }else break;
        }

        if (max < finD) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        BOJ2457.solution();
    }
}

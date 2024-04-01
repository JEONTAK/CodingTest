package BaekJoon.Gold5.다이어트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int p1 = 1;
        int p2 = 1;

        List<Integer> list = new ArrayList<>();

        while(true){
            int diff = p1 * p1 - p2 * p2;
            if(p1 - p2 == 1 && diff > G){
                break;
            }

            if (diff < G) {
                p1++;
            }
            else{
                p2++;
            }
            if (diff == G) {
                list.add(p1);
            }
        }
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
        else{
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }

}

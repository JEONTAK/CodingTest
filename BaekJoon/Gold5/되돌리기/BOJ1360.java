package BaekJoon.Gold5.되돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1360 {

    static class Node{
        String text;
        long time;

        public Node(String text, long time) {
            this.text = text;
            this.time = time;
        }
    }

    static List<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long time;
        String text;
        long time2;
        list = new ArrayList<>();
        list.add(new Node("", 0));
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("type")) {
                Node preNode = list.get(i - 1);
                text = st.nextToken();
                time = Long.parseLong(st.nextToken());
                list.add(new Node(preNode.text + text, time));
            }else{
                time = Long.parseLong(st.nextToken());
                time2 = Long.parseLong(st.nextToken());
                computeUndo(i, time2-time-1,time2);
            }
        }

        System.out.println(list.get(N).text);
    }

    static void computeUndo(int index, long target, long time) {
        boolean flag = false;
        for (int i = index - 1; i >= 0; i--) {
            if (target < 0) {
                break;
            }
            Node curNode = list.get(i);
            if (curNode.time <= target) {
                list.add(new Node(curNode.text, time));
                flag = true;
                break;
            }
        }
        if (!flag) {
            list.add(new Node("", time));
        }
    }
}

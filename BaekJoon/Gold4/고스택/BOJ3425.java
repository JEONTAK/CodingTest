package BaekJoon.Gold4.고스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ3425 {

    static class Operation{
        String oper;
        int num;

        public Operation(String oper, int num) {
            this.oper = oper;
            this.num = num;
        }
    }

    static ArrayList<Operation> operation = new ArrayList<>();;
    static Deque<Integer> dq = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static final int MAX = (int) Math.pow(10, 9);
    static int N;
    static boolean flag;

    private static void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            operation.clear();
            while(true){
                String[] t = br.readLine().split(" ");
                if (t[0].equals("QUIT")) {
                    System.out.println(sb);
                    return;
                }
                if (t[0].equals("END")) {
                    break;
                }
                if (t.length == 1) {
                    operation.add(new Operation(t[0], 0));
                }else{
                    operation.add(new Operation(t[0], Integer.parseInt(t[1])));
                }
            }

            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                flag = false;
                dq.clear();
                int cur = Integer.parseInt(br.readLine());
                dq.add(cur);

                compute();
                if (flag || dq.size() != 1) {
                    sb.append("ERROR\n");
                }else{
                    sb.append(dq.pop() + "\n");
                }
            }
            sb.append("\n");
            String[] temp = br.readLine().split("");
        }
    }

    static void compute(){
        for (Operation value : operation) {
            String o = value.oper;
            if (o.equals("NUM")) {
                dq.addLast(value.num);
            }
            if (o.equals("POP")) {
                if (dq.isEmpty()) {
                    flag = true;
                    break;
                }
                dq.removeLast();
            }
            if (o.equals("INV")) {
                if (dq.isEmpty()) {
                    flag = true;
                    break;
                }
                int n = dq.pollLast();
                n *= -1;
                dq.addLast(n);
            }
            if(o.equals("DUP")) {
                if(dq.size()==0) {
                    flag=true;
                    break;
                }
                int n = dq.getLast();
                dq.addLast(n);
            }
            if (o.equals("SWP")) {
                if (dq.size() < 2) {
                    flag = true;
                    break;
                }
                int n1 = dq.pollLast();
                int n2 = dq.pollLast();
                dq.addLast(n1);
                dq.addLast(n2);
            }
            if (o.equals("ADD")) {
                if (dq.size() < 2) {
                    flag = true;
                    break;
                }
                long n1 = dq.pollLast();
                long n2 = dq.pollLast();
                long sum = n1 + n2;
                if (sum > MAX || sum < MAX * -1) {
                    flag = true;
                    break;
                }
                dq.addLast((int) sum);
            }
            if (o.equals("SUB")) {
                if (dq.size() < 2) {
                    flag = true;
                    break;
                }
                long n1 = dq.pollLast();
                long n2 = dq.pollLast();
                long sub = n2 - n1;
                if (sub > MAX || sub < MAX * -1) {
                    flag = true;
                    break;
                }
                dq.addLast((int) sub);
            }
            if (o.equals("MUL")) {
                if (dq.size() < 2) {
                    flag = true;
                    break;
                }
                long n1 = dq.pollLast();
                long n2 = dq.pollLast();
                long mul = n1 * n2;
                if (mul > MAX || mul < MAX * -1) {
                    flag = true;
                    break;
                }
                dq.addLast((int) mul);
            }
            if (o.equals("DIV")) {
                if (dq.size() < 2) {
                    flag = true;
                    break;
                }
                long n1 = dq.pollLast();
                long n2 = dq.pollLast();
                if (n1 == 0) {
                    flag = true;
                    break;
                }
                long div = Math.abs(n2) / Math.abs(n1);
                if (n1 * n2 > 0) {
                    dq.addLast((int) div);
                }else{
                    dq.addLast((int) div * -1);
                }
            }
            if (o.equals("MOD")) {
                if (dq.size() < 2) {
                    flag = true;
                    break;
                }
                long n1 = dq.pollLast();
                long n2 = dq.pollLast();
                if (n1 == 0) {
                    flag = true;
                    break;
                }
                long mod = Math.abs(n2) % Math.abs(n1);
                if (n2 < 0) {
                    mod *= -1;
                }
                dq.addLast((int)mod);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BOJ3425.solution();
    }
}
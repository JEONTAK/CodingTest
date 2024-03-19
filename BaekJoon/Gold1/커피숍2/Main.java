package BaekJoon.Gold1.커피숍2;

import java.util.Scanner;

public class Main {

    static int N,Q;
    static long[] numbers;
    static long[] sumOfNumTree;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        Q = sc.nextInt();
        int x, y, a;
        long b, diff;

        numbers = new long[N];
        sumOfNumTree = new long[N * 4];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        initTree(0,N - 1,1);

        for (int i = 0; i < Q; i++) {
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            a = sc.nextInt() - 1;
            b = sc.nextLong();
            diff = b - numbers[a];
            numbers[a] = b;

            if (x <= y) {
                System.out.println(computeSum(0, N - 1, 1, x, y));
            }else{
                System.out.println(computeSum(0, N - 1, 1, y, x));
            }

            updateSum(0, N - 1, 1, a, diff);
        }
    }

    static long initTree(int start, int end, int node){
        if (start == end) {
            return sumOfNumTree[node] = numbers[start];
        }

        int mid = (start + end) / 2;

        return sumOfNumTree[node] = initTree(start, mid, node * 2) + initTree(mid + 1, end, node * 2 + 1);
    }

    static long computeSum(int start, int end, int node, int left, int right) {
        if(start > right || end < left){
            return 0;
        }
        if (left <= start && end <= right) {
            return sumOfNumTree[node];
        }

        int mid = (start + end) / 2;

        return computeSum(start, mid, node * 2, left, right) + computeSum(mid + 1, end, node * 2 + 1, left, right);
    }

    static void updateSum(int start, int end, int node, int index, long diff){
        if (index < start || index > end) {
            return;
        }

        sumOfNumTree[node] += diff;

        if(start == end)
            return;
        int mid = (start + end ) / 2;

        updateSum(start, mid, node * 2, index, diff);
        updateSum(mid + 1, end, node * 2 + 1, index, diff);
    }



}

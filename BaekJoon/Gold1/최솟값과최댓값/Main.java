package BaekJoon.Gold1.최솟값과최댓값;

import java.util.Scanner;

public class Main {

    public static long[] list;

    public static long[] minList;
    public static long[] maxList;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int a = 0;
        int b = 0;
        list = new long[N];
        minList = new long[4 * N];
        maxList = new long[4 * N];

        for(int i = 0 ; i < 4 * N ; i++){
            minList[i] = Long.MAX_VALUE;
        }

        for(int i = 0 ; i < N ; i++){
            list[i] = sc.nextLong();
        }

        computeMinTree(0 , N - 1, 1);
        computeMaxTree(0, N - 1, 1);

        for(int i = 0 ; i < M ; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            System.out.println(computeMin(0, N - 1, 1, a - 1, b - 1) + " " + computeMax(0, N - 1, 1, a - 1, b - 1));
        }

    }

    public static long computeMinTree(int start, int end, int node){
        if(start == end){
            return minList[node] = list[start];
        }
        int mid = (start + end) / 2;
        return minList[node] = Math.min(computeMinTree(start, mid,node * 2), computeMinTree(mid + 1, end,node * 2 + 1));
    }

    public static long computeMaxTree(int start, int end, int node){
        if(start == end){
            return maxList[node] = list[start];
        }
        int mid = (start + end) / 2;
        return maxList[node] = Math.max(computeMaxTree(start, mid,node * 2), computeMaxTree(mid + 1, end,node * 2 + 1));
    }

    public static long computeMin(int start, int end, int node, int left, int right){
        if(left > end || right < start){
            return Long.MAX_VALUE;
        }
        if(left <= start && end <= right){
            return minList[node];
        }
        int mid = (start + end) / 2;
        return Math.min(computeMin(start, mid, node * 2, left, right), computeMin(mid + 1, end, node * 2 + 1, left, right));
    }

    public static long computeMax(int start, int end, int node, int left, int right){
        if(left > end || right < start){
            return Long.MIN_VALUE;
        }
        if(left <= start && end <= right){
            return maxList[node];
        }
        int mid = (start + end) / 2;
        return Math.max(computeMax(start, mid, node * 2, left, right), computeMax(mid + 1, end, node * 2 + 1, left, right));
    }
}

package SWAcademy.D4.하나로;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


class Solution {

    static int island;
    static int[][] islandLocation;
    static double[][] cost;
    static boolean[] visited;
    static ArrayList<Node>[] list;


    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            island = sc.nextInt();
            islandLocation = new int[island][2];
            cost = new double[island][island];
            visited = new boolean[island];
            list = new ArrayList[island];
            for (int i = 0; i < island; i++) {
                islandLocation[i][0] = sc.nextInt();
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < island; i++) {
                islandLocation[i][1] = sc.nextInt();
            }
            double e = sc.nextDouble();

            for (int i = 0; i < island; i++) {
                for (int j = 0; j < island; j++) {
                    double cost = e * (Math.pow(islandLocation[i][0] - islandLocation[j][0], 2) + Math.pow(
                            islandLocation[i][1] - islandLocation[j][1], 2));
                    list[i].add(new Node(i, j, cost));
                }
            }
            double result = compute();
            System.out.println("#" + test_case + " " + Math.round(result));
        }
    }

    private static double compute() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        double result = 0;
        queue.add(0);

        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            visited[curNode] = true;
            for (Node node : list[curNode]) {
                if (!visited[node.end]) {
                    priorityQueue.add(node);
                }
            }

            while (!priorityQueue.isEmpty()) {
                Node node = priorityQueue.poll();
                if (!visited[node.end]) {
                    queue.add(node.end);
                    visited[node.end] = true;
                    result += node.value;
                    break;
                }
            }
        }
        return result;
    }

    static class Node implements Comparable<Node> {
        int start;
        int end;
        double value;

        public Node(int start, int end, double value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.value, o.value);
        }
    }
}
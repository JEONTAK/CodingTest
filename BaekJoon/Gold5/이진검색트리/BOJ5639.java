package BaekJoon.Gold5.이진검색트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5639 {

    static class Node{
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        void insert(int val) {
            if (val < this.value) {
                if (this.left == null) {
                    this.left = new Node(val);
                }else{
                    this.left.insert(val);
                }
            }else{
                if (this.right == null) {
                    this.right = new Node(val);
                }else{
                    this.right.insert(val);
                }
            }
        }
    }
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String str = br.readLine();
            if (str == null || str.equals("")) {
                break;
            }
            int value = Integer.parseInt(str);
            root.insert(value);
        }

        postOrder(root);
    }

    static void postOrder(Node curNode){
        if(curNode == null) return;

        postOrder(curNode.left);
        postOrder(curNode.right);
        System.out.println(curNode.value);
    }

    public static void main(String[] args) throws IOException {
        BOJ5639.solution();
    }
}

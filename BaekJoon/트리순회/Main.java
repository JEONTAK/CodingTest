package BaekJoon.트리순회;

import java.util.Scanner;

//Inorder : left -> root -> right
//Postorder : left -> right -> root
//Preorder : root -> left -> right
public class Main {

    static int[] inOrder;
    static int[] postOrder;
    static int[] preOrder;
    static int index = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        inOrder = new int[n];
        postOrder = new int[n];
        preOrder = new int[n];

        for(int i = 0 ; i < n ; i ++){
            inOrder[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n ; i ++){
            postOrder[i] = sc.nextInt();
        }

        makePreOrder(0, n - 1, 0 , n - 1);

        for (int i : preOrder) {
            System.out.print(i + " ");
        }
    }

    public static void makePreOrder(int inStart, int inEnd, int postStart, int postEnd){
        if(inStart <= inEnd && postStart <= postEnd){
            preOrder[index] = postOrder[postEnd];
            index++;

            int pos = inStart;
            for(int i = inStart; i <= inEnd ; i++){
                if(inOrder[i] == postOrder[postEnd]){
                    pos = i;
                    break;
                }
            }

            makePreOrder(inStart,pos - 1, postStart, postStart + pos - inStart - 1);
            makePreOrder(pos + 1 , inEnd , postStart + pos - inStart, postEnd - 1);
        }
    }
}

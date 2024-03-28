package BaekJoon.Gold5.다음팰린드롬수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static int[] digit;
    static String temp;
    static StringBuilder sb = new StringBuilder();
    static BigInteger N, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        temp = st.nextToken();
        N = new BigInteger(temp);
        digit = new int[temp.length()];
        for (int i = 0; i < digit.length; i++) {
            digit[i] = Integer.parseInt(String.valueOf(temp.charAt(i) - '0'));
        }
        if(isOnlyNine())
        {
            System.out.println(makeNumber());
        }
        else{
            if (digit.length % 2 == 1) {
                int mid = (digit.length - 1) / 2;
                int index = mid - 1;
                makingDecal(mid, index);
                while(true){
                    result = BigInteger.valueOf(0);
                    result = makeNumber();
                    if(result.compareTo(N) > 0){
                        System.out.println(makeNumber());
                        break;
                    }
                    digit[mid]++;
                    if (digit[mid] == 10) {
                        digit[mid] = 0;
                        digitUp(mid);
                        makingDecal(mid, index);
                    }
                }
            }
            else{
                int mid = digit.length / 2 - 1;
                int index = mid;
                makingDecal(mid, index);
                while(true){
                    result = BigInteger.valueOf(0);
                    result = makeNumber();
                    if(result.compareTo(N) > 0){
                        System.out.println(makeNumber());
                        break;
                    }
                    digit[mid]++;
                    digit[mid + 1] ++;
                    if (digit[mid] == 10) {
                        digit[mid] = 0;
                        digit[mid + 1] = 0;
                        digitUp(mid);
                        makingDecal(mid, index);
                    }
                }
            }
        }
    }

    static boolean isOnlyNine(){
        for(int i = 0 ; i < digit.length ; i++){
            if(digit[i] != 9){
                return false;
            }
        }
        int len = digit.length;
        digit = new int[len + 1];
        digit[0] = 1;
        digit[len] = 1;
        for(int i = 1; i < len ; i++){
            digit[i] = 0;
        }
        return true;
    }

    static void digitUp(int index){
        digit[index - 1]++;
        if(digit[index - 1] ==10){
            digit[index - 1] = 0;
            digitUp(index - 1);
        }

    }

    static void makingDecal(int mid, int index){
        for(int i = mid + 1 ; i < digit.length; i++){
            digit[i] = digit[index];
            index--;
        }
    }

    static BigInteger makeNumber(){
        for (int i = 0; i < digit.length; i++) {
            sb.append(digit[i]);
        }
        BigInteger temp = new BigInteger(String.valueOf(sb));
        sb.delete(0, digit.length);
        return temp;
    }
}


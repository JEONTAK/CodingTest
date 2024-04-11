package BaekJoon.Gold1.멀티탭스케줄링;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1700 {

    static int[] E;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N,K;
        N = sc.nextInt();
        K = sc.nextInt();
        E = new int[K];
        for(int i = 0 ; i < K ; i++){
            E[i] = sc.nextInt();
        }

        boolean[] use = new boolean[K + 1];
        int multiTab = 0;
        int cnt = 0;

        for(int i = 0 ; i < K ; i ++){
            //전기제품이 꽂혀있지 않은 경우
            if(!use[E[i]]){
                //멀티탭에 자리가 있을 경우
                if(multiTab < N){
                    use[E[i]] = true;
                    multiTab++;
                }//멀티탭에 자리가 없을 경우
                else{
                    //현재 꽂혀 있는 전기 제품이 나중에도 사용되는지 확인
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for(int j = i ; j < K ; j++){
                        if(use[E[j]] && !arrayList.contains(E[j])){
                            arrayList.add(E[j]);
                        }
                    }
                    //만약 나중에도 사용될 전기제품이 구멍의 개수보다 적을 경우
                    if(arrayList.size() != N){
                        for(int j = 0 ; j < use.length ; j++){
                            //콘센트 제거
                            if(use[j] && !arrayList.contains(j)){
                                use[j] = false;
                                break;
                            }
                        }
                    }//현재 꽂혀 있는 모든 전기제품이 나중에도 사용될 경우
                    else{
                        int remove = arrayList.get(arrayList.size() - 1);
                        use[remove] = false;
                    }

                    use[E[i]] = true;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}

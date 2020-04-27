package 배열2.형성평가01;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        int [] score = new int[10];
//        int [] result = new int[6];
        Scanner sc = new Scanner(System.in);
//
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

        for(int i = 1; i <= 6; i++){
            treeMap.put(i, 0);
        }

        for (int i = 0; i < score.length; i++ ){
            score[i] = sc.nextInt();

            Integer j = treeMap.get(score[i]);

            if(j == 0){
                treeMap.put(score[i] , 1);
            } else {
                treeMap.put(score[i] , 1 + j);
            }

        }

        for(Map.Entry<Integer, Integer> e : treeMap.entrySet()){
            System.out.println(e.getKey() + " : " + e.getValue());
        }

//        for(int i = 0; i < 10; i++){
//            int score = sc.nextInt() - 1;
//            result[score]++;
//        }
//
//        for(int i = 0; i < result.length; i++ ){
//            System.out.println((i+1) + " : " + result[i]);
//        }

    } // end main()
} // end class

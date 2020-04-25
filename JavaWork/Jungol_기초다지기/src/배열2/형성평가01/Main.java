package 배열2.형성평가01;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        int [] score = new int[10];

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < score.length; i++ ){
            score[i] = sc.nextInt();

            Integer j = treeMap.get(score[i]);

            if(j == null){
                treeMap.put(score[i] , 1);
            } else {
                treeMap.put(score[i] , 1 + j);
            }

        }

        for(Map.Entry<Integer, Integer> e : treeMap.entrySet()){

        }






    }
}

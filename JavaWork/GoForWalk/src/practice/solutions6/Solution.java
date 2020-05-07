package practice.solutions6;

import java.util.HashMap;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        HashMap<Integer, Integer> arrStudent = new HashMap<Integer, Integer>();

        for(int i = 0; i < n; i++){
            int cloths = 1;

            for(int j = 0; j < lost.length; j++){
                if(i+1 == lost[j]) cloths--;
            }


            for(int j = 0; j <reserve.length; j++){

            }

            arrStudent.put(i+1, cloths);
        }




        return answer;
    }

}

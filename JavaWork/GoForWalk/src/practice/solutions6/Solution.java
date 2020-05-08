package practice.solutions6;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] lost = {1,2};
        int [] reserve = {2,3};
        System.out.println(s.solution(5, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        HashMap<Integer, Integer> arrStudent = new HashMap<Integer, Integer>();

        for(int i = 0; i < n; i++){
            int cloths = 1;

            for(int j = 0; j < lost.length; j++){
                if(i+1 == lost[j]){
                    cloths--;
                    break;
                }
            }

            for(int j = 0; j <reserve.length; j++){
                if(i+1 == reserve[j]){
                    cloths++;
                    break;
                }
            }

            arrStudent.put(i+1, cloths);
        }

        for(int i = 1; i <= arrStudent.size(); i++){

            if(arrStudent.get(i) == 0 && i < arrStudent.size() && arrStudent.get(i+1) == 2){
                arrStudent.put(i, 1);
                arrStudent.put(i+1, 1);
            }

            if(arrStudent.get(i) == 0 && i > 1 && arrStudent.get(i-1) == 2){
                arrStudent.put(i, 1);
                arrStudent.put(i - 1, 1);
            }

            if(arrStudent.get(i) == 0) arrStudent.remove(i);
        }
        answer = arrStudent.size();
        return answer;
    }

}

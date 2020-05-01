package practice;



public class Programmers_2 {
    public static void main(String[] args) {

        Solution s = new Solution();


        s.solution(3);


    }


    static  class Solution {
        public int[] solution(int n) {

            int arrLengthAsr = (int) Math.pow(2, n) - 1;

            int[] answer = new int[arrLengthAsr];

            if (n > 1) {

                int[] arrSolution = solution(n - 1);
                int nextArrLength = (arrSolution.length * 2) + 1;

                for(int j = 0; j < arrSolution.length; j++){
                    answer[j] = arrSolution[j];
//                    answer[j] = arrSolution[j];
                    answer[nextArrLength - 1 - j] = (arrSolution[j] - 1) * - 1;
                }
            }
            return answer;
        }
    }

}


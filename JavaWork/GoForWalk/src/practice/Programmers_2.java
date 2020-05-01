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

                int temp = n - 1;

                for (int i = 1; i <= temp; i++) {

//                    int middlePoint = (int) (Math.pow(2, i + 1)) / 2;
                    int arrLength = (int) Math.pow(2, i) - 1;
                    int nextArrLength = (int)Math.pow(2, i + 1) - 1;

                    int[] arrSolution = new int[arrLength];

                    for(int j = 0; j < arrLength; j++){
                        arrSolution[j] = answer[j];
                        answer[j] = arrSolution[j];
                        answer[nextArrLength - 1 - j] = (arrSolution[j] - 1) * - 1;
                    }

//                    for (int j = 0; j > arrLength; j++) {
//                    }

                }
            }
            return answer;
        }
    }

}


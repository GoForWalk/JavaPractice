package practice.solutions5;

public class Solution {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++){
            int startNum = commands[i][0] - 1;
            int endNum = commands[i][1];
            int selectNum = commands[i][2] - 1;
            int[] arrSelect = new int[endNum - startNum];

            for(int k = startNum; k < endNum; k++){
                arrSelect[k-startNum] = array[k];
                }

            for(int j = 0; j < arrSelect.length; j++){
                for(int k = 0; k < arrSelect.length-1; k++){
                    if(arrSelect[k] > arrSelect[k + 1]){
                        int temp = arrSelect[k];
                        arrSelect[k] = arrSelect[k+1];
                        arrSelect[k+1] = temp;
                    }
                }
            }

            answer[i] = arrSelect[selectNum];
        }
        return answer;
    }
}

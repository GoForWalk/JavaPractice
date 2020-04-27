package practice;


import java.util.ArrayList;

public class Programmers_1 {
    public static void main(String[] args) {

        int [][] board = {  {0, 0, 0, 0, 0},
                            {0, 0, 1, 0, 3},
                            {0, 2, 5, 0, 1},
                            {4, 2, 4, 4, 2},
                            {3, 5, 1, 3, 1} };

        int [] moves =  {1, 5, 3, 5, 1, 2, 1, 4};
        Solution s = new Solution();

        System.out.println(s.solution(board,moves));


    }
}

class Solution {
    public int solution(int[][] board, int[] moves) {

        int answer = 0;
        boolean hasSame = true;
        ArrayList<Integer> box = new ArrayList<Integer>();

        for(int k = 0; k < moves.length; k++) {

            int j = moves[k] - 1 ;

            for (int i = 0; i < board.length; i++) {

                if (board[i][j] != 0) {
                    box.add(board[i][j]);
                    board[i][j] = 0;

                    break;
                }
            }





        }

        while (hasSame) {

            for (int i = 0; i < box.size(); i++) {

                if (box.get(i) == box.get(i - 1)) {
                    answer += 2;
                    box.remove(i - 1);
                    box.remove(i);
                    hasSame = true;
                    break;
                }
                hasSame = false;
            }

        }
        return answer;

    } // end solution()

}// end Solution
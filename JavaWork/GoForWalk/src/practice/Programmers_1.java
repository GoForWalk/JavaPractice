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

//class Solution {
//    public int solution(int[][] board, int[] moves) {
//
//        int answer = 0;
//        boolean hasSame = true;
//        ArrayList<Integer> box = new ArrayList<Integer>();
//
//        for(int k = 0; k < moves.length; k++) {
//
//            int j = moves[k] - 1 ;
//
//            for (int i = 0; i < board.length; i++) {
//
//                if (board[i][j] != 0) {
//                    box.add(board[i][j]);
//                    board[i][j] = 0;
//
//                    break;
//                }
//            }
//
//
//
//
//
//        }
//
//        while (hasSame) {
//
//            for (int i = 0; i < box.size(); i++) {
//
//                if (box.get(i) == box.get(i - 1)) {
//                    answer += 2;
//                    box.remove(i - 1);
//                    box.remove(i);
//                    hasSame = true;
//                    break;
//                }
//                hasSame = false;
//            }
//
//        }
//        return answer;
//
//    } // end solution()

//}// end Solution

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] basket = new int[moves.length];
        int c = 0;

        for (int a = 0; a < moves.length; a++){ // 크레인이 움직인 횟수만큼 시행

            for (int i = 0; i < board[moves[a] - 1].length; i++){ // 크레인이 집을 인형이 있는 라인의 맨 윗칸부터 인형찾기

                if (board[i][moves[a] - 1] != 0){

                    for (int b = 0; b < basket.length; b++){

                        if (basket[b] == 0){
                            basket[b] = board[i][moves[a] - 1];
                            board[i][moves[a] - 1] = 0;
                            c = b;
                            break;
                        } else {
                            continue;
                        }
                    }//end for

                    if (c > 0 && basket[c] == basket[c - 1]){
                        answer += 2;
                        basket[c] = 0;
                        basket[c - 1] = 0;
                    }
                }
            }
        }
        return answer;
    }
}
package practice;



public class Programmers_2 {
    public static void main(String[] args) {

    }


    class Solution {
        public int[] solution(int n) {

            int arrLength = (int)Math.pow(2,n) - 1;

//            int middle = (int)Math.pow(2, n)/2 ;

            int[] arrInt = new int[arrLength];


//            for(int i = middle - 1; i > 0 ; i-- ){
//
//            }

            for(int i = 0; i < n; i++){

                int middle = (int)Math.pow(2, i)/2 ;
                int [] arrInt_priv = new int[(int)Math.pow(2,i)];


                arrInt_priv[middle] = 0;

                for(int j = middle; j > 0; j--){



                }

            }











            int[] answer = {};
            return answer;
        }
    }
}


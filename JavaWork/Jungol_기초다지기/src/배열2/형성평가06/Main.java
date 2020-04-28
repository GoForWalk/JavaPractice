package 배열2.형성평가06;

/*
예제를 보고 적당한 배열을 선언한 후
1행의 1열과 3열 5열을 각각 1로 초기화하고 나머지는 모두 0으로 초기화 한 후
2행부터는 바로 위행의 왼쪽과 오른쪽의 값을 더하여 채운 후 출력하는 프로그램을 작성하시오.

 */

public class Main {
    public static void main(String[] args) {

        int [][] intArr = new int[5][5];

        for(int i = 0; i < intArr.length; i++){

            for(int j = 0; j < 5; j ++){

                if(i == 0){
                    if(j == 0) intArr[i][j] = 1;


                } else if(i % 2 == 0) {
                    if (j % 2 == 0){
                        intArr[i][j] = 0;
                    }


                } else {
                    if(j % 2 != 0){
                        intArr[i][j] = intArr[i-1][j-1] + intArr[i-1][j+1];
                    }





                }

            }



        }


    }
}

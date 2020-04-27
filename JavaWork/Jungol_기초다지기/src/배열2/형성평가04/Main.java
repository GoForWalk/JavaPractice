package 배열2.형성평가04;

public class Main {
    public static void main(String[] args) {

        int [][] arrInt = {{3, 5, 9}, {2, 11, 5}, {8, 30, 10}, {22, 5, 1}};
        int sum = 0;
        int sumResult = 0;

        for(int i = 0; i < arrInt.length; i ++){
            for(int j = 0; j < arrInt[i].length; j++){
                System.out.print(arrInt[i][j] + " ");
                sum += arrInt[i][j];
            }

            System.out.println();
        }
        System.out.println(sum);
    }

}

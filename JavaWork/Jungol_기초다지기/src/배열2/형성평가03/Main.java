package 배열2.형성평가03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] intArr = new int[10];

        int temp;

        intArr[0] = sc.nextInt();
        intArr[1] = sc.nextInt();

        for (int i = 2; i < intArr.length; i++){
            temp = intArr[i - 2] + intArr[i - 1];

            if(temp > 9) intArr[i] = temp % 10;
            else intArr[i] = temp;

        }

        for (int t : intArr){
            System.out.print(t + " ");
        }

    }

}

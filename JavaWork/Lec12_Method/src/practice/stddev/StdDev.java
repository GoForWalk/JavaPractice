package practice.stddev;

import java.util.Arrays;
import java.util.Random;

public class StdDev {

	public static void main(String[] args) {

		// TODO
		// 임의정수 5개로 초기화한 정수로
		// 평균, 분산, 표준편차 구하기
		Random r = new Random();
		int[] inputArr = new int[5];
		
		
		for (int i = 0; i < inputArr.length; i++) {
			inputArr[i] = r.nextInt(100) + 1;
			
		}
		System.out.println(Arrays.toString(inputArr));
		
		System.out.println("평균: " + String.format("%.1f", calcAvg(inputArr)));
		System.out.println("분산: " + String.format("%.2f", calcVariance(inputArr)));
		System.out.println("표준편차: " + calcStdDev(inputArr));

	} // end main
	
	/**
	 * 메소드 이름 : calcAvg
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */
	public static double calcAvg(int[] inputArr) {
		
		int total = 0;
		for (int i = 0; i < inputArr.length; i++) {
			total += inputArr[i];
		}
		double avg = (double)total / inputArr.length;
		return avg;
	}
	
	
	/**
	 * 메소드 이름 : calcVariance
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 */
	public static double calcVariance(int[] inputArr) {
		double[] deviationArr = new double[5];
		double devitionDoubleTotal = 0.0;
		double variance = 0.0;
		
		for (int i = 0; i < inputArr.length; i++) {
			deviationArr[i] = Math.pow(inputArr[i] - calcAvg(inputArr), 2);
			devitionDoubleTotal += deviationArr[i];
		}
		variance = devitionDoubleTotal / inputArr.length;
		return variance;
	}
	
	/**
	 * 메소드 이름 : calcStdDev
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */
	public static double calcStdDev(int[] inputArr) {
		double stdDev = 0.0;
		stdDev = Math.pow(calcVariance(inputArr), 0.5);
		
		return stdDev;
		
	}

} // end class

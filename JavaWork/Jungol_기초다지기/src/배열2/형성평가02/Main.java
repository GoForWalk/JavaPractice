package 배열2.형성평가02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> score = new ArrayList<Integer>();
		
		for(;;) {
			Integer j = sc.nextInt();
			score.add(j/10);
			if(j == 0) break;
		}
	
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
				
		for (int i = 0; i < score.size(); i++) {
			
				Integer j = hmap.get(score.get(i));
				
				if(j == null) hmap.put(score.get(i), 1);
				else hmap.put(score.get(i), j+1);
			
		}
		
		TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>(Collections.reverseOrder());
		tmap.putAll(hmap);
		for (Map.Entry<Integer, Integer> e : tmap.entrySet()) {
//			if(e.getValue() == 0)continue;
			System.out.println(e.getKey()*(10) + " : " + e.getValue() + " person");
		}
		
	}

}

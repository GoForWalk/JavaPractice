package practice.wordcount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
 * 	- 대소문자 구분하지 않기 :   The 와 the 는 같은 단어
 *  - 2글자 이상만 계수하기
 *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 *  - 공백 짤라내기
 * ex)
 * 	an : 234
 * 	the : 314
 * ...
 * 
 * hint]
 * 	split("\\s+")  --> String[]   
 * 	--> StringTokenizer  (혹은 정규표현식)
 *  	  --> HashMap<String, Integer>   <단어, 빈도수>  사용
 * ───────────────────────────────────────────────────────────    
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 * 	ex)
 *	1 the:113개
 *	2 she:95개
 *	3 to:85개
 *	...   
 *
 * hint]
 * 	Comparable<> 이나 Comparator<> 적용
 */

// TODO : 필요한 객체들 작성
// hint> 빈도수 담을 객체, Comparator<> ..

public class AliceInWonderland {

	public static void main(String[] args) {
		System.out.println("실습: 단어 발생 빈도");
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();

		String[] words = C.ALICE30.trim().toLowerCase().split("\\s+");
//		
//		// 발생빈도 작성
		String token;
		StringTokenizer tokenizer;

		for (int i = 0; i < words.length; i++) { // spilt 해준 배열의 배열마다 tokenizer 처리를 해준다.
			tokenizer = new StringTokenizer(words[i], "_,.\"\'`!?;:-() ", false);

			while (tokenizer.hasMoreTokens()) { // 배열 칸의 단어의 tokenizer 한 결과물을
				token = tokenizer.nextToken(); // token 에 담는다.

				if (token.length() > 1) { // token의 문자열 길이가 1이 넘지 않으면, 맵에 저장

					Integer k = hmap.get(token);
					if (k == null) {

						hmap.put(token, 1); // key 값에 대한 value가 비어있으면 token 값을 키에 저장하고, value를 1로 설정
					} else {
						hmap.put(token, k + 1); // key에 대한 value 가 null 이 아닌 값이면 k + 1

					}

				}
			}
		}

		// 결과 출력
//		for(Map.Entry<String, Integer> e : hmap.entrySet()) {
//			System.out.println(e.getKey() + " : " + e.getValue() + "개");
//		}
		// 순서대로 출력이 안된다!! -> 정렬할 수 있는 TreeMap 전환 필요
		// Comparator 사용

//		TreeMap<String, Integer> tmap	= new TreeMap<String, Integer>(hmap);
//		
//		System.out.println(tmap);
		// a,b,c 순

		List<WordCount> wordlist = new ArrayList<WordCount>();

		for (Map.Entry<String, Integer> e : hmap.entrySet()) {
			wordlist.add(new WordCount(e.getKey(), e.getValue()));
		}

		Collections.sort(wordlist, new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				if (o1.getCount() > o2.getCount())
					return -1;
				else if (o1.getCount() < o2.getCount())
					return 1;
				return 0;
			}
		});

		for (WordCount w : wordlist) {
//			System.out.println(w.getWord() + "\t\t: " + w.getCount() + "개");
			System.out.printf("%15s	: %3d개\n", w.getWord(), w.getCount());
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

class WordCount {
	String word;
	int count;

	public WordCount(String word, int count) {
		super();
		this.word = word;
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public int getCount() {
		return count;
	}

}

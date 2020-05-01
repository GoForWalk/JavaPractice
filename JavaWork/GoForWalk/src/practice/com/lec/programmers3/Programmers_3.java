package practice.com.lec.programmers3;

import java.util.HashMap;
import java.util.Map;

public class Programmers_3 {
    public static void main(String[] args) {

    }
}

class Solution{
    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> mapString = new HashMap<String, Integer>();
        String answer = "";

        for(int i = 0; i < participant.length; i++){
            Integer check = mapString.get(participant[i]);

            if(check == null){
                mapString.put(participant[i], 1);
            } else if (check > 0){
                mapString.put(participant[i], 1 + check);
            }
        }

        for (int i = 0; i < completion.length; i++){
            Integer check = mapString.get(completion[i]);

            if(check == 1){
                mapString.remove(completion[i]);
            } else {
                mapString.put(completion[i], check - 1);
            }
        }

        for (Map.Entry<String,Integer> e : mapString.entrySet()){
            answer += e.getKey() + "";
        }

        return answer;
    }
}

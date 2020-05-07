package practice.soultion4;

import java.util.*;

public class Solution {
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int [] answers = {1,2,3,4,5};
//        System.out.println(s.solution(answers));
//    }


    public int[] solution(int[] answers) {

        int [] stu1 = {1,2,3,4,5};
        int [] stu2 = {2,1,2,3,2,4,2,5};
        int [] stu3 = {3,3,1,1,2,2,4,4,5,5};
        int cnt1 = 0 ;
        int cnt2 = 0 ;
        int cnt3 = 0 ;

        int [] stu1pattern = new int [answers.length];
        int [] stu2pattern = new int [answers.length];
        int [] stu3pattern = new int [answers.length];

        for(int i = 0; i < answers.length; i++){
            stu1pattern[i] = stu1[i % stu1.length];
            stu2pattern[i] = stu2[i % stu2.length];
            stu3pattern[i] = stu3[i % stu3.length];

            if(stu1pattern[i] == answers[i]) cnt1++;
            if(stu2pattern[i] == answers[i]) cnt2++;
            if(stu3pattern[i] == answers[i]) cnt3++;
        }

        int max = Math.max(cnt1, Math.max(cnt2, cnt3));

        ArrayList<String> list = new ArrayList<String>();

        if(cnt1 == max) list.add("1");
        if(cnt2 == max) list.add("2");
        if(cnt3 == max) list.add("3");

        String [] strings = new String[list.size()];

        int i = 0;
        for(String s : list){
            strings[i] = s;
            i++;
        }
        int[] answer = new int[strings.length];

        for(int j = 0; j < strings.length; j++){
            answer[j] = Integer.parseInt(strings[j]);
        }

        return answer;
    }
}



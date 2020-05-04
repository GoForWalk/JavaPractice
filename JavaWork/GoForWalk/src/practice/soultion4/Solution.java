package practice.soultion4;

public class Solution {

    public int[] solution(int[] answers) {
        int[] answer = {};

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
            stu2pattern[i] = stu1[i % stu2.length];
            stu1pattern[i] = stu1[i % stu3.length];

            if(stu1pattern[i] == answers[i]) cnt1++;
            if(stu2pattern[i] == answers[i]) cnt2++;
            if(stu3pattern[i] == answers[i]) cnt3++;
        }

        int max = Math.max(cnt1, Math.max(cnt2, cnt3));
        if(cnt1 == cnt2 && cnt1 == cnt3) {
            answer = {1,2,3};
        } else if (cnt1 == cnt2 || cnt1 == cnt3 || cnt2 == cnt3){
            switch (max){
                case cnt1:




                        break;


            }
        }


















        return answer;
    }
}

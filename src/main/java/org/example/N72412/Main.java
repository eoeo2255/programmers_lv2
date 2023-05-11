package org.example.N72412;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
}

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        return answer;
    }

    Map<String, List<Integer>> buildScoresMap(String[] info) {
        Map<String, List<Integer>> scoresMap = new HashMap<>();

        for (String infoRow : info) {
            String[] infoRowBits = infoRow.split(" ");

            String languageTypeCode = infoRowBits[0];
            String jobGroupTypeCode = infoRowBits[1];
            String careerTypeCode = infoRowBits[2];
            String foodTypeCode = infoRowBits[3];
            int score = Integer.parseInt(infoRowBits[4]);

            String[] languageTypeCodes = new String[]{"-", languageTypeCode};
            String[] jobGroupTypeCodes = new String[]{"-", jobGroupTypeCode};
            String[] careerTypeCodes = new String[]{"-", careerTypeCode};
            String[] foodTypeCodes = new String[]{"-", foodTypeCode};

            for (String languageTypeCode_ : languageTypeCodes) {
                for (String jobGroupTypeCode_ : jobGroupTypeCodes) {
                    for (String careerTypeCode_ : careerTypeCodes) {
                        for (String foodTypeCode_ : foodTypeCodes) {
                            String key = languageTypeCode_ + " " + jobGroupTypeCode_ + " " + careerTypeCode_ + " " + foodTypeCode_;

                            scoresMap.putIfAbsent(key, new ArrayList<>()); // key가 없으면 새로운 ArrayList를 value로 넣어줌
                            scoresMap.get(key).add(score);                              //  value 값을 먼저 넣고 key 값을 넣음
                        }
                    }
                }
            }
        }

        // scoresMap 을 key 값 기준으로 정렬
        scoresMap.forEach((key, scores) -> scores.sort(Integer::compareTo));

        return scoresMap;
    }

    public int countBiggerThan(List<Integer> scores, int score) {
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) >= score) return scores.size() - i;       //  index는 0부터 시작
        }

        return 0;
    }

}
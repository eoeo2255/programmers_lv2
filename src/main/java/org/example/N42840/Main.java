package org.example.N42840;


import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Solution().solution(new int[]{1, 2, 3, 4, 5})
                )
        );
    }
}

 class Solution {

    public int[] solution(int[] answer) {
        int maxPoint = Stream.of(student1(answer), student2(answer), student3(answer))
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();

        return new int[]{maxPoint};
    }

    private int student1(int[] answer) {
        return scoring(answer, new int[]{1, 2, 3, 4, 5});
    }

    private int student2(int[] answer) {
        return scoring(answer, new int[]{2, 1, 2, 3, 2, 4, 2, 5});
    }

    private int student3(int[] answer) {
        return scoring(answer, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});
    }

    private int scoring(int[] answers, int[] submit) {      // 정답패턴 배열과 답안 배열을 비교해 맞은 개수를 반환
        int score = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == submit[i % submit.length]) {
                score++;
            }
        }
        return score;
    }
}

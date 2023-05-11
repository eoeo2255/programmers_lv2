package org.example.N72412;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Tests {

    private final String[] query = new String[]{
            "java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200",
            "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150",
            "- and - and - and chicken 100",
            "- and - and - and - 150"
    };
    private final String[] info = new String[]{
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50"
    };

    @Test
    @DisplayName("python frontend senior chicken -> 150, 210")      //  점수를 반환
    void t01() {
        Map<String, List<Integer>> scoresMap = new Solution().buildScoresMap(info);

        List<Integer> scores = scoresMap.get("python frontend senior chicken");

        assertThat(scores).containsExactly(150, 210);
    }

    @Test
    @DisplayName("java - - - → 80, 150")
    void t02() {
        Map<String, List<Integer>> scoresMap = new Solution().buildScoresMap(info);

        List<Integer> scores = scoresMap.get("java - - -");

        assertThat(scores).containsExactly(80, 150);
    }

    @Test
    @DisplayName("[2, 4, 6, 8, 10, 12, 14], 8 → 4")     //  score 보다 크거나 같은 값의 개수 찾기
    void t03() {
        assertThat(
                new Solution().countBiggerThan(List.of(2, 4, 6, 8, 10, 12, 14), 8)
        ).isEqualTo(4);
    }

    @Test
    @DisplayName("solution")
    void t04() {
        assertThat(
                new Solution().solution(info, query)
        ).containsExactly(1, 1, 1, 1, 2, 4);
    }

}

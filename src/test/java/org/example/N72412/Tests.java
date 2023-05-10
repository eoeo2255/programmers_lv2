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
    private final String[] info = new String[]{
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50"
    };

    @Test
    @DisplayName("python frontend senior chicken -> 150, 210")
    void t01() {
        Map<String, List<Integer>> scoresMap = new Solution().buildScores(info);

        List<Integer> scores = scoresMap.get("python frontend senior chicken");

        assertThat(scores).containsExactly(150, 210);
    }

}

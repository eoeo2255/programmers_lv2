package org.example.N42860;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Tests {

    @Test
    @DisplayName("BAA => 1")
    void t01() {assertThat(new Solution()
            .solution("BAA"))
            .isEqualTo(1)
        ;
    }

    @Test
    @DisplayName("CAA => 2")
    void t02() {
        assertThat(
                new Solution().solution("CAA")
        ).isEqualTo(
                2
        );
    }

    @Test
    @DisplayName("BBA → 3")
    void t03() {
        assertThat(
                new Solution().solution("BBA")
        ).isEqualTo(
                3
        );
    }

    @Test
    @DisplayName("ZBA → 3")
    void t04() {
        assertThat(
                new Solution().solution("ZBA")
        ).isEqualTo(
                3
        );
    }

    @Test
    @DisplayName("O → 12")
    void t05() {
        assertThat(
                new Solution().solution("O")
        ).isEqualTo(
                12
        );
    }

    @Test
    @DisplayName("N → 13")
    void t06() {
        assertThat(
                new Solution().solution("N")
        ).isEqualTo(
                13
        );
    }

    @Test
    @DisplayName("KAABC, directionCheck → 4")
    void t07() {
        assertThat(
                new Solution().directionCheck("KAABC")
        ).isEqualTo(
                4
        );
    }

    @Test
    @DisplayName("KAABCAAA, directionCheck → 4")
    void t08() {
        assertThat(
                new Solution().directionCheck("KAABCAAA")
        ).isEqualTo(
                4
        );
    }

    @Test
    @DisplayName("KAABC, directionCheck2 → 2")
    void t09() {
        assertThat(
                new Solution().directionCheck2("KAABC")
        ).isEqualTo(
                2
        );
    }

    @Test
    @DisplayName("KAABCAAA, directionCheck2 → 5")
    void t010() {
        assertThat(
                new Solution().directionCheck2("KAABCAAA")
        ).isEqualTo(
                5
        );
    }

    @Test
    @DisplayName("AAAAA, directionCheck2 → 0")
    void t011() {
        assertThat(
                new Solution().directionCheck2("AAAAA")
        ).isEqualTo(
                0
        );
    }

    @Test
    @DisplayName("KBAAAATK, longestContinuumLengthAndIndex → index = 2, length = 4")
    void t012() {
        assertThat(
                Ut.getLongestContinuumLengthAndIndex("KBAAAATK", 'A')
        ).isEqualTo(
                new Ut.longestContinuumLengthAndIndex(2,4)
        );
    }

    @Test
    @DisplayName("Ut.longestContinuumLengthAndIndex(\"KAAAABAAAATK\", 'A') → rs.index: 1, rs.length: 4")
    void t13() {
        assertThat(
                Ut.getLongestContinuumLengthAndIndex("KAAAABAAAATK", 'A')
        ).isEqualTo(
                new Ut.longestContinuumLengthAndIndex(1, 4)
        );
    }

    @Test
    @DisplayName("ABCDAAAAKK, directionCheck3 → 7")
    void t14() {
        assertThat(
                new Solution().directionCheck3("ABCDAAAAKK")
        ).isEqualTo(
                7
        );
    }

    @Test
    @DisplayName("ADAAAABCDKK, directionCheck3 → 11")
    void t15() {
        assertThat(
                new Solution().directionCheck3("ADAAAABCDKK")
        ).isEqualTo(
                11
        );
    }

    @Test
    @DisplayName("ADAAAABCDKK, directionCheck4 → 7")
    void t16() {
        assertThat(
                new Solution().directionCheck4("ADAAAABCDKK")
        ).isEqualTo(
                7
        );
    }

    @Test
    @DisplayName("KKAAE, directionCheck4 → 3")
    void t17() {
        assertThat(
                new Solution().directionCheck4("KKAAE")
        ).isEqualTo(
                3
        );
    }

    @Test
    @DisplayName("ADAAAABCDKK, moveCost → 7")
    void t18() {
        assertThat(
                new Solution().moveCount("ADAAAABCDKK")
        ).isEqualTo(
                7
        );
    }

    @Test
    @DisplayName("JEROEN, solution → 56")
    void t19() {
        assertThat(
                new Solution().solution("JEROEN")
        ).isEqualTo(
                56
        );
    }

    @Test
    @DisplayName("JAN, solution → 23")
    void t20() {
        assertThat(
                new Solution().solution("JAN")
        ).isEqualTo(
                23
        );
    }

}

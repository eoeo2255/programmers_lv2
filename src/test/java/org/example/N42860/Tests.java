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
    @DisplayName("KAABC, onlyMoveCount → 4")
    void t07() {
        assertThat(
                new Solution().directionCheck("KAABC")
        ).isEqualTo(
                4
        );
    }

    @Test
    @DisplayName("KAABCAAA, onlyMoveCount → 4")
    void t08() {
        assertThat(
                new Solution().directionCheck("KAABCAAA")
        ).isEqualTo(
                4
        );
    }

    @Test
    @DisplayName("KAABC, onlyMoveCount → 2")
    void t09() {
        assertThat(
                new Solution().directionCheck2("KAABC")
        ).isEqualTo(
                2
        );
    }

    @Test
    @DisplayName("KAABCAAA, onlyMoveCount → 5")
    void t010() {
        assertThat(
                new Solution().directionCheck2("KAABCAAA")
        ).isEqualTo(
                5
        );
    }

    @Test
    @DisplayName("AAAAA, onlyMoveCount → 0")
    void t011() {
        assertThat(
                new Solution().directionCheck2("AAAAA")
        ).isEqualTo(
                0
        );
    }

}
